import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierItem {
    private static final String CREATE_COURIER = "api/v1/courier";
    private static final String DELETE_COURIER = "/api/v1/courier/{id}";
    private static final String CREATE_LOGIN_COURIER = "/api/v1/courier/login";

    @Step("Создание курьера c проверкой кода ответа")
    public Response getRequestCreateCourier(Courier courier) {
        return given().log().all().filter(new AllureRestAssured()).header("Content-type", "application/json").body(courier).when().post(CREATE_COURIER);
    }

    @Step("Авторизация курьера в системе с получением id и проверкой кода ответа")
    public Response getRequestCourierLogin(Courier courier) {
        return given().log().all().header("Content-type", "application/json").body(courier).when().post(CREATE_LOGIN_COURIER);
    }

    @Step("Удаление курьера c проверкой кода ответа")
    public Response deleteCourierById(String courierId) {
        return given().pathParam("id", courierId).when().delete(DELETE_COURIER).then().log().all().statusCode(200).extract().response();
    }
}
