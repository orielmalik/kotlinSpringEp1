package org.example.bigservicekotlin.Boundary

import PeopleEntity
import org.example.bigservicekotlin.Utils.Validation
import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class PeopleBoundary(
        var id: String,
        var birth: String,
        var email: String,
        var phone: String,
        var score: Int

) {
    //From Entity Constructor
    constructor(peopleEntity: PeopleEntity):
            this(peopleEntity.getId(),peopleEntity.getBirth().format(DateTimeFormatter.ofPattern("dd-mm-yyyy")),peopleEntity.getEmail(),peopleEntity.getPhone()
                    ,peopleEntity.getScore())
    {}

    fun toEntity(): PeopleEntity {
        val peopleEntity=PeopleEntity();
        peopleEntity.setId(this.id);
        if(Validation.isValidDate(this.birth,"dd-mm-yyy"))
        {
            val formatter = DateTimeFormatter.ofPattern("dd-mm-yyy");
            peopleEntity.setBirth( LocalDate.parse(this.birth, formatter));

        }else
        {
            throw  Exception("date format except");
        }
        peopleEntity.setEmail(this.email);
        peopleEntity.setScore(this.score)
        return  peopleEntity;
    }
}