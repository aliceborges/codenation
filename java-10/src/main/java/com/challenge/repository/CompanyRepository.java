package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Company;

@Repository
@Component
public interface CompanyRepository extends JpaRepository<Company,Long> {
	
    @Query(value = "select distinct co.* from company co " + 
    		"join (candidate ca join acceleration acc on ca.acceleration_id = acc.id and acc.id = :accelerationId) " + 
    		"on co.id = ca.company_id",
            nativeQuery = true)
    List<Company> findByAccelerationId(Long accelerationId);
    
    @Query(value = "select distinct co.* from company co " + 
    		"join candidate ca on ca.user_id = :userId and ca.company_id = co.id", nativeQuery = true)
    List<Company> findByUserId(Long userId);

}
