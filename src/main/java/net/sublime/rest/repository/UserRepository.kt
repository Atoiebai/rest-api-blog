package net.sublime.rest.repository

import net.sublime.rest.model.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
@Transactional(readOnly = true)
interface UserRepository : JpaRepository<User, Long> {
    fun findUserByUserName(username: String): Optional<User>
    fun findUserByEmail(email: String): Optional<User>
}
