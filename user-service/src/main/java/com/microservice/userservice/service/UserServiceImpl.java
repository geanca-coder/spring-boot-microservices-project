package com.microservice.userservice.service;

import com.microservice.userservice.VO.Department;
import com.microservice.userservice.VO.ResponseTemplate;
import com.microservice.userservice.entity.User;
import com.microservice.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        log.info("Inside saveUser of UserServiceImpl");
        return userRepository.save(user);
    }

    @Override
    public ResponseTemplate getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplate vo = new ResponseTemplate();
        User user = userRepository.findByUserId(userId);
        Department department
                = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId() ,
                Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
