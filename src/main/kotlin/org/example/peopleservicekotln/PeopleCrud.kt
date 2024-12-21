package org.example.peopleservicekotln

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface PeopleCrud:JpaRepository<PeopleEntity,String> {

fun findAllByEmail(email:String):List<PeopleBoundary>
fun findAllByName(email:String):List<PeopleBoundary>
fun findAllByPhone(email:String):List<PeopleBoundary>
}