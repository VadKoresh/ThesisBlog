package main.api.response.checkAuth;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthCheckResponse {

    private boolean result;
    @JsonIgnore
    private UserResponse user;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
