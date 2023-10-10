package com.topicosespeciais.todolist.controller;

import com.topicosespeciais.todolist.model.Task;
import com.topicosespeciais.todolist.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "html/list";
    }

    @PostMapping("/add")
    public String addTask(Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/markCompleted/{id}")
    public String markTaskCompleted(@PathVariable Long id) {
        Task task = taskRepository.findById(id).get();
        task.setCompleted(true);
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }
}
