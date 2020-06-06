package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Submission;

@Repository
@Component
public interface SubmissionRepository extends JpaRepository<Submission, Long>{
	 @Query(value = "select max(s.score) from submission s join challenge c\n" + 
				"on c.id = s.challenge_id and c.id = :challengeId",
			 		nativeQuery = true)
	 BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);
	 
	 @Query(value = "select distinct s.* from submission s " + 
			 		"join (challenge cha join acceleration acc on cha.id = acc.challenge_id) " + 
			 		"on s.challenge_id = cha.id and acc.id = :accelerationId and cha.id = :challengeId",
			 nativeQuery = true)
	 List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);

}
