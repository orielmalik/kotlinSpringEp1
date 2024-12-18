package org.example.peopleservicekotln

import org.springframework.stereotype.Service

@Service
class PeopleServiceImp(val peopleCrud: PeopleCrud): PeopleService {
    override fun getAll(): List<PeopleBoundary> {
        return this.peopleCrud.findAll().map { peopleEntity ->PeopleBoundary(peopleEntity) };
    }

}


