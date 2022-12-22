package com.example.demo.stepdefinitions;

import io.restassured.http.ContentType;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class API_StepDefinitions {


    private ValidatableResponse apiResponse;

    private String endpoint = "http://localhost:8080/student/1";

    @Given("I send a request to the URL to get student details")
    public void sendRequest(){
        apiResponse = given().contentType(ContentType.JSON)
                .when().get(endpoint).then();

        System.out.println("Response :"+apiResponse.extract().asPrettyString());
    }


    @Then("the response will return status {string} and id {int} and name {string} and grade {string}")
    public void verify(String statusCode, Integer st_id, String st_name, String st_grade) {
        apiResponse.assertThat().statusCode(Integer.parseInt(statusCode));

        apiResponse.assertThat().body("student_id",equalTo(st_id));

        apiResponse.assertThat().body("name",equalTo(st_name));

        apiResponse.assertThat().body("grade",equalTo(st_grade));
    }

}