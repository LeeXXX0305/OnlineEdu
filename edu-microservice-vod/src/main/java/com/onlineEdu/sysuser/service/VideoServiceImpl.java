package com.onlineEdu.sysuser.service;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.onlineEdu.common.constants.ResultCodeEnum;
import com.onlineEdu.common.exception.GuliException;
import com.onlineEdu.sysuser.util.AliyunVODSDKUtils;
import com.onlineEdu.sysuser.util.ConstantPropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VideoServiceImpl implements VideoService {
    @Override
    public String uploadVideo(MultipartFile file) {

        String fileName = file.getOriginalFilename();
        String title = fileName.substring(0, fileName.lastIndexOf("."));
//        InputStream inputStream = null;
//        try{
//            inputStream = file.getInputStream();
//        }catch(IOException e){
//            throw new GuliException(ResultCodeEnum.VIDEO_UPLOAD_ERROR);
//        }
        UploadVideoRequest request = new UploadVideoRequest(
                ConstantPropertiesUtil.ACCESS_KEY_ID,
                ConstantPropertiesUtil.ACCESS_KEY_SECRET,
                title,
                fileName
        );
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadVideoResponse response = uploader.uploadVideo(request);

        String videoId = response.getVideoId();
        if (!response.isSuccess()) {
            //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。
            // 其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
            if(StringUtils.isEmpty(videoId)){
                throw new GuliException(ResultCodeEnum.VIDEO_UPLOAD_ERROR);
            }
        }
        return videoId;
    }

    @Override
    public String getVideoPlayAuth(String videoId) {

        DefaultAcsClient client = null;
        try {

            //初始化
            client = AliyunVODSDKUtils.initVodClient(
                    ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET
            );

            //创建请求对象:为请求对象组织私有参数
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            request.setVideoId(videoId);

            //响应对象
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);

            //获取播放凭证
            String playAuth = response.getPlayAuth();

            return playAuth;

        }catch (ClientException e){
            throw  new GuliException(ResultCodeEnum.FETCH_VIDEO_PLAYAUTH_ERROR);
        }
    }
}
