package com.grados.firstfullproject.controller;

import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class DriverControllerIntegratedTest {

    private final static String BASE_URI = "http://localhost";

    @LocalServerPort
    private int port;

    private ValidatableResponse validatableResponse;

//    private ValidatableResponse validatableResponse1;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.port = port;
    }

    @Test
    void getAllDrivers() {
        validatableResponse = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/drivers")
                .then()
                .assertThat().statusCode(200)
                .body("id[0]", equalTo(111))
                .body("firstName[0]", equalTo("jamal"))
                .body("vehicles[0].id[0]", equalTo(10));
    }

    @Test
//    @DirtiesContext
    void saveDriver() throws JSONException {
        JSONObject newDriver = new JSONObject();
        newDriver.put("id", 111L);
        newDriver.put("firstName", "chomakhar");
        newDriver.put("lastName", "maikl");
        newDriver.put("dateOfBirth", "2000-01-01");

        validatableResponse = given()
                .contentType(ContentType.JSON)
                .body(newDriver.toString())
                .when().post("/drivers")
                .then()
                .log().all().statusCode(201);


        validatableResponse = given().contentType(ContentType.JSON)
                .when().get("drivers/111")
                .then().log().all().statusCode(200)
                .body("id", equalTo(111))
                .body("firstName", equalTo("chomakhar"))
                .body("lastName", equalTo("maikl"));
    }

    @Test
//    @DirtiesContext
    void getDriverById() {
        validatableResponse = given().contentType(ContentType.JSON)
                .when().get("/drivers/111")
                .then()
                .log().all().statusCode(200)
                .body("id", equalTo(111))
                .body("firstName", equalTo("jamal"))
                .body("lastName", equalTo("alfa"));
    }

    @Test
//    @DirtiesContext
    void updateDriver() throws JSONException {
        JSONObject updatedDriver = new JSONObject();
        updatedDriver.put("firstName", "Jamal");

        validatableResponse = given()
                .contentType(ContentType.JSON).body(updatedDriver.toString())
                .when().put("/drivers/111")
                .then().log().all().assertThat().statusCode(200)
                .body("firstName", equalTo("Jamal"));
    }

    @Test
//    @DirtiesContext
    void deleteDriver() throws InterruptedException {
        validatableResponse = given()
                .contentType(ContentType.JSON)
                .when().delete("/drivers/111")
                .then().log().all().statusCode(200);

        validatableResponse = given().contentType(ContentType.JSON)
                .when().get("/drivers/111").then().log().all().assertThat().statusCode(404);
    }
}