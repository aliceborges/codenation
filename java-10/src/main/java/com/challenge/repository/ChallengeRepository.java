package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Challenge;

@Repository
@Component
public interface ChallengeRepository extends JpaRepository<Challenge,Long> {
	@Query(value = "select distinct challenge.* from challenge inner join acceleration " +
            "on challenge.id = acceleration.challenge_id AND acceleration.id = :accelerationId " +
            "inner join candidate on acceleration.id = candidate.acceleration_id " +
            "inner join users on candidate.user_id = users.id and users.id = :userId ",
            nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);
}
