package seminars.third.tdd;

public class User {

    String name;
    String password;

//    boolean isAuthenticate = false;

    public User(String name, String password) {
        this.name = name;
        this.password = password;

    }

    //3.6.
    public boolean authenticate(String inputUsername, String inputPassword) {
        return name.equals(inputUsername) && password.equals(inputPassword);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}