package org.example.peopleservicekotln

class PeopleBoundary (    var id: String,
                          var name:String,
                          var email:String,
                          var phone:String){

constructor(entity: PeopleEntity) : this(

    entity.id,entity.name,entity.email,entity.phone
)
}
