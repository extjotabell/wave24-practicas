package com.spring.responseuno.demo.repository;

import com.spring.responseuno.demo.entity.Link;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class LinkRepository {

    private List<Link> linkList;
    private int contID;

    public LinkRepository(){
        this.contID = 0;
        this.getLinkList().add(new Link("https://www.ejemplo1.com", 1));
        this.getLinkList().add(new Link("https://www.ejemplo2.com", 2));
        this.getLinkList().add(new Link("https://www.ejemplo3.com", 3));
    }

    public int agregarLink(String url){
        setContID(getContID()+1);
        getLinkList().add(new Link(url,getContID()));
        return getContID();
    }
}
