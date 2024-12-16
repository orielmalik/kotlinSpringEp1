package org.example.bigservicekotlin.Service
import org.example.bigservicekotlin.Entity.PeopleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ServiceCrud: JpaRepository<PeopleEntity, String>  {


    fun findFirstByScore():PeopleEntity?
}