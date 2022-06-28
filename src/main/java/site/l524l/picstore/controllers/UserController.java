package site.l524l.picstore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import site.l524l.picstore.converters.RolesSetConverter;
import site.l524l.picstore.objects.AddUserRequest;
import site.l524l.picstore.objects.RegisterRequest;
import site.l524l.picstore.objects.SetRolesRequest;
import site.l524l.picstore.user.User;
import site.l524l.picstore.user.UserService;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('CATEGORY_ADMIN')")
public class UserController {
	
	private UserService userService;
	private RolesSetConverter setConverter;

	
	public UserController(UserService userService, RolesSetConverter setConverter) {
		this.userService = userService;
		this.setConverter = setConverter;
	}
	
	
	
	@RequestMapping("/add")
	public ResponseEntity<?> add(AddUserRequest request) {
		if(userService.isUserExist(request.getUsername())) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
		User user = userService
				.register(new RegisterRequest(request.getUsername(), request.getPassword()));
		
		user.setRoles(setConverter.convert(request.getRoles()));
		
		userService.save(user);
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/setRoles")
	public ResponseEntity<?> setRoles(SetRolesRequest request) {
		if(userService.isUserExist(request.getUsername()) == false) 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
		User user = userService.get(request.getUsername());
		
		user.setRoles(setConverter.convert(request.getRoles()));
		
		userService.save(user);
		
		return ResponseEntity.ok().build();
	}
}
