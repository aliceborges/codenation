package com.challenge.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
@Table(name = "acceleration")
public class Acceleration {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
    @NotNull
    @Size(max = 100)
	private String name;
	
	@Column
    @NotNull
    @Size(max = 50)
	private String slug;
	
	@ManyToOne
	private Challenge challenge;
	
	@Column
    @CreatedDate
    @NotNull
    private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSlug() {
		return slug;
	}



	public void setSlug(String slug) {
		this.slug = slug;
	}



	public Challenge getChallenge() {
		return challenge;
	}



	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public List<Candidate> getCandidates() {
		return candidates;
	}



	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}



	@OneToMany(mappedBy="acceleration_id")
	private List<Candidate> candidates;
	
}
