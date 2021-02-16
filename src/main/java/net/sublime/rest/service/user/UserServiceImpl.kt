package net.sublime.rest.service.user

import net.sublime.rest.model.user.Role
import net.sublime.rest.model.user.Status
import net.sublime.rest.model.user.User
import net.sublime.rest.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun getAll(): List<User> = userRepository.findAll()

    override fun getUser(id: Long): User = userRepository.getOne(id)

    override fun blockUser(id: Long) {
        TODO("Not yet implemented")
    }

    override fun addUser(user: User) {
        user.status = Status.ACTIVE
        user.role = Role.USER
        user.slug = user.username
        user.createdAt = Date()
        userRepository.save(user)
    }


    override fun updateUser(user: User) {
        userRepository.save(user)
    }

    override fun addUsers( users: Array<User>) {
        // TODO: 2/16/2021 status/slug/role 
        userRepository.saveAll(users.toList())
    }

}