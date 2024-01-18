package com.mercadolibre.be_java_hisp_w24_g02.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private List<User> followers = new ArrayList<>();
    private List<User> followed = new ArrayList<>();
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
