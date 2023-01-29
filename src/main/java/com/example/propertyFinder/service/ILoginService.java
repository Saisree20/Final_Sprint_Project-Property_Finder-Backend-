package com.example.propertyFinder.service;

import com.example.propertyFinder.dto.LoginDTO;
import com.example.propertyFinder.entity.Login;

public interface ILoginService {

	Login register(LoginDTO loginDTO);

	Login login(String userName);

	boolean validateLogin(String userName, String password);

}
