package com.todo.raul.business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.raul.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUser(String user);
}
