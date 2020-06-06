package com.challenge.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/acceleration")
public class AccelerationController {
	
	private AccelerationService service;
	
	@GetMapping("/{id}")
	public Acceleration findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}
	
	@GetMapping
	public List<Acceleration> findAll(@RequestParam(value = "companyId", required = false)Long companyId) {
		return service.findByCompanyId(companyId);
	}
}
