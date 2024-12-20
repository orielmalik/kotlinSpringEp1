package org.example.peopleservicekotln.Exceptions;

import org.springframework.http.HttpMessage
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
class BadRequest400 : RuntimeException {
	val  serialVersionUID = -138561552243118779L;

	constructor()

	constructor(message: String):super(message)
	constructor(message: Throwable):super(message)
	constructor(message: String,cause:Throwable):super(message,cause)



}
