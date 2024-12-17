package org.example.bigservicekotlin.Service

import org.example.bigservicekotlin.Boundary.PeopleBoundary
import org.springframework.stereotype.Service


@Service
class ServiceImp:PeopleService {

    private  lateinit var serviceCrud: ServiceCrud;

    constructor(serviceCrud: ServiceCrud)
    {
        this.serviceCrud=serviceCrud;
    }
    override fun getAllPeople(type: String, value: String): List<PeopleBoundary> {
        TODO("Not yet implemented")
    }

    override fun PostPeople(boundary: PeopleBoundary): PeopleBoundary {
        TODO("Not yet implemented")
    }

    override fun DeleteAll() {
        TODO("Not yet implemented")
    }
}