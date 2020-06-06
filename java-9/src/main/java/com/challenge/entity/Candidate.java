package com.challenge.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
@Table(name = "candidate")
public class Candidate {
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Acceleration acceleration;
	
	@ManyToOne
	private Company company;
	
	@Column
	@NotNull
	private Integer status;
	
	@Column
    @CreatedDate
    @NotNull
    private LocalDateTime createdAt;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Acceleration getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Acceleration acceleration) {
		this.acceleration = acceleration;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
