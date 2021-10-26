package specification.response_specification;

import io.restassured.specification.ResponseSpecification;

public interface Response {
    ResponseSpecification createResponseSpecification();
}
