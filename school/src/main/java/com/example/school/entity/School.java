package com.example.school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class School {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
}
