package com.willian.taskmanager.service;

import com.willian.taskmanager.model.Task;
import com.willian.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.willian.taskmanager.exception.TaskNotFoundException;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> listar() {
        return repository.findAll();
    }

    public Task criar(Task task) {
        return repository.save(task);
    }

    public Task buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public void deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }

        repository.deleteById(id);
    }

    public Task atualizar(Long id, Task updatedTask) {

        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());

        return repository.save(task);
    }
}
