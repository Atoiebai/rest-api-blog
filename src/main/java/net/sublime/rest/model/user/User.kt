package net.sublime.rest.model.user

import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

// TODO: 2/16/2021 Annotation style
// TODO: 2/16/2021 JsonOrder
// TODO: 2/16/2021 Constructor args
@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    @Size(min = 2, max = 30, message = "username should be between 2 & 30 letters")
    var username: String? = null,

    @Column(nullable = false)
    var firstName: String? = null,

    @Column(nullable = false)
    var lastName: String? = null,

    @Email
    @Column(nullable = false, unique = true)
    var email: String? = null,

    @Column(nullable = false)
    @Max(value = 100, message = "We aren't sure its your real age")
    @Min(value = 0, message = "You are to young, buddy")
    var age: Int? = null,

    @Column(nullable = false)
    @Size(min = 6, message = "password should contain at least 6 characters")
    var password: String? = null,

    @Enumerated(EnumType.STRING)
    var sex: Sex? = null,


    ) {

    @Column(nullable = false)
    var createdAt: Date? = null

    @Column(nullable = false, unique = true)
    var slug: String? = null

    @Column(insertable = false)

    @Enumerated(EnumType.STRING)
    var status: Status? = null

    @Enumerated(EnumType.STRING)
    var role: Role? = null

}
