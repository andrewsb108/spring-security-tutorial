package com.codebuffer.client.service;

import com.codebuffer.client.entity.User;
import com.codebuffer.client.model.UserModel;

public interface UserService {

    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
