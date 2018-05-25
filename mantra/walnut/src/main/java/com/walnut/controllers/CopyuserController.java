package com.walnut.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.walnut.model.UserModel;
import com.walnut.services.UserRepository;

@Controller
public class CopyuserController {
	@Autowired
	UserRepository userRepo;

	@GetMapping("/copylogin")
	public ResponseEntity login(UserModel userModel) {
		UserModel model = userRepo.findUser(userModel.getEmail(), userModel.getPassword());
		return new ResponseEntity<UserModel>(model, HttpStatus.OK);
	}
}
