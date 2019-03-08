package com.liqihua.demo.dto;

import java.io.Serializable;

/**
 * @author liqihua
 * @since 2019/3/8
 */
public class OrderDTO implements Serializable {

    private Integer id;

    private String code;

    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
