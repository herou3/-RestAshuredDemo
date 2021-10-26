package impl;

import app_context.AppContext;
import endpoint.EndPoints;
import io.restassured.response.Response;
import lombok.var;
import models.api.User;
import services.AuthService;
import statuscode.StatusCode;

import static io.restassured.RestAssured.given;

public class AuthServiceImpl implements AuthService {
    @Override
    public User register(User user) {
        Response response = given()
                .spec(BASE_REQUEST.getRequestSpecification())
                .body(user)
                .post(EndPoints.REGISTER.getValue());
        User test = response.as(User.class);

        if (response.statusCode() == StatusCode.SUCCESS_CODE.getValue()) {
            response.then().spec(BASE_RESPONSE.getResponseSpecification());
/*                response
                    .then()
                    .spec(BASE_RESPONSE.getResponseSpecificationWithSchemaChecker("registerResponse.json", StatusCode.SUCCESS_CODE));*/
            return response.as(User.class);

        }
        return null;
    }

    @Override
    public Response registerTwo(User user) {
        return given()
                .spec(BASE_REQUEST.getRequestSpecification())
                .body(user)
                .post(EndPoints.REGISTER.getValue());
    }

    @Override
    public User login(User user) {
        return getUser(user);
    }

    private User getUser(User user) {
/*        Response response = given()
                .spec(BASE_REQUEST.getRequestForAuth(user))
                .post(EndPoints.LOGIN.getValue());*/

        Response response = given()
                .spec(BASE_REQUEST.getRequestSpecification())
                .body(user)
                .post(EndPoints.LOGIN.getValue());

        if (response.statusCode() == StatusCode.SUCCESS_CODE.getValue()) {
            response.then().spec(BASE_RESPONSE.getResponseSpecification());
            var cookies = response.getCookies();
            AppContext.put("cookies", cookies);
            AppContext.put("user", response.as(User.class));
            return response.as(User.class);
        }
        return null;
    }
}