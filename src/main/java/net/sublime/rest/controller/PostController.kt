package net.sublime.rest.controller

import net.sublime.rest.dto.post.PostDTO
import net.sublime.rest.service.post.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.nio.file.Files
import java.util.*

@RestController
@RequestMapping("api/blog/posts")
open class PostController(
    private val postService: PostService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<PostDTO>> {
        return if (postService.getAll().isEmpty())
            ResponseEntity(HttpStatus.NO_CONTENT)
        else ResponseEntity(postService.getAll(), HttpStatus.OK)
    }



    fun getLines(file: File , lines: Int , words: Int) {

       val fileContent = Files.readAllLines(file.toPath())
        fileContent.stream().skip(fileContent.size - lines.toLong())
            .flatMap { line: String ->
                val splitWords = line.split("\\s+".toRegex()).toTypedArray()
                Arrays.stream(splitWords).skip(splitWords.size - words.toLong())
            }.forEach(System.out:: println)
    }
}
