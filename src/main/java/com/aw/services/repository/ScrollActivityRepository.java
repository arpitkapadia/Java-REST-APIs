package com.aw.services.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;

import com.aw.services.model.QuestionClickActivity;
import com.aw.services.model.ScrollActivity;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ScrollActivityRepository extends CrudRepository<ScrollActivity, Integer> {
	@Query(value = "select * from scroll_activity ua where ua.usertable_id = :id order by ua.timestamp desc", nativeQuery=true)
	public List<ScrollActivity> findAllUserScrollActivity(@Param("id") int id);


}
