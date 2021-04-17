package com.cg.nsa.repository;

import java.util.List;

import com.cg.nsa.entity.Scholarship;

public interface IScholarshipRepository {

	Scholarship statusUpdate(Scholarship scholarship);

	List<Scholarship> fetchAllScholarships();
}
