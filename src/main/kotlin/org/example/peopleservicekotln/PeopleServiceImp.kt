package org.example.peopleservicekotln

import jdk.jshell.execution.Util
import org.example.bigservicekotlin.Utils.Validation
import org.example.peopleservicekotln.Exceptions.BadRequest400
import org.example.peopleservicekotln.Exceptions.UnauthorizedAccess401
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@Service
class PeopleServiceImp(val peopleCrud: PeopleCrud): PeopleService {


    override fun getAll(type: String, value: String): List<PeopleBoundary> {
        if(!type.isEmpty()&&!Validation.isValidFormat(value,type))
        {
            throw BadRequest400("bad");
        }
        when(type.lowercase())
        {
            "email"->{
                return this.peopleCrud.findAllByEmail(value)};
            "phone"->return this.peopleCrud.findAllByPhone(value);
            else->{return  this.peopleCrud.findAll().map { peopleEntity -> PeopleBoundary(peopleEntity)  };  }
        }
    }

    override fun create(boundary: PeopleBoundary): PeopleBoundary {
        if (!Validation.isValidFormat(boundary.email, "email")) {
            throw BadRequest400("email err");
        }
        if (!Validation.isValidFormat(boundary.phone, "phone"))
        {
            throw BadRequest400("ph err");

        }
        if(this.peopleCrud.findAllByEmail(boundary.email)!=null||this.peopleCrud.findAllByPhone(boundary.phone)!=null)
        {
            throw BadRequest400(" err");
        }
        boundary.id=UUID.randomUUID().toString();
        return  PeopleBoundary(this.peopleCrud.save(boundary.toEntity()));

    }

    override fun deleteAll() {
        return this.peopleCrud.deleteAll();
    }

}


