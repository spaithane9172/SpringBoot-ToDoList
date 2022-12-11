package com.spring.todo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.todo.entity.Task;
import com.spring.todo.todoRepository.ToDoRepository;

@Controller
public class MainController {
    @Autowired
    ToDoRepository toDoRepository;

    @RequestMapping("/")
    public String home(Model m) {
        Iterable<Task> findAll = toDoRepository.findAll();
        m.addAttribute("tasks", findAll);
        return "index";
    }

    @RequestMapping("/addTask")
    public String add() {
        return "addTask";
    }

    @RequestMapping("/updateTask/{id}")
    public String update(@PathVariable("id") int id, Model m) {
        Optional<Task> findById = toDoRepository.findById(id);
        Task task = findById.get();
        m.addAttribute("task", task);
        return "updateTask";
    }

    @RequestMapping("/deleteTask/{id}")
    public String delete(@PathVariable("id") int id) {
        toDoRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/add")
    public String tadd(@ModelAttribute Task task) {
        toDoRepository.save(task);
        return "redirect:/";
    }

    @RequestMapping("/tupdate")
    public String tupdate(@ModelAttribute Task task) {
        toDoRepository.save(task);
        return "redirect:/";
    }

}
