import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class OrdersListTests {
    @Before
    public void start() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    @Test
    @DisplayName("Проверка получения списка заказов /api/v1/orders")
    public void getListOrdersTest() {
        given().header("Content-type", "application/json").log().all().get("/api/v1/orders").then().assertThat().statusCode(200);
    }
}
