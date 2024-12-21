package org.example.peopleservicekotln

import jakarta.validation.Valid
import org.example.peopleservicekotln.Exceptions.BadRequest400
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/people")
class PeopleController(val peopleService: PeopleService) {

    @PostMapping(
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun post(@Valid @RequestBody boundary: PeopleBoundary?): PeopleBoundary {
        if (boundary == null) {
            throw BadRequest400(IllegalStateException("No people found"))
        }
        boundary.id= (UUID.randomUUID()).toString()
        return this.peopleService.create(boundary)
    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(@RequestParam("type")type:String,@RequestParam("value")value:String): List<PeopleBoundary> {
                return this.peopleService.getAll(type, value);
    }
    @DeleteMapping()
    fun deleteAll() {
        return this.peopleService.deleteAll()
    }

    @ExceptionHandler(BadRequest400::class)
    fun handleBadRequest(exception: BadRequest400): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.message)
    }

}
