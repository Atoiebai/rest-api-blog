package net.sublime.rest.model.user

import javax.persistence.*
import javax.validation.constraints.Email
import kotlin.jvm.Transient

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false , unique = true)
    var username: String? = null,

    @Column(nullable = false)
    var firstName: String? = null,

    @Column(nullable = false)
    var secondName: String? = null,

    @Email
    @Column(nullable = false , unique = true)
    var email: String? = null,

    @Column(nullable = false)
    var password: String? = null,

    @Transient
    var repeatPassword: String? = null,

    @Enumerated(EnumType.STRING)
    var sex: Sex? = null,

    @Column(unique = true , nullable = false)
    var slug: String? = null,



)  {



}
