package net.sublime.rest.repository

import net.sublime.rest.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>