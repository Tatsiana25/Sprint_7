import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class OrdersCreatingTests {


    private final Orders orders;
    private static String createdOrderId;

    public OrdersCreatingTests(Orders orders) {
        this.orders = orders;
    }

    @Before
    public void start() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getTestData() {
        return new Object[][]{{new Orders("Вассисуалий", "Зенбельшухер", "ул.Ленина 153",
                "Тверская", "+78887776665", 3, "2023-12-16", "обязательно надуть в колёса",
                new String[]{"BLACK"})}, {new Orders("Анисим", "Крюк", "ул.Пушкина 21", "Сокольники",
                "+78887776666", 4, "2023-12-17", "без комментариев и камеру выключи", new String[]{"GREY"})},
                {new Orders("Гамбас", "Апердулаев", "ул.Калинина 42", "Белорусская",
                        "+78887776667", 6, "2023-12-18", "", new String[]{"BLACK", "GREY"})},
                {new Orders("Анфиса", "Моргунова", "ул.Проспект Космонавтов 18", "Динамо",
                        "+78887776668", 3, "2023-12-19", "", new String[]{})},};
    }

    @Test
    public void verifyCreateOrder() {
        createdOrderId = given().log().all().header("Content-type", "application/json").body(orders).when().post("/api/v1/orders")
                .then().log().all().assertThat().and().statusCode(201).body("track", Matchers.notNullValue())
                .extract().jsonPath().getString("id");
    }


    @AfterClass
    public static void tearDown() {
        if (createdOrderId != null) {
            given().pathParam("id", createdOrderId).when().delete("/api/v1/orders/{id}").then().log().all().statusCode(200);
        }
    }
}
