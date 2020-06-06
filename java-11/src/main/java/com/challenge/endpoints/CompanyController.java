package com.challenge.endpoints;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/company")
public class CompanyController {
	
	private CompanyService service;

    @GetMapping("/{id}")
    public Company findById(@PathVariable Long id){
        return service.findById(id).orElse(null);
    }
    
    @GetMapping
    public List<Company> findAll(@RequestParam(value = "userId", required = false) Long userId, @RequestParam(value = "accelerationId", required = false) Long accelerationId){
        if (userId != null)
            return service.findByUserId(userId);
        if (accelerationId != null)
            return service.findByAccelerationId(accelerationId);
        return Collections.emptyList();
    }
}
