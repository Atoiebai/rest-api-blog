package net.sublime.rest.service.user

import net.sublime.rest.model.user.Role
import net.sublime.rest.model.user.Status
import net.sublime.rest.model.user.User
import net.sublime.rest.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
//    private val passwordEncoder: PasswordEncoder
) : UserService {

    override fun getAll(): List<User> = userRepository.findAll()

    override fun getUser(id: Long): User = userRepository.getOne(id)

    override fun blockUser(id: Long) {
        TODO("Not yet implemented")
    }

    override fun addUser(user: User):Boolean {
        // TODO: 2/26/2021 false if user exist 
        user.status = Status.ACTIVE
        user.role = Role.USER
        user.slug = user.username
//        user.password
        userRepository.save(user)
        return true
    }

    override fun updateUser(user: User) {
        userRepository.save(user)
    }

}