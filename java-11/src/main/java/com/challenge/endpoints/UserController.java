package com.challenge.endpoints;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private UserService service;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @GetMapping
    public List<User> findAll(@RequestParam(value = "accelerationName", required = false) String accelerationName, @RequestParam(value = "companyId",required = false) Long companyId) {
        if (accelerationName != null)
            return service.findByAccelerationName(accelerationName);
        if (companyId != null)
            return service.findByCompanyId(companyId);
        return Collections.emptyList();
    }

}
