package org.example.peopleservicekotln

import jdk.jshell.execution.Util
import org.example.bigservicekotlin.Utils.Validation
import org.example.peopleservicekotln.Exceptions.BadRequest400
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@Service
class PeopleServiceImp(val peopleCrud: PeopleCrud): PeopleService {
    override fun getAll(): List<PeopleBoundary> {
        return this.peopleCrud.findAll().map { peopleEntity ->PeopleBoundary(peopleEntity) };
    }

    override fun create(boundary: PeopleBoundary): PeopleBoundary {
if(!Validation.isValidFormat(boundary.email,"email"))
{
    throw BadRequest400("email err");
}
        boundary.id=UUID.randomUUID().toString();
        return  PeopleBoundary(this.peopleCrud.save(boundary.toEntity()));

    }

    override fun deleteAll() {
        return this.peopleCrud.deleteAll();
    }

}


