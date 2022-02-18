package com.hibernate.service;

import java.util.List;

import com.hibernate.model.Assignment;
import com.hibernate.repository.AssignmentRepository;

public class AssignmentService {
	public static AssignmentRepository assignmentRepository = new AssignmentRepository();
	
	public List<Assignment> getAll(){
		return assignmentRepository.getAll();
	}
	
	public boolean insertAssignment(Assignment assignment) {
		return assignmentRepository.insertAssignment(assignment);
	}
}
