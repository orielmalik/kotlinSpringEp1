import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
@Table(name = "people")
class PeopleEntity {

    @Id
    private lateinit var id: String
    private  lateinit var birth: LocalDate
    private lateinit var email: String
    private lateinit var phone: String
    private var score: Int = 0 ;

    // בנאי ריק
    constructor()

    // Getter ו-Setter
    fun getId(): String = id
    fun setId(id: String) {
        this.id = id
    }

    fun getBirth(): LocalDate = birth
    fun setBirth(birth: LocalDate) {
        this.birth = birth
    }

    fun getEmail(): String = email
    fun setEmail(email: String) {
        this.email = email
    }

    fun getPhone(): String = phone
    fun setPhone(phone: String) {
        this.phone = phone
    }

    fun getScore(): Int = score
    fun setScore(score: Int) {
        this.score = score
    }

    override fun toString(): String {
        return "PeopleEntity(id='$id', birth=$birth, email='$email', phone='$phone', score=$score)"
    }
}
