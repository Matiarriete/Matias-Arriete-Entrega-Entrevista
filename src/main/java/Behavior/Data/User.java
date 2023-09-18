package Behavior.Data;

public class User {
    public Integer id;
    public String name;
    public String email;
    public String gender;
    public String status;

    public User(String name, String email, String gender, String status) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String creationString() {
        return "{\n" +
                "\"name\":\""+ this.name +"\",\n" +
                "\"email\":\""+ this.email +"\",\n" +
                "\"gender\":\""+ this.gender +"\",\n" +
                "\"status\":\""+ this.status +"\"\n" +
                "}";
    }
}

