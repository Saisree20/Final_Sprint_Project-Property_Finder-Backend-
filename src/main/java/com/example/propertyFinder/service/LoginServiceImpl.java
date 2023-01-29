package com.example.propertyFinder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.propertyFinder.dto.LoginDTO;
import com.example.propertyFinder.entity.Login;
import com.example.propertyFinder.exception.AlreadyExistsException;
import com.example.propertyFinder.exception.DoesnotExistsException;
import com.example.propertyFinder.repository.LoginRepo;

@Service
public class LoginServiceImpl implements ILoginService{
	

	@Autowired
	private LoginRepo loginRepo;

	@Override
	public Login register(LoginDTO loginDTO) {
		if(loginRepo.findById(loginDTO.getUserName()).isEmpty()) {
			Login login = new Login(
					loginDTO.getUserName(),
					loginDTO.getPassword(),
					loginDTO.getRole().toString(),
					loginDTO.getMobileNumber());
			return loginRepo.save(login);
		}
		else {
			throw new AlreadyExistsException("User already exists with this userID "+loginDTO.getUserName());
		}
	}

	@Override
	public Login login(String userName) {
		try {
			return loginRepo.findById(userName).get();
		}
		catch(Exception e) {
			throw new DoesnotExistsException("User doesnt not exists " +userName);
		}
	}

	@Override
	public boolean validateLogin(String userName, String password) {
		Optional<Login> obj = loginRepo.findById(userName);
		return obj.get().getPassword().equals(password);
	}
	
	
}
