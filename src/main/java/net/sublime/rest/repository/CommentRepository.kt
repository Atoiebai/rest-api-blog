package net.sublime.rest.repository

import net.sublime.rest.model.comment.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Comment , Long> {
}
