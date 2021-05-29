package net.sublime.rest.service.user

import net.sublime.rest.dto.user.UserDTO

interface UserService {
    fun getAll(): List<UserDTO>

    fun getUser(id: Long): UserDTO

    fun blockUser(id: Long)

    fun addUser(userDTO: UserDTO): Boolean

    fun updateUser(userDTO: UserDTO)

    fun getByUsername(identifier: String): UserDTO
}
