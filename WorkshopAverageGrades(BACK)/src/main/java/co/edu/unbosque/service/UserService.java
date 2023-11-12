package co.edu.unbosque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.model.User;
import co.edu.unbosque.repository.UserRepository;

@Service
public class UserService implements CRUDOperation<User> {

	@Autowired
	private UserRepository userRepo;

	@Override
	public int create(User data) {
		if (findUsernameAlreadyTaken(data)) {
			return 1;
		} else {
			userRepo.save(data);
			return 0;
		}

	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	public String calculateAverage(String a, String b, String c) {
		Long newA = Long.parseLong(a);
		Long newB = Long.parseLong(b);
		Long newC = Long.parseLong(c);
		Long resultado = newA+newB+newC;
		Long resultado2 = resultado/3;
		System.out.println(resultado2);
		return String.valueOf(resultado2);
		
		
	}
	

	public boolean findUsernameAlreadyTaken(User newUser) {
		Optional<User> found = userRepo.findByUsername(newUser.getUsername());
		if (found.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

}
