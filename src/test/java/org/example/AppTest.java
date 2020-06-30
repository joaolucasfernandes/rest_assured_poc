package org.example;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.apache.http.HttpStatus;
import org.junit.Test;

public class AppTest
{

    @Test
    public void shouldReturnExpectedSchema()
    {
        when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }

    @Test
    public void shouldReturnBadRequest()
    {
        when()
                .get("https://httpstat.us/400")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}
