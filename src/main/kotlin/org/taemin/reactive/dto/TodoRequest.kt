package org.taemin.reactive.dto

import org.taemin.reactive.domain.Todo

data class TodoRequest(
    val id: Long? = null,
    val content: String
) {
    fun toTodo(): Todo {
        return Todo(content= this.content)
    }

    fun toUpdateTodo(): Todo{
        return Todo(id= this.id, content= this.content)
    }
}
