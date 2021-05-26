package net.sublime.rest.model.post

import net.sublime.rest.model.user.User
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(
    name = "posts",
    uniqueConstraints = [
        UniqueConstraint(name = "user_id", columnNames = ["user_id"])
    ]
)
class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var title: String? = null

    @Column(nullable = false)
    var content: String? = null

    @Column(nullable = false)
    @CreationTimestamp
    var createdAt: Date? = null

    @Column(nullable = false)
    @UpdateTimestamp
    var updateAt: Date? = null

    @ManyToOne(cascade = [CascadeType.MERGE], optional = false , fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null
}
