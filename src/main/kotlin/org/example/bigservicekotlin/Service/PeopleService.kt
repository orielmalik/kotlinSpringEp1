package org.example.bigservicekotlin.Service

import org.example.bigservicekotlin.Boundary.PeopleBoundary

interface PeopleService  {


    fun getAllPeople(type:String,value:String):List<PeopleBoundary>;
    fun PostPeople(boundary:PeopleBoundary):PeopleBoundary;
   fun DeleteAll();
}
