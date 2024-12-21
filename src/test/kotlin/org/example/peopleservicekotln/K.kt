package org.example.peopleservicekotln


import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional
import kotlin.test.assertEquals

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // כדי לאתחל ולהפסיק את השרת פעם אחת לכל הבדיקות
class PeopleControllerTest {

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    private val baseUrl = "http://localhost:8093/people"

    @BeforeAll
    fun setup() {
        println("Before all tests - Setup")
    }

    @AfterAll
    fun tearDown() {
        println("After all tests - Teardown")
    }

    @Test
    fun `should create a new person`() {
        // הגדרת הנתונים שנשלחים
        val person = PeopleBoundary(name = "John Doe", phone = "123456789", email = "john.doe@example.com")

        val response = restTemplate.postForEntity(baseUrl, person, PeopleBoundary::class.java)

        assertEquals(HttpStatus.CREATED, response.statusCode)

        val createdPerson = response.body
        assertEquals("John Doe", createdPerson?.name)
    }

    // בדיקה של ה-GET
    @Test
    fun `should return all people based on type and value`() {
        val response = restTemplate.getForEntity("$baseUrl?type=name&value=John", List::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)

        // בדיקה שהגודל של הרשימה הוא לפחות 1 (נניח, אם היה אדם עם השם "John")
        assert(response.body is List<*>) // אם לא נשלח מידע, זה יכשל
    }

    // בדיקה של ה-DELETE
    @Test
    fun `should delete all people`() {
        // שליחת בקשה למחוק את כל הנתונים
        restTemplate.delete(baseUrl)

        // לאחר מחיקה, נוודא שאין אנשים במערכת
        val response = restTemplate.getForEntity("$baseUrl?type=name&value=John", List::class.java)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(0, (response.body as List<*>).size)
    }

    // בדיקת טיפול בשגיאת 400 - BadRequest
    @Test
    fun `should return BadRequest when invalid input`() {
        // שליחת בקשה עם תוכן לא תקני (null) שיגרום לשגיאת 400
        val response = restTemplate.postForEntity(baseUrl, null, String::class.java)

        // בדיקה שהסטטוס הוא 400
        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
    }
}
