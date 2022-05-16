package main.api.response.postResponse;

public class UserResponse4PostDetails {

    private final int id;
    private final String name;

    public UserResponse4PostDetails(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
