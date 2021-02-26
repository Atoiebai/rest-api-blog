package net.sublime.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class Application {

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}