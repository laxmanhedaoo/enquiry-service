package com.system.enquiry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.entity.User;
import com.system.enquiry.repository.UserRepository;
import com.system.enquiry.service.UserService;

/**
 * @author laxman
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	/**
	 * 
	 */
	@Autowired
	UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.system.enquiry.service.UserService#findById(long)
	 */
	@Override
	public User findById(long id) {
		return userRepository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.system.enquiry.service.UserService#findByEmailId(java.lang.String)
	 */
	@Override
	public User findByEmailId(String emailId) {
		return userRepository.findByEmailId(emailId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.system.enquiry.service.UserService#saveUser(com.system.enquiry.entity
	 * .User)
	 */
	@Override
	public Long saveUser(User user) {
		return userRepository.save(user)
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.system.enquiry.service.UserService#updateUser(com.system.enquiry.
	 * entity.User)
	 */
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.system.enquiry.service.UserService#deleteUserById(long)
	 */
	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.system.enquiry.service.UserService#findAllUsers()
	 */
	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.system.enquiry.service.UserService#isUserExist(com.system.enquiry.
	 * entity.User)
	 */
	@Override
	public User isUserExist(User user) {
		return userRepository.isUserExist(user.getUserName());
	}

}
