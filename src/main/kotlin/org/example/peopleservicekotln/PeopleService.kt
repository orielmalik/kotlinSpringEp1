package org.example.peopleservicekotln

interface PeopleService {

    fun getAll():List<PeopleBoundary>;
fun create(boundary: PeopleBoundary):PeopleBoundary;
fun deleteAll();



}