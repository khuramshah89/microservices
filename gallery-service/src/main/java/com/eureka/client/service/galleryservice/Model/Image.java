package com.eureka.client.service.galleryservice.Model;

/**
 * Created by Khuram on 1/30/2020.
 */
public class Image {
    private Integer id;
    private String title;
    private String url;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
