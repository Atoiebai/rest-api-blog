package net.sublime.rest.service.security

import net.sublime.rest.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
open class UserDetailsServiceImpl(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(name: String): UserDetails {
        return userRepository.findUserByUserName(name)
            .orElseGet { userRepository.findUserByEmail(name).orElseThrow() }
    }

}
