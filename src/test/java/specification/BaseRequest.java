package specification;

import app_context.AppContext;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import models.api.Base;
import models.api.User;

public class BaseRequest {

    @Getter
    private final RequestSpecification requestSpecification;

    public BaseRequest() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(AppContext.get("url", String.class))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.URI)
                .log(LogDetail.METHOD)
                .log(LogDetail.HEADERS)
                .log(LogDetail.BODY)
                .build();
    }

    public RequestSpecification getXMLRequest() {
        this.requestSpecification.contentType(ContentType.XML);
        return this.requestSpecification;
    }


    public RequestSpecification getRequestForAuth(User user) {
        String urlForAuth = (AppContext.get("protocolType", String.class) + "://"
                + user.getEmail()
                + ":"
                + user.getPassword()
                + "@"
                + AppContext.get("domainName",String.class));
        this.requestSpecification.baseUri(urlForAuth);
        return this.requestSpecification;
    }

    public RequestSpecification getBodyRequest(Base base) {
        this.requestSpecification.body(base);
        return this.requestSpecification;
    }
}
