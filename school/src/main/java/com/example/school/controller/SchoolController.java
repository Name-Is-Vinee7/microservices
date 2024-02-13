package com.example.school.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.school.entity.FullSchoolResponse;
import com.example.school.entity.School;
import com.example.school.service.SchoolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

	private final SchoolService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody School school) {
		service.saveSchool(school);
	}

	@GetMapping
	public ResponseEntity<List<School>> findAllSchools() {
		return ResponseEntity.ok(service.findAllSchools());
	}

	@GetMapping("/with-students/{school-id}")
	public ResponseEntity<FullSchoolResponse> findAllSchools(@PathVariable("school-id") Integer schoolId) {
		return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
	}
}
