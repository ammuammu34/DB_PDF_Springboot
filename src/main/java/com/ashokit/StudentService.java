package com.ashokit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StudentService {
	

		@Autowired
		private StudentPdfRepository repo;

		public List<Student> listAll(){
			return repo.findAll();
		}

	}


