package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Acceleration;

@Repository
@Component
public interface AccelerationRepository extends JpaRepository<Acceleration, Long>{
	@Query(value = "select distinct acc.* from acceleration acc \n" + 
			"join (candidate ca on acc.id = ca.acceleration_id) \n" +  
			"join (company co on co.id = ca.company_id and co.id = :companyId) \n", 
			nativeQuery = true)
	List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}
