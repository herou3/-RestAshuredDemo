package specification.response_specification.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import specification.response_specification.Response;

public class CommonResponseFromServer implements Response {
    @Override
    public ResponseSpecification createResponseSpecification() {
        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectContentType(ContentType.JSON)
                .build();
        return responseSpecification;
    }
}
