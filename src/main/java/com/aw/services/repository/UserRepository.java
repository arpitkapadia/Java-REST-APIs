package com.aw.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.aw.services.model.User;

import java.util.Optional;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {	
	//@Query("from User u where u.userId = :uid and u.password = :passd")
	@Query(value = "SELECT * FROM user u where u.user_id= ?1 AND u.password=?2", nativeQuery = true)
	public User findByUserIdPassword(String uId, String pass);
	
	@Query(value="SELECT * FROM user u where u.user_id = :uid", nativeQuery = true)
	public User findUser(@Param("uid") String uId);
	
	
	public User findByUserId(String idd);
	

}
