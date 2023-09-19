import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_partnership_types")
data class PartnershipType(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @Column(name = "type", length = 255, nullable = false, unique = true)
    val type: String,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
