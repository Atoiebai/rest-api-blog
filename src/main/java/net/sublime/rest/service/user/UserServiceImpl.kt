package net.sublime.rest.service.user

import net.sublime.rest.dto.user.UserDTO
import net.sublime.rest.mapper.UserMapper
import net.sublime.rest.model.user.Role
import net.sublime.rest.model.user.Status
import net.sublime.rest.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
open class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val mapper: UserMapper
) : UserService {

    override fun getAll(): List<UserDTO> = userRepository
        .findAll()
        .stream()
        .map(mapper::toDTO)
        .collect(Collectors.toList())


    override fun getUser(id: Long): UserDTO = mapper.toDTO(userRepository.getOne(id))


    override fun blockUser(id: Long) {
        userRepository.getOne(id).status = Status.BANNED
    }

    override fun addUser(userDTO: UserDTO): Boolean {
        // TODO: 2/26/2021 false if user exist
        val user = mapper.toEntity(userDTO)
        user.status = Status.ACTIVE
        user.role = Role.USER
        user.slug = user.username
        user.passwordKey = passwordEncoder.encode(user.passwordKey)
        userRepository.save(user)
        print(user)
        return true
    }

    override fun updateUser(userDTO: UserDTO) {
        val user = mapper.toEntity(userDTO)
        userRepository.save(user)
    }

    override fun getByUsername(identifier: String): UserDTO {
        return mapper.toDTO(userRepository
            .findUserByUserName(identifier)
            .orElseThrow { RuntimeException("No user with such username") }
                )
    }

}
