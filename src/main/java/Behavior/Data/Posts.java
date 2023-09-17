package Behavior.Data;

public class Posts {

    private Integer id;
    private Integer user_id;
    private String title;
    private String body;

    public Posts(Integer user_id, String title, String body) {
        this.user_id = user_id;
        this.title = title;
        this.body = body;
    }

    public Posts() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                "user_id=\"" + user_id +
                "\",\ntitle=\"" + title + '\"' +
                ",\nbody=\"" + body + '\"' +
                "\n }";
    }
}
