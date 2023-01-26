package com.todo.raul.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

import com.todo.raul.model.User;




@Service
public class UserService implements UserDetailsService{

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	// GetAll
	public List<User> getAll() {
		return userRepository.findAll();
	}

	// getByid
	public User getById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}

	// Create
	public User createUser(User user) {
		return userRepository.save(user);
	}

	// Delete
	public boolean deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUser(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUser(), user.getPassword(), emptyList());
	}

}
