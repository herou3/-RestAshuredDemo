package specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import lombok.Getter;
import statuscode.StatusCode;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BaseResponse {
    @Getter
    private final ResponseSpecification responseSpecification;

    public BaseResponse() {
        this.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public ResponseSpecification getResponseSpecificationWithSchemaChecker(String schema, StatusCode statusCode) {
        this.responseSpecification.statusCode(statusCode.getValue());
        this.responseSpecification.body(matchesJsonSchemaInClasspath(schema));
        return this.responseSpecification;
    }
}
