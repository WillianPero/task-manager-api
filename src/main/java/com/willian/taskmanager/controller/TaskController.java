package com.willian.taskmanager.controller;

import com.willian.taskmanager.model.Task;
import com.willian.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // LISTAR TODAS
    @GetMapping
    public List<Task> listar() {
        return service.listar();
    }

    // CRIAR
    @PostMapping
    public Task criar(@RequestBody Task task) {
        return service.criar(task);
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Task buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "Task deletada com sucesso";
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Task atualizar(@PathVariable Long id, @RequestBody Task updatedTask) {
        return service.atualizar(id, updatedTask);
    }
}

