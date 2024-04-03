import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class MainTest {
    String a;
    String b;

    UserController newUser = new UserController();

    @Test
    @Step("Добавляем нового пользователя")
    public void addUser() {
        String a;
        User user = new User("hitrovaleks011111111111111@gmail.com", "Aleksandr", "Sevast1122@");
        a = newUser.addNewUser(user).jsonPath().get("user").toString();
        assertTrue(a.contains("Aleksandr"));

        user = new User("hitrovaleks011111111111111@gmail.com", "Aleksandr", "Sevast1122@");
        b = String.valueOf(newUser.deleteTestData(user).jsonPath().get("Status").toString());
        assertTrue(a.contains("200 OK"));
    }

    @Test
    @Step("Добавляем существующего пользователя")
    public void addExistingUser() {
        String a;
        User user = new User("hitrovaleks9111@gmail.com", "Aleksandr", "Sevast1122@");
        a = newUser.addNewUser(user).jsonPath().get("success").toString();
        assertTrue(a.contains("true"));

        user = new User("hitrovaleks9111@gmail.com", "Aleksandr", "Sevast1122@");
        b = String.valueOf(newUser.addExistingUser(user).jsonPath().get("message").toString());

        assertTrue(b.contains("User already exists"));

    }

    @Test
    @Step("Добавляем пользователя без обязательного поля")
    public void userWithoutAbligatoryField() {
        User user = new User("hitrovaleks91211@gmail.com", "Alex");
        a = newUser.addUserWithoutObligatoryField(user).jsonPath().get("message").toString();
        assertTrue(a.contains("Email, password and name are required fields"));
    }

    @Test
    @Step("Авторизуемся под существующим пользователем")
    public void loginExistingUser() {
        User user = new User("hitrovaleks9111@gmail.com", "Aleksandr", "Sevast1122@");
        a = newUser.loginExistingUser(user).jsonPath().get("user").toString();
        assertTrue(a.contains("hitrovaleks9111@gmail.com"));
    }

    @Test
    @Step("Авторизуемся с невалидным паролем")
    public void loginWithIncorrectPass() {
        User user = new User("hitrovaleks9111@gmail.com", "Aleksandr", "Sevast112");
        a = newUser.loginWithIncorrectData(user).jsonPath().get("message").toString();
        assertTrue(a.contains("email or password are incorrect"));
    }

    @Test
    @Step("Обновляем данные авторизованного пользователя")
    public void updateAuthorizedUser() {
        User user = new User("hitrovaleks9111@gmail.com", "Aleksandr", "Sevast1122@");
        a = newUser.loginExistingUser(user).jsonPath().get("user").toString();
        user = new User("hitrovaleks9111@gmail.com", "Aleksandr", "Sevast1122@");
        a = newUser.updateUser(user).jsonPath().get("user").toString();


//        Assertions.assertTrue(b.contains("hitrovaleks9111@gmail.com"));
    }

//    @After
//    @Step("Удаление тестовых данных, после каждого теста")
//    public void tearDownAfterTest() throws Exception {
//        User user = new User();
//        newUser.deleteTestData(user).jsonPath().get().toString();
//    }
}
