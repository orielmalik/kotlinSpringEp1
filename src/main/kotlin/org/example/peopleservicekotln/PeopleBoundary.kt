package org.example.peopleservicekotln

import java.util.*

data class PeopleBoundary(
        var id: String?,
        var name: String,
        val phone: String,
        val email: String,
        )
{

    constructor(entity: PeopleEntity) : this(entity.id.toString(),entity.name,entity.phone,entity.email)





    fun toEntity(): PeopleEntity {
        val pe=PeopleEntity()
        pe.id= (this.id.toString());
        pe.email=this.email;
        pe.name=this.name;
        pe.phone=this.phone;
return  pe;
    }
}
