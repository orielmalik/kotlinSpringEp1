package org.example.bigservicekotlin.Controller

import org.example.bigservicekotlin.Boundary.PeopleBoundary
import org.example.bigservicekotlin.Service.PeopleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/people")
class PeopleController {

    private var peopleService: PeopleService? = null

    fun PeopleController(peopleService: PeopleService?) {
        this.peopleService = peopleService
    }


    @GetMapping
    fun getPeople():List<PeopleBoundary>
    {
        return
    }
}