package tests;

import impl.AuthServiceImpl;
import models.api.Base;
import models.api.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.AuthService;
import tests.base.BaseTest;

public class AuthControllerTests extends BaseTest {
    private final AuthService authService = new AuthServiceImpl();

    @Test(description = "Создание нового пользователя в системе")
    public void createNewUse() {
        User newUser = User.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();


        User createdUser = authService.register(newUser);

        Assert.assertNotNull(createdUser);
        Assert.assertEquals(createdUser.getId(), Integer.valueOf(4));
        Assert.assertNotNull(createdUser.getToken());
    }

    @Test(description = "Проверка работы авторизации в системе")
    public void checkSignInForSystem() {
        User newUser = User.builder()
                .email("eve.holt@reqres.in")
                .password("cityslicka")
                .build();

        User createdUser = authService.login(newUser);

        Assert.assertNotNull(createdUser);
        Assert.assertNotNull(createdUser.getToken());
    }
}
