package com.spring.responseuno.demo.service;


import com.spring.responseuno.demo.entity.Link;
import com.spring.responseuno.demo.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class LinkService {

    @Autowired
    private LinkRepository lr;

    public int saveLinkId(String url){
        if (this.isValidURL(url)){
            lr.agregarLink(url);
            Link link = lr.getLinkList().stream().
                    filter(x -> x.getUrl().equals(url)).findFirst().get();
            return link.getId();
        }

        else {
            return  3;
        }
    }

    public boolean isValidURL(String urlString) {
        try {
            new URL(urlString);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

}
