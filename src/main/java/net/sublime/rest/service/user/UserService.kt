package net.sublime.rest.service.user

import net.sublime.rest.model.user.User

interface UserService {
    fun getAll(): List<User>

    fun getUser(id: Long): User

    fun blockUser(id: Long)

    fun addUser(user: User): Boolean

    fun updateUser(user: User)
}