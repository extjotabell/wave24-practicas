package com.exceptions.starwars.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProfileServiceProd implements IProfileService{

    @Override
    public String getThisProfile() {
        return "Estamos en el perfil de prod";
    }
}
