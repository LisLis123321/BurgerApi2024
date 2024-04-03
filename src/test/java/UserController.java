import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserController {
    public Response addNewUser(User user) {
        Specification.installSpecification(Specification.requestSpec(Constants.BaseUrl),
                Specification.responseSpec(200));
        return given()
                .body(user)
                .post("/api/auth/register")
                .then()
                .log().all()
                .extract().response();

    }
    public Response addExistingUser(User user) {
        Specification.installSpecification(Specification.requestSpec(Constants.BaseUrl),
                Specification.responseSpec(403));
        return given()
                .body(user)
                .post("/api/auth/register")
                .then()
                .log().all()
                .extract().response();

    }
    public Response addUserWithoutObligatoryField(User user) {
        Specification.installSpecification(Specification.requestSpec(Constants.BaseUrl),
                Specification.responseSpec(403));
        return given()
                .body(user)
                .post("/api/auth/register")
                .then()
                .log().all()
                .extract().response();

    }
    public Response loginExistingUser(User user) {
        Specification.installSpecification(Specification.requestSpec(Constants.BaseUrl),
                Specification.responseSpec(200));
        return given()
                .body(user)
                .post("/api/auth/login")
                .then()
                .log().all()
                .extract().response();

    }
    public Response loginWithIncorrectData(User user) {
        Specification.installSpecification(Specification.requestSpec(Constants.BaseUrl),
                Specification.responseSpec(401));
        return given()
                .body(user)
                .post("/api/auth/login")
                .then()
                .log().all()
                .extract().response();

    }
    public Response updateUser(User user) {
        Specification.installSpecification(Specification.requestSpec(Constants.BaseUrl),
                Specification.responseSpec(200));
        return given()
                .body(user)
                .patch("/api/auth/user")
                .then()
                .log().all()
                .extract().response();
    }
    public Response deleteTestData(User user) {
        Specification.installSpecification(Specification.requestSpec(Constants.BaseUrl),
                Specification.responseSpec(200));
        return given()
                .body(user)
                .delete("/api/auth/user")
                .then()
                .log().all()
                .extract().response();

    }
}
