package com.todo.raul.business;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.raul.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	public List<Task> findByStatus(String status);

	
	
}
