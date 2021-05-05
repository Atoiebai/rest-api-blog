package net.sublime.rest.controller

import net.sublime.rest.dto.user.UserDTO
import net.sublime.rest.model.user.User
import net.sublime.rest.service.user.UserService
import org.springframework.data.repository.CrudRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blog/users")
open class UserController(
    private val userService: UserService,
    private val crudRepository: CrudRepository<User, Long>
) {

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping
    open fun getUsers(): ResponseEntity<List<UserDTO>> {
        return if (userService.getAll().isEmpty())
            ResponseEntity(HttpStatus.NO_CONTENT)
        else
            ResponseEntity(userService.getAll(), HttpStatus.OK)
    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping("/{id}")
    open fun getUser(@PathVariable id: Long): ResponseEntity<UserDTO> {
        return if (userService.getUser(id).equals(null))
            ResponseEntity(HttpStatus.BAD_REQUEST)
        else ResponseEntity(userService.getUser(id), HttpStatus.OK)
    }

    @CrossOrigin
    @PostMapping("/create")
    open fun createUser(@RequestBody userDTO: UserDTO): ResponseEntity<Any> {
        // TODO: 2/13/2021 Validate user
        userService.addUser(userDTO)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @CrossOrigin
    @PutMapping("/{id}/update")
    open fun updateUser(@RequestBody userDTO: UserDTO) {
        userService.updateUser(userDTO)
    }

}
