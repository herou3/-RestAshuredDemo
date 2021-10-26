package tests;

import endpoint.EndPoints;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import models.api.User;
import org.testng.annotations.Test;
import specification.BaseRequest;
import specification.BaseResponse;
import statuscode.StatusCode;
import tests.base.BaseTest;

import static io.restassured.RestAssured.given;

public class CheckDetailUserTest extends BaseTest {
    @Test
    public void checkDemoTest() {
        given()
                .spec((new BaseRequest()).getRequestSpecification())
                .when()
                .get(EndPoints.USER_DETAIL.getValue(), 2)
                .then()
                .spec((new BaseResponse()).getResponseSpecificationWithSchemaChecker("userDetailResponseSchema.json", StatusCode.SUCCESS_CODE));
    }

    @Test
    public void checkPostRequest() {
        given()
                .spec(new BaseRequest().getBodyRequest(User.builder()
                        .email("Oleg")
                        .password("Automation")
                        .build()))
                .when()
                .post(EndPoints.LOGIN.getValue())
                .then();
    }
}