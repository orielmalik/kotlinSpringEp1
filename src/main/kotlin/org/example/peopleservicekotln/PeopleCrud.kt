package org.example.peopleservicekotln

import org.springframework.data.repository.CrudRepository

interface PeopleCrud:CrudRepository<PeopleEntity,String> {
}