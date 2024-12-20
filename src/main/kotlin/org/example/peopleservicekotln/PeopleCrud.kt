package org.example.peopleservicekotln

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface PeopleCrud:CrudRepository<PeopleEntity,UUID> {
}