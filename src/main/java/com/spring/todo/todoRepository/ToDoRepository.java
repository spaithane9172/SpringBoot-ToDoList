package com.spring.todo.todoRepository;

import org.springframework.data.repository.CrudRepository;

import com.spring.todo.entity.Task;

public interface ToDoRepository extends CrudRepository<Task, Integer> {

}
