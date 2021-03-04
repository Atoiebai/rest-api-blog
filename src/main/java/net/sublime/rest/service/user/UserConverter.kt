package net.sublime.rest.service.user

import net.sublime.rest.dto.user.UserDTO
import net.sublime.rest.model.user.User

fun User.toTransferObject() = UserDTO(
    id = this.id,
    username = this.username,
    firstName = this.firstName,
    lastName = this.lastName,
    email = this.email,
    password = this.passwordKey,
    age = this.age,
    sex = this.sex
)

fun UserDTO.toUserEntity(): User {
    val user = User()
    user.id = this.id
    user.email = this.email
    user.userName = this.username
    user.firstName = this.firstName
    user.lastName = this.lastName
    user.passwordKey = this.password
    user.sex = this.sex
    user.age = this.age
    return user
}
