package com.eureka.client.service.galleryservice.Model;


import java.util.List;

/**
 * Created by Khuram on 1/27/2020.
 */
public class Gallery {

    private Integer id;
    private List<Object> images;
    private Image img;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
