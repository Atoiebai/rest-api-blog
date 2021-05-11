package net.sublime.rest.model.user

import net.sublime.rest.model.post.Post
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

// TODO: 2/16/2021 Annotation style
// TODO: 2/16/2021 JsonOrder
@Entity
@Table(
    name = "users", uniqueConstraints = [
        UniqueConstraint(name = "user_email_unique", columnNames = ["email"]),
        UniqueConstraint(name = "user_username_unique", columnNames = ["username"]),
        UniqueConstraint(name = "user_slug", columnNames = ["slug"])
    ]
)
class User : UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "username", nullable = false)
    @Size(min = 2, max = 30, message = "username should be between 2 & 30 letters")
    var userName: String? = null

    @Column(nullable = false)
    var firstName: String? = null

    @Column(nullable = false)
    var lastName: String? = null

    @Email(message = "Incorrect email")
    @Column(nullable = false)
    var email: String? = null

    @Column(nullable = false)
    @Max(value = 100, message = "We aren't sure its your real age")
    @Min(value = 0, message = "You are to young, buddy")
    var age: Int? = null

    @Column(name = "password")
    @Size(min = 5, message = "password should contain at least 5 characters")
    var passwordKey: String? = null

    @Enumerated(EnumType.STRING)
    var sex: Sex? = null

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var createdAt: Date? = null

    @Column(nullable = false)
    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var updatedAt: Date? = null

    @Column(nullable = false)
    var slug: String? = null

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var status: Status? = null

    @Enumerated(EnumType.STRING)
    var role: Role? = null

    @OneToMany
    var posts: List<Post>? = null

    override fun getAuthorities(): MutableCollection<GrantedAuthority> {
        return role!!.getAuthorities()
    }

    override fun getPassword(): String = passwordKey!!

    override fun getUsername(): String = userName!!

    override fun isAccountNonExpired(): Boolean = status!! == Status.ACTIVE

    override fun isAccountNonLocked(): Boolean = status!! == Status.ACTIVE

    override fun isCredentialsNonExpired(): Boolean = status!! == Status.ACTIVE

    override fun isEnabled(): Boolean = status!! == Status.ACTIVE

}
