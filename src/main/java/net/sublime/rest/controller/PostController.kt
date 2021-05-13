package net.sublime.rest.controller

import net.sublime.rest.dto.post.PostDTO
import net.sublime.rest.service.post.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class PostController(
    private val postService: PostService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<PostDTO>> {
        return if (postService.getAll().isEmpty())
            ResponseEntity(HttpStatus.NO_CONTENT)
        else ResponseEntity(postService.getAll(), HttpStatus.OK)
    }
}
