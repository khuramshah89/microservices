package com.eureka.client.service.galleryservice.Controller;

import com.eureka.client.service.galleryservice.Model.Gallery;
import com.eureka.client.service.galleryservice.Model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Khuram on 1/27/2020.
 */

@RestController
public class GalleryController {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
    }


    @GetMapping("/{id}")
    public Gallery getGallery(@PathVariable int id) {

        ServiceInstance instance = loadBalancerClient.choose("image-service");
        String baseUrl = instance.getUri().toString();
        baseUrl = baseUrl + "/images";
        System.out.println(baseUrl);
        Gallery gallery = new Gallery();
        gallery.setId(id);

        List<Object> images = restTemplate.getForObject("http://image-service/images", List.class);
//        List<Object> images = restTemplate.getForObject(baseUrl, List.class);
        gallery.setImages(images);

        Image image=restTemplate.getForObject("http://image-service/img",Image.class);
        gallery.setImg(image);

        return gallery;

    }

    // -------- Admin Area --------
    // This method should only be accessed by users with role of 'admin'
    // We'll add the logic of role based auth later
    @RequestMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }
}


