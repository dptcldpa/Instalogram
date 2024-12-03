package com.dptcldpa.instalogram.user.service;

import org.springframework.stereotype.Service;

import com.dptcldpa.instalogram.common.SHA256HashingEncoder;
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
			, String email
			, String bio
			, String profileImage) {
		
		String encodingPassword = SHA256HashingEncoder.encode(password);
		
		int count = userRepository.insertUser(loginId, encodingPassword, name, email, bio, profileImage);
		
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
	
}
