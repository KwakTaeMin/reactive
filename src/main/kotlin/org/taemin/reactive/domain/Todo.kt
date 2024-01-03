package org.taemin.reactive.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("todo")
class Todo(
    @Id
    val id: Long? = null,
    var content: String,
    var done: Boolean? = false,
    @CreatedDate
    val createdAt: LocalDateTime? = null,
    @LastModifiedDate
    val modifiedAt: LocalDateTime? = null
)
{
    fun updateContent(content: String) {
        this.content = content
    }
    fun success() {
        this.done = true
    }
}