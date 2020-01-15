package com.onlineEdu.sysuser.service;

import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
    String uploadVideo(MultipartFile file);
    String getVideoPlayAuth(String videoId);

}
