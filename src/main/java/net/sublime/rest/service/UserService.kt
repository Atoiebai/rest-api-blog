package net.sublime.rest.service

import net.sublime.rest.model.user.User

interface UserService {
    fun getAll(): List<User>;
    fun getUser(id: Long): User;
    fun blockUser(id: Long);
    fun createUser(user: User): User;
}