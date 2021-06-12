package net.sublime.rest.controller

import net.sublime.rest.dto.post.PostDTO
import net.sublime.rest.service.post.PostService
import net.sublime.rest.service.user.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import java.security.Principal


@RestController
@RequestMapping("api/blog/posts")
open class PostController(
    private val userService: UserService,
    private val postService: PostService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<PostDTO>> {
        return if (postService.getAll().isEmpty())
            ResponseEntity(HttpStatus.NO_CONTENT)
        else ResponseEntity(postService.getAll(), HttpStatus.OK)
    }


    @PostMapping("/create")
    fun createNewPost(
        @RequestBody newPost: PostDTO,
        @AuthenticationPrincipal principal: Principal
    ): ResponseEntity<PostDTO> {
        newPost.user = userService.getByUsername(principal.name)
        postService.createPost(newPost);
        return ResponseEntity(newPost, HttpStatus.CREATED)


    }
}
