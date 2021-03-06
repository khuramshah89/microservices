package com.eureka.client.service.imageservice.Controller;

import com.eureka.client.service.imageservice.Model.Image;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Khuram on 1/27/2020.
 */
@RestController
@RequestMapping("/")
public class ImagesController {

    @GetMapping("/images")
    public List<Image> getImages() {
        System.out.println("called images end point. ");
        List<Image> images = Arrays.asList(
                new Image(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
                new Image(2, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
                new Image(3, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"));
        return images;
    }

    @RequestMapping(value = "/img")
    public Image getImage() {
        return new Image(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760");
    }

}