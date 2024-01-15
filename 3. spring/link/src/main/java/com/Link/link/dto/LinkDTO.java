package com.Link.link.dto;

public record LinkDTO(String url, int id){

    public LinkDTO(String url, int id) {
        this.url = url;
        this.id = id;
    }
}
