package org.taemin.reactive.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.taemin.reactive.domain.Todo

interface TodoRepository: ReactiveCrudRepository<Todo, Long> {
}