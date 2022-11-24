package com.microservice.userservice.service;

import com.microservice.userservice.VO.ResponseTemplate;
import com.microservice.userservice.entity.User;

public interface UserService {

    User saveUser(User user);

    ResponseTemplate getUserWithDepartment(Long userId);
}
