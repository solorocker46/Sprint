package com.cg.nsa.service;

import java.util.List;

import com.cg.nsa.entity.Scholarship;

public interface IScholarshipService {

	Scholarship statusUpdate(Scholarship scholarship);

	List<Scholarship> getAllScholarships();
}
