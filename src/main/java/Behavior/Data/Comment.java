package Behavior.Data;

public class Comment {
    private Integer id;
    private Integer post_id;
    private String name;
    private String email;
    private String body;

    public Comment(String name, String email, String body) {
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Comment() {
    }

    public Comment(Integer id, Integer post_id, String name, String email, String body) {
        this.id = id;
        this.post_id = post_id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"name\":\"" + name + '\"' +
                ",\n \"email\":\"" + email + '\"' +
                ",\n \"body\":\"" + body + '\"' +
                '}';
    }
}
