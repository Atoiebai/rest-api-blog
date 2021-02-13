package net.sublime.rest.service.user

import net.sublime.rest.model.user.User
import net.sublime.rest.repository.UserRepository
import net.sublime.rest.service.user.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository)  : UserService {

    override fun getAll():List<User> = userRepository.findAll()

    override fun getUser(id: Long): User = userRepository.getOne(id)

    override fun blockUser(id: Long) {
        TODO("Not yet implemented")
    }

    override fun createUser(user: User): User = userRepository.save(user)

}