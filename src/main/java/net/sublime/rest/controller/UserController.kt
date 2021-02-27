package net.sublime.rest.controller

import net.sublime.rest.model.user.User
import net.sublime.rest.service.user.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blog/users")
open class UserController(
    private val userService: UserService
) {

    @GetMapping
    open fun getUsers(): ResponseEntity<List<User>> {
        return if (userService.getAll().isEmpty())
            ResponseEntity(HttpStatus.NO_CONTENT)
        else
            ResponseEntity(userService.getAll(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    open fun getUser(@PathVariable id: Long): ResponseEntity<User> {
        return if (userService.getUser(id).equals(null))
            ResponseEntity(HttpStatus.BAD_REQUEST)
        else ResponseEntity(userService.getUser(id), HttpStatus.OK)
    }


    @PostMapping("/create")
   open fun createUser(@RequestBody user: User): ResponseEntity<Any> {
        // TODO: 2/13/2021 Validate user
        userService.addUser(user)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PutMapping("/{id}/update")
   open fun updateUser(@RequestBody user: User) {
        userService.updateUser(user)
    }

}