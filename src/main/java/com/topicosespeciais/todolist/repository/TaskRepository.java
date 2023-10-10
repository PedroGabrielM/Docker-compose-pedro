package com.topicosespeciais.todolist.repository;

import com.topicosespeciais.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
