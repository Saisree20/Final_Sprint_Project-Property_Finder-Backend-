package com.example.propertyFinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.propertyFinder.dto.LoginDTO;
import com.example.propertyFinder.entity.Login;
import com.example.propertyFinder.service.ILoginService;

@RestController
@RequestMapping("/Login")
public class LoginController {
	
	@Autowired
	ILoginService iloginService;
	
	@PostMapping("/register")
	Login register(@RequestBody LoginDTO loginDTO) {
		return iloginService.register(loginDTO);
	}
	
	@GetMapping("/getLogin/{userName}")
	Login login(@PathVariable String userName) {
		return iloginService.login(userName);
	}
	
	@GetMapping("/validateLogin")
	boolean validateLogin(@RequestParam String userName,@RequestParam String password) {
		return iloginService.validateLogin(userName,password);
	}
	
}
