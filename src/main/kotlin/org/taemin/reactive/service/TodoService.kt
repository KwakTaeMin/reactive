package org.taemin.reactive.service

import org.springframework.stereotype.Service
import org.taemin.reactive.domain.Todo
import org.taemin.reactive.dto.TodoRequest
import org.taemin.reactive.repository.TodoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class TodoService(private val todoRepository: TodoRepository) {

    fun todoList(): Flux<Todo> {
        return todoRepository.findAll();
    }

    fun todoListByNotDone(): Flux<Todo> {
        return todoRepository.findAll().filter { todo -> todo.done == false }
    }

    fun updateContent(todoUpdateRequest: TodoRequest): Mono<Todo> {
        return todoRepository.findById(todoUpdateRequest.id!!).singleOptional().flatMap { optionalTodo ->
                Mono.just(optionalTodo.orElseThrow { NoSuchElementException("no such element todo") })
            }.flatMap { existingTodo ->
                existingTodo.updateContent(todoUpdateRequest.content)
                return@flatMap todoRepository.save(existingTodo)
            }
    }

    fun successTodo(id: Long): Mono<Todo> {
        return todoRepository.findById(id).singleOptional().flatMap {
            optionalTodo -> Mono.just(optionalTodo.orElseThrow { NoSuchElementException("")})
        }.flatMap { existingTodo ->
            existingTodo.success()
            return@flatMap todoRepository.save(existingTodo)
        }
    }

    fun saveTodo(todoRequest: TodoRequest): Mono<Todo> {
        return todoRepository.save(todoRequest.toTodo())
    }
}