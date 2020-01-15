package com.onlineEdu.sysuser.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("modifierId", new Long(111), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
        this.setFieldValByName("creatorId", new Long(111), metaObject);
        this.setFieldValByName("gmtCreate",new Date(), metaObject);
        this.setFieldValByName("availableFlag",true, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject){
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
