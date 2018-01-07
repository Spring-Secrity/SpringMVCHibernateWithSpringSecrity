package com.anlu.secrity.service;

import com.anlu.secrity.model.UserProfile;

import java.util.List;

public interface UserProfileService {
    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();
}
