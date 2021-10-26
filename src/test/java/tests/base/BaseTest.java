package tests.base;

import app_context.AppContext;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import utils.PropertyReader;

public class BaseTest {
    @BeforeSuite()
    public void preconditionForAllTest() {
        PropertyReader.getRequestProperties();
        System.out.println(AppContext.get("url", String.class));
        System.out.println("preconditionForAllTestpreconditionForAllTestpreconditionForAllTest");
        RestAssured.filters(new AllureRestAssured());
    }
}
