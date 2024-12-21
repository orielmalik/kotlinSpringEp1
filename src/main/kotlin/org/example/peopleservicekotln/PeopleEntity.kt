package org.example.peopleservicekotln


import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "people")
class PeopleEntity (
        @Id
        var id: String,
        var name:String,
        var email:String,
        var phone:String,

        ){
        constructor():this("","","","");
}