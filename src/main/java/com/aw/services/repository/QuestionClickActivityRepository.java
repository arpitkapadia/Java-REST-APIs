

package com.aw.services.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;
import com.aw.services.model.ClickActivity;
import com.aw.services.model.QuestionClickActivity;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface QuestionClickActivityRepository extends CrudRepository<QuestionClickActivity, Integer> {
	@Query(value = "select * from question_click_activity ua where ua.usertable_id = :id order by ua.timestamp desc", nativeQuery=true)
	public List<QuestionClickActivity> findAllUserQClickActivity(@Param("id") int id);


}