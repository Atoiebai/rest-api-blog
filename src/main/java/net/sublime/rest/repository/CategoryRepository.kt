package net.sublime.rest.repository

import net.sublime.rest.model.category.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category , Long> {
}
