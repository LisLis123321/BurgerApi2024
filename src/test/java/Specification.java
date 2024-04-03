import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
    /** Метод содержит спесификацию для отправки запроса
     * @author Москвичёв Виктор
     */
    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    /** Метод содержит спесификацию для получения ответа
     * @author Москвичёв Виктор
     */
    public static ResponseSpecification responseSpec(Integer status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }


    /** Метод для установки объявленных спецификаций
     * @author Москвичёв Виктор
     */
    public static void installSpecification(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

    /** Метод для удаления спецификаций
     * @author Москвичёв Виктор
     */
    public static void deleteSpec() {
        RestAssured.requestSpecification = null;
        RestAssured.responseSpecification = null;
    }
}
