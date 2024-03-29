package com.aw.services.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;
import com.aw.services.model.ClickActivity;
import com.aw.services.model.UserActivity;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ClickActivityRepository extends CrudRepository<ClickActivity, Integer> {
	@Query(value = "select * from click_activity ua where ua.usertable_id = :id order by ua.timestamp desc", nativeQuery=true)
	public List<ClickActivity> findAllUserClickActivity(@Param("id") int id);

}