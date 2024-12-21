package org.example.peopleservicekotln

interface PeopleService {

    fun getAll(type:String,value:String):List<PeopleBoundary>;
fun create(boundary: PeopleBoundary):PeopleBoundary;
fun deleteAll();



}