package com.automation.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class ApiSteps {
    private static Response response;
    private String url;
    private static final String BASE_URL = "https://rickandmortyapi.com";
    private static final int CODE_200 = 200;


    public void prepareData(String pathUrl) {
        String path = "/api/" + pathUrl + "/";
        url = BASE_URL.concat(path);
    }

    public Response consumeTheApi(String data) {
        try {
            response = given().contentType(ContentType.JSON).relaxedHTTPSValidation()
                    .when().get(url.concat(data))
                    .then().extract().response();
            response.getStatusCode();
            return response;

        } catch (Exception e) {
            return null;
        }
    }

    public void checkStatus(int statusCode) {
        int sc = response.getStatusCode();
        Assertions.assertEquals(response.getStatusCode(), statusCode);
    }

    public void checkCharacterResponse(String expectedresponse) {
        if (response.getStatusCode() == CODE_200) {
            String username = response.jsonPath().get("name");
            String status = response.jsonPath().get("status");
            String species = response.jsonPath().get("species");
            int id = response.jsonPath().get("id");

            Assertions.assertEquals(expectedresponse.split(",")[0], username);
            Assertions.assertEquals(expectedresponse.split(",")[1], status);
            Assertions.assertEquals(expectedresponse.split(",")[2], species);
            Assertions.assertTrue(id > 0);
        } else {

            String error = response.jsonPath().get("error");
            Assertions.assertEquals(expectedresponse, error);

        }
    }

    public void checkResponseFromCharacterApi(String expectedResponse) {
        if (response.getStatusCode() == CODE_200) {
            String username = response.jsonPath().get("name");
            String status = response.jsonPath().get("status");
            String species = response.jsonPath().get("species");
            int id = response.jsonPath().get("id");


            Assertions.assertEquals(expectedResponse.split(",")[0], username);
            Assertions.assertEquals(expectedResponse.split(",")[1], status);
            Assertions.assertEquals(expectedResponse.split(",")[2], species);
            Assertions.assertTrue(id > 0);
        } else {

            String error = response.jsonPath().get("error");
            Assertions.assertEquals(expectedResponse, error);

        }
    }

    public void checkResponseFromLocationApi(String expectedResponse) {
        if (response.getStatusCode() == CODE_200) {
            String username = response.jsonPath().get("name");
            String type = response.jsonPath().get("type");
            String dimension = response.jsonPath().get("dimension");
            int id = response.jsonPath().get("id");


            Assertions.assertEquals(expectedResponse.split(",")[0], username);
            Assertions.assertEquals(expectedResponse.split(",")[1], type);
            Assertions.assertEquals(expectedResponse.split(",")[2], dimension);
            Assertions.assertTrue(id > 0);
        } else {

            String error = response.jsonPath().get("error");
            Assertions.assertEquals(expectedResponse, error);

        }
    }

    public void checkResponseFromEpisodeApi(String expectedResponse) {
        if (response.getStatusCode() == 200) {
            String username = response.jsonPath().get("name");
            String airDate = response.jsonPath().get("air_date");
            String episode = response.jsonPath().get("episode");
            int id = response.jsonPath().get("id");


            Assertions.assertEquals(expectedResponse.split("--")[0], username);
            Assertions.assertEquals(expectedResponse.split("--")[1], airDate);
            Assertions.assertEquals(expectedResponse.split("--")[2], episode);
            Assertions.assertTrue(id > 0);
        } else {

            String error = response.jsonPath().get("error");
            Assertions.assertEquals(expectedResponse, error);

        }
    }
}
