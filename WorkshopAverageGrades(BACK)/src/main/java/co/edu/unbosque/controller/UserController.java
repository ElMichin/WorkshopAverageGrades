package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.model.User;
import co.edu.unbosque.service.UserService;
import co.edu.unbosque.util.AESUtil;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8081", "*" })
@Transactional
public class UserController {

	private AESUtil aes;

	@Autowired
	private UserService userServ;

	public UserController() {
		aes = new AESUtil();
	}

	@PostMapping(path = "/createuserjson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createNewUserWithJson(@RequestBody User newUser) {
		String result = userServ.calculateAverage(newUser.getFirstCut(), newUser.getSecondCut(), newUser.getThirdCut()); 
		User encryptedUser = new User(aes.encrypt(newUser.getUsername()), aes.encrypt(newUser.getFirstCut()),
				aes.encrypt(newUser.getSecondCut()), aes.encrypt(newUser.getThirdCut()),
				aes.encrypt(result));
		int status = userServ.create(encryptedUser);
		if (status == 0) {
			return new ResponseEntity<String>("User succesfuly created", HttpStatus.CREATED);
		} 
			return new ResponseEntity<String>("Error creating the user.", HttpStatus.NOT_ACCEPTABLE);
		}
	

	@GetMapping(path = "/getall")
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userServ.getAll();
		List<User> descryptedUsers = new ArrayList<>();
		for (User user : users) {
			User descryptUser = new User(aes.decrypt(user.getUsername()), aes.decrypt(user.getFirstCut()),
					aes.decrypt(user.getSecondCut()), aes.decrypt(user.getThirdCut()), aes.decrypt(user.getResult()));
			descryptUser.setId(user.getId());
			descryptedUsers.add(descryptUser);
		}
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(descryptedUsers, HttpStatus.NO_CONTENT);
		} 
			return new ResponseEntity<List<User>>(descryptedUsers, HttpStatus.ACCEPTED);
		}

	}
