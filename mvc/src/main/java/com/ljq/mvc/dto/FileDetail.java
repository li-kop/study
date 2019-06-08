package com.ljq.mvc.dto;

import lombok.Data;

/**
 * @author : LJQ
 * @date : 2019/6/7 15:02
 */
@Data
public class FileDetail {

    private String path;

    public FileDetail(String path) {
    this.path=path;
    }
}
