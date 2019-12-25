package com.onlineEdu.vod.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChapterDto {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private List<VideoDto> children = new ArrayList<>();
}
