package net.sublime.rest.service

import net.sublime.rest.repository.UserRepository

class UserServiceImpl(val jpaRepository: UserRepository)  : UserService {

}