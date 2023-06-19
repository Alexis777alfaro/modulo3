package com.moduloIII.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moduloIII.Repository.usersRepository;
import com.moduloIII.collections.Users;


@Service
public class UsersService {

	@Autowired
	usersRepository userRepository;
	
	public Users create(Users usersMake) {
		return userRepository.save(usersMake);
	}
	
	 public Users getUserByEmail(String userEmail) {
	        return userRepository.findByEmail(userEmail);
	    }
	
	public List<Users> getAll() {
		return userRepository.findAll();
	}
	
	public Users getById(String id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public Users update(Users updatedUser) {
		return userRepository.save(updatedUser);
	}
	
	public void delete(String id) {
		userRepository.deleteById(id);
	}
	
	public void deleteUserByEmail(String userEmail) {
		userRepository.deleteByEmail(userEmail);
	}
	
	public boolean authenticate(String email, String password) {
		Users user = userRepository.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public Users updateUser(String userEmail, Users updatedUser) {
        Users existingUser = userRepository.findByEmail(userEmail);
        if (existingUser != null) {
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setName(updatedUser.getName());
            existingUser.setPassword(updatedUser.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }
}