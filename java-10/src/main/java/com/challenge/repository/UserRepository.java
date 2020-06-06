package com.challenge.repository;
import com.challenge.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Long>{
	@Query(value = "select distinct users.* from users join candidate on candidate.user_id = users.id \n" + 
			"join acceleration on acceleration.id = candidate.acceleration_id and acceleration.name = :name", nativeQuery = true)
	List<User> findByAccelerationName(@Param("name") String name);
	
	@Query(value = "select distinct users.* from users join (candidate join company on company.id = candidate.company_id\n" + 
			"and company.id = :companyId) on candidate.user_id = users.id", nativeQuery = true)
	List<User> findByCompanyId(@Param("companyId") Long companyId);
}
