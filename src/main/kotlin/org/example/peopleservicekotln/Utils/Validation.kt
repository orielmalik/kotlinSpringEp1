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
            val pattern:Pattern;
            return when (type.lowercase()) {
                "phone"->{
                    pattern = Pattern.compile("^(\\+?\\d{1,4}[\\s-]?)?(\\(?\\d{1,4}\\)?[\\s-]?)?(\\d{1,4}[\\s-]?)\\d{1,4}[\\s-]?\\d{1,4}\$\n$");
                    pattern.matcher(str).matches()
                }
                "email" -> {
                     pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
                    pattern.matcher(str).matches()
                }

                else -> false
            }
        }
    }
}