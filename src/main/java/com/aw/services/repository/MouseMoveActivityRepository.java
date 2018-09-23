package com.aw.services.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;
import com.aw.services.model.*;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MouseMoveActivityRepository extends CrudRepository<MouseMoveActivity, Integer> {
	@Query(value = "select * from mouse_move_activity ua where ua.usertable_id = :id order by ua.timestamp desc LIMIT 20", nativeQuery=true)
	public List<MouseMoveActivity> findAllUserMoveActivity(@Param("id") int id);

}

