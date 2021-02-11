package net.sublime.rest.repository

import net.sublime.rest.model.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long>