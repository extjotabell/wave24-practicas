package com.exceptions.starwars.controller;

import com.exceptions.starwars.service.IProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    private IProfileService profileService;

    public ProfileController(IProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping()
    public String getProfile(){
        return profileService.getThisProfile();
    }

}
