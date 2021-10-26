package services;

import io.restassured.response.Response;
import models.api.User;

public interface AuthService extends BasicService {
    User register(User user);
    Response registerTwo(User user);
    User login(User user);
}