package com.dptcldpa.instalogram.user.service;

import org.springframework.stereotype.Service;

import com.dptcldpa.instalogram.common.SHA256HashingEncoder;
import com.dptcldpa.instalogram.user.domain.User;
import com.dptcldpa.instalogram.user.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

//	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean addUser(
			String loginId
			, String password
			, String name
			, String email) {
		
		String encodingPassword = SHA256HashingEncoder.encode(password);
		
		int count = userRepository.insertUser(loginId, encodingPassword, name, email);
		
		if(count == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean isDuplicatedId(String loginId) {
		
		int count = userRepository.selectCountLoginId(loginId);
		
		if(count > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public User getUser(String loginId, String password) {
		
		String encodingPassword = SHA256HashingEncoder.encode(password);
		
		return userRepository.selectUser(loginId, encodingPassword);
		
	}
	
	public User getUserById(int id) {
		return userRepository.selectUserById(id);
	}
	
	
}
