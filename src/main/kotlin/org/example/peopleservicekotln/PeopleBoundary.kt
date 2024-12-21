package org.example.peopleservicekotln

import java.util.*

data class PeopleBoundary(
        var id: String? = null,
        var name: String = "",
        var phone: String = "",
        var email: String = "",
        var sons: List<PeopleBoundary> = mutableListOf(), // רשימת בני המשפחה (sons)
        var daughters: List<PeopleBoundary> = mutableListOf() // רשימת בנות המשפחה (daughters)
) {
    constructor(entity: PeopleEntity) : this(
            entity.id.toString(),
            entity.name,
            entity.phone,
            entity.email
    )

    // פונקציה להמרה ל-Entity
    fun toEntity(): PeopleEntity {
        val pe = PeopleEntity()
        pe.id = this.id ?: UUID.randomUUID().toString()
        pe.email = this.email
        pe.name = this.name
        pe.phone = this.phone
        return pe
    }
}
