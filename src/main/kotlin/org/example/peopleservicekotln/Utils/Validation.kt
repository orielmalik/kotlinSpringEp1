package org.example.bigservicekotlin.Utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.regex.Pattern

import java.util.regex.Matcher

class Validation {

    companion object {
        fun isValidDate(dateString: String, format: String): Boolean {
            return try {
                val formatter = DateTimeFormatter.ofPattern(format);
                LocalDate.parse(dateString, formatter);
                true
            } catch (e: DateTimeParseException) {
                e.printStackTrace();
                false
            }

        }

        fun isValidFormat(str: String, type: String): Boolean {
            return when (type.lowercase()) {
                "email" -> {
                    val pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
                    val matcher = pattern.matcher(str)
                    matcher.matches()
                }

                else -> false
            }
        }
    }
}