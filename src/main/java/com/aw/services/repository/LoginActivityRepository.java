package com.aw.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aw.services.model.UserActivity;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LoginActivityRepository extends CrudRepository<UserActivity, Integer> {
	@Query(value = "select * from user_activity ua where ua.usertable_id = :id", nativeQuery=true)
	public List<UserActivity> findAllUserActivity(@Param("id") int id);
}
