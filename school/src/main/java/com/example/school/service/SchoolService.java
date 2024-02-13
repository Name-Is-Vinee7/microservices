package com.example.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.school.client.StudentClient;
import com.example.school.entity.FullSchoolResponse;
import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {

	private final SchoolRepository repository;
	private final StudentClient client;

	public void saveSchool(School school) {
		repository.save(school);
	}

	public List<School> findAllSchools() {
		return repository.findAll();
	}

	public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
		var school = repository.findById(schoolId)
				.orElse(School.builder().name("NOT_FOUND").email("NOT_FOUND").build());
		var students = client.findAllStudentsBySchool(schoolId);
		return FullSchoolResponse.builder().name(school.getName()).email(school.getEmail()).students(students).build();
	}

}
