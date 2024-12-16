package org.example.bigservicekotlin.Entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
@Table(name = "people")
class PeopleEntity(
        @Id private var id: String,
        private var birth: LocalDate,
        private var email: String,
        private var phone: String,
        private var score: Int

) {

    // Getter and Setter for id
    fun getId(): String = id
    fun setId(id: String) {
        this.id = id
    }    // Getter and Setter for id
    fun getScore(): Int = score
    fun setScore(score:  Int) {
        this.score = score
    }

    // Getter and Setter for birth
    fun getBirth(): LocalDate = birth
    fun setBirth(birth: LocalDate) {
        this.birth = birth
    }

    // Getter and Setter for email
    fun getEmail(): String = email
    fun setEmail(email: String) {
        this.email = email
    }

    // Getter and Setter for phone
    fun getPhone(): String = phone
    fun setPhone(phone: String) {
        this.phone = phone
    }
}
