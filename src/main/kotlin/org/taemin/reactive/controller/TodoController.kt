package org.taemin.reactive.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.taemin.reactive.domain.Todo
import org.taemin.reactive.dto.TodoRequest
import org.taemin.reactive.service.TodoService
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/todo")
class TodoController(private val todoService: TodoService) {

    @GetMapping()
    fun getTodos(): Flux<Todo> {
        return todoService.todoList()
    }

    @GetMapping("/notDone")
    fun getTodoListByNotDone(): Flux<Todo> {
        return todoService.todoListByNotDone()
    }

    @PutMapping
    fun updateTodo(@RequestBody request: TodoRequest): Mono<Todo> {
        return todoService.updateContent(request)
    }

    @PutMapping("/success/{id}")
    fun successTodo(@PathVariable id: Long): Mono<Todo> {
        return todoService.successTodo(id)
    }

    @PostMapping
    fun saveTodo(@RequestBody request: TodoRequest): Mono<Todo> {
        return todoService.saveTodo(request)

    }


}