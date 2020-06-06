package com.challenge.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "challenge")
public class Challenge {
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	@OneToMany(mappedBy="challenge_id")
	private List<Submission> submissions;
	
	@OneToMany(mappedBy="challenge_id")
	private List<Acceleration> accelerations;
}
