package specification.request_specification.specifications;

import app_context.AppContext;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import specification.request_specification.Request;

public class RouteRequest implements Request {
    @Override
    public RequestSpecification createRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(AppContext.get("url", String.class))
                .setContentType("application/octet-stream")
                .setAccept(ContentType.JSON)
                .log(LogDetail.URI)
                .log(LogDetail.METHOD)
                .log(LogDetail.HEADERS)
                .log(LogDetail.BODY)
                .build();
    }
}
