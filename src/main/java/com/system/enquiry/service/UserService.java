package com.system.enquiry.service;

import java.util.List;

import com.common.entity.User;


/**
 * @author laxman
 *
 */
public interface UserService {

	/**
	 * @param id
	 * @return
	 */
	User findById(long id);

	/**
	 * @param emailId
	 * @return
	 */
	User findByEmailId(String emailId);

	/**
	 * @param user
	 * @return
	 */
	Long saveUser(User user);

	/**
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * @param id
	 */
	void deleteUserById(long id);

	/**
	 * @return
	 */
	List<User> findAllUsers();

	/**
	 * @param user
	 * @return
	 */
	User isUserExist(User user);

}
