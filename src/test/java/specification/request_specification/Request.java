package specification.request_specification;

import io.restassured.specification.RequestSpecification;

public interface Request {
    RequestSpecification createRequestSpecification();
}
