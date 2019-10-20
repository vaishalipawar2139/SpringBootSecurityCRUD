package com.vaispa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vaispa.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String uname);

	// select * from user where email_id = ?1 and last_name = ?2;

	// select c from User c where c.email = ?1 and c.lastName = ?2

	@Query(value = "select * from user where username = ?1", nativeQuery = true)
	public User findUsername(String uname);
	
	@Query(value = "select username from user where username = ?1", nativeQuery = true)
	public String findOnlyUsername(String uname);

}
