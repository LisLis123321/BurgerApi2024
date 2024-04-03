public class User {
    public String email;
    public String name;
    public String password;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
