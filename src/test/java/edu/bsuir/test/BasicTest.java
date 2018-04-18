package edu.bsuir.test;

import edu.bsuir.pojo.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public abstract class BasicTest {

    private static RequestSpecification spec;

    @BeforeClass
    public static void initSpec(){
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://localhost:8080/SpringBootRestApi/api/")
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    protected String createResource(String path, Object bodyPayload) {
        return given()
                .spec(spec)
                .body(bodyPayload)
                .when()
                .post(path)
                .then()
                .statusCode(201)
                .extract().header("location");
    }


    protected <T> T getResource(String locationHeader, Class<T> responseClass) {
        return given()
                .spec(spec)
                .when()
                .get(locationHeader)
                .then()
                .statusCode(200)
                .extract().as(responseClass);
    }
    protected String getResourceError(String path) {
        return given()
                .spec(spec)
                .when()
                .get(path)
                .then()
                .statusCode(404)
                .extract().body().asString();
    }

    protected void deleteResource(String path) {
             given()
                .spec(spec)
                .when()
                .delete(path)
                .then()
                .statusCode(204);
    }
    protected void editResource(String path, Object bodyPayload){
        given()
                .spec(spec)
                .body(bodyPayload)
                .when()
                .put(path)
                .then()
                .statusCode(200);
    }

    protected String createResourceErrorName(String path, Object bodyPayload){
        return given()
                .spec(spec)
                .body(bodyPayload)
                .when()
                .post(path)
                .then()
                .statusCode(409)
                .extract().body().asString();
    }
    protected String editResourceError(String path, Object bodyPayload) {
        return given()
                .spec(spec)
                .body(bodyPayload)
                .when()
                .put(path)
                .then()
                .statusCode(404)
                .extract().body().asString();
    }
    protected String deleteResourceError(String path) {
        return given()
                .spec(spec)
                .when()
                .delete(path)
                .then()
                .statusCode(404)
                .extract().body().asString();
    }
    protected List<User> getAll(String path){
        List<User> list = new ArrayList<>();
        return list = given()
                .spec(spec)
                .when()
                .get(path)
                .then()
                .statusCode(200)
                .extract().body().as(list.getClass());
    }


}
