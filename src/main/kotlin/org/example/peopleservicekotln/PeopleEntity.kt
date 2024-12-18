package org.example.peopleservicekotln


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
class PeopleEntity (

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
        var id: String,
        var name:String,
        var email:String,
        var phone:String
){
        constructor():this("","","","");
}