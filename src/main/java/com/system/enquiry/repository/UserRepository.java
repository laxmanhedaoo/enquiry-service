package com.system.enquiry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.common.entity.User;


/**
 * @author laxman
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * @param emailId
	 * @return
	 */
	User findByEmailId(String emailId);

	/**
	 * @param username
	 * @return
	 */
	@Query("SELECT u from User u where u.userName = ?1")
	User isUserExist(String username);
}
