package net.sublime.rest.controller

import lombok.AllArgsConstructor
import net.sublime.rest.model.user.User
import net.sublime.rest.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/blog/users")
@AllArgsConstructor
class UserController(
  private val userService: UserService
) {

    @GetMapping
    fun getUsers():
            ResponseEntity<List<User>> = ResponseEntity(userService.getAll() , HttpStatus.OK)

}