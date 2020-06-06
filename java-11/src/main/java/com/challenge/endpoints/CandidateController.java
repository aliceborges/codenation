package com.challenge.endpoints;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.CandidateDTO;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/candidate")
public class CandidateController {
	private CandidateService service;
	private CandidateMapper mapper;
	
	@GetMapping("/{userId}/{accelerationId}/{companyId}")
    public CandidateDTO findById(@PathVariable Long userId, @PathVariable  Long accelerationId, @PathVariable Long companyId){
        return mapper.map(service.findById(userId, companyId, accelerationId).orElse(null));
    }
	
	@GetMapping
    public List<CandidateDTO> findAll(@RequestParam(value = "accelerationId", required = false) Long accelerationId, @RequestParam(value = "companyId", required = false) Long companyId){
        if (accelerationId != null)
            return mapper.map(service.findByAccelerationId(accelerationId));
        if (companyId != null)
            return mapper.map(service.findByCompanyId(companyId));
        return Collections.emptyList();
    }
}
