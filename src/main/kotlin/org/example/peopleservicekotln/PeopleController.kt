package org.example.peopleservicekotln

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/people")
class PeopleController (val peopleService: PeopleService){

    @GetMapping(produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    fun getAll():List<PeopleBoundary>
    {
        return  this.peopleService.getAll();
    }
}