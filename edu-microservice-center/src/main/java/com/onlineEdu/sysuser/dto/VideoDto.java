package com.onlineEdu.sysuser.dto;

import lombok.Data;

@Data
public class VideoDto {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private Boolean free;
    private String videoSourceId;
}
