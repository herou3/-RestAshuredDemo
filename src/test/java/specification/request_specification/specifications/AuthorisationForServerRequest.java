package specification.request_specification.specifications;

import app_context.AppContext;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import specification.request_specification.Request;

public class AuthorisationForServerRequest implements Request {
    @Override
    public RequestSpecification createRequestSpecification() {
        String urlForAuth = (AppContext.get("protocolType", String.class) + "://"
                + AppContext.get("login")
                + ":"
                + AppContext.get("password")
                + "@"
                + AppContext.get("domainName",String.class));
        return new RequestSpecBuilder()
                .setBaseUri(urlForAuth)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.URI)
                .log(LogDetail.METHOD)
                .log(LogDetail.HEADERS)
                .log(LogDetail.BODY)
                .build();
    }
}
