package com.grados.firstfullproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VehicleControllerTest {

    private final static String BASE_URI = "http://localhost";

    private final static String url = "/drivers/{idDriver}/vehicles";
    private final static String urlWithParam = "/drivers/{idDriver}/vehicles/{idVehicle}";

    @LocalServerPort
    private int port;

    private ValidatableResponse validatableResponse;



    @BeforeEach
    void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.port = port;
    }

    @Test
    @DirtiesContext
    void saveVehicle() throws JSONException {
        JSONObject newVehicle = new JSONObject();
        newVehicle.put("id", 123L);
        newVehicle.put("brand", "Touareg");
        newVehicle.put("model", LocalDate.of(2020, 5, 9));
        newVehicle.put("horsePower", 70);
        newVehicle.put("dateOfPurchase", LocalDate.of(2020, 1, 15));
        newVehicle.put("counter", 150);


        validatableResponse = given()
                .pathParams("idDriver", 111)
                .contentType(ContentType.JSON)
                // todo - here is a problm
                .body(newVehicle.toString())
                .when()
                .post(url)
                .then()
                .statusCode(201);
    }

    @Test
    @DirtiesContext
    void deleteVehicle() {
        validatableResponse = given()
                .contentType(ContentType.JSON)
                .pathParams("idDriver", 111)
                .pathParams("idVehicle", 10)
                .when().delete(urlWithParam)
                .then().log().all().statusCode(200);

        validatableResponse = given().contentType(ContentType.JSON).pathParams("idDriver", 111).pathParams("idVehicle", 10)
                .when().get(urlWithParam)
                .then().log().all().statusCode(404);
    }

    @Test
    @DirtiesContext
    void getAllVehicles() {
        validatableResponse = given().pathParams("idDriver", 111).contentType(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .log().all().statusCode(200)
                .body("brand[0]", equalTo("audi"))
                .body("id[0]", equalTo(10))
                .body("dateOfPurchase", equalTo("2015-01-10"));
    }

    @Test
    @DirtiesContext
    void getVehicleById() {
        validatableResponse = given().contentType(ContentType.JSON).pathParams("idDriver", 111).pathParams("idVehicle", 10)
                .when().get(urlWithParam)
                .then().log().all().statusCode(200);
    }

    @Test
    @DirtiesContext
    void updateVehicle() throws JSONException {
        JSONObject updatedVec = new JSONObject();
        updatedVec.put("dateOfPurchase",LocalDate.of(2016,1,10));
        validatableResponse = given().contentType(ContentType.JSON).body(updatedVec.toString())
                .pathParams("idDriver",111)
                .pathParams("idVehicle",10)
                .when().put(urlWithParam)
                .then().log().all().statusCode(200)
                .body("dateOfPurchase",equalTo("2016-01-10"));
    }

//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}