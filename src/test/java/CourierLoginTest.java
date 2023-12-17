import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class CourierLoginTest {

    @Before
    public void start() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Проверка авторизации курьера позитивный тест")
    public void verifyCreatingCourierLoginTest() {
        CourierItem courierItem = new CourierItem();
        Response postRequestCourierLogin = courierItem.getRequestCourierLogin(new Courier("Algerd", "12345", "frodo"));
        postRequestCourierLogin.then().log().all().assertThat().statusCode(200).and().body("id", Matchers.notNullValue());
    }

    @Test
    @DisplayName("Проверка авторизации курьера без логина")
    public void verifyVerificationWithoutLoginAuthorization() {
        CourierItem courierItem = new CourierItem();
        Response postRequestCourierLogin = courierItem.getRequestCourierLogin(new Courier("", "12345", "frodo"));
        postRequestCourierLogin.then().log().all().assertThat().statusCode(400).and().body("message", Matchers.is("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Проверка авторизации курьера без пароля")
    public void verifyVerificationWithoutPasswordAuthorization() {
        CourierItem courierItem = new CourierItem();
        Response postRequestCourierLogin = courierItem.getRequestCourierLogin(new Courier("Algerd", "", "frodo"));
        postRequestCourierLogin.then().log().all().assertThat().statusCode(400).and().body("message", Matchers.is("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Проверка авторизации курьера в системе 'Учетная запись не найдена'")
    public void verifyAuthorizationUnderIncorrectLogin() {
        CourierItem courierItem = new CourierItem();
        Response postRequestCourierLogin = courierItem.getRequestCourierLogin(new Courier("cds", "753"));
        postRequestCourierLogin.then().log().all().assertThat().statusCode(404).and().body("message", Matchers.is("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Попытка авторизации с некорректным логином")
    public void verifyEnterInvalidLogin() {
        CourierItem courierItem = new CourierItem();
        Response postRequestCourierLogin = courierItem.getRequestCourierLogin(new Courier("Alrd", "12345"));
        postRequestCourierLogin.then().log().all().assertThat().statusCode(404).and().body("message", Matchers.is("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Попытка авторизации с некорректным паролем")
    public void verifyEnterInvalidPassword() {
        CourierItem courierItem = new CourierItem();
        Response postRequestCourierLogin = courierItem.getRequestCourierLogin(new Courier("Algerd", "123"));
        postRequestCourierLogin.then().log().all().assertThat().statusCode(404).and().body("message", Matchers.is("Учетная запись не найдена"));
    }
}
