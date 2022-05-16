package main.api.response.postResponse;

import java.util.List;

public class PostResponse {

    private final int count;
    private List<PostDetailsResponse> posts;

    public PostResponse(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public List<PostDetailsResponse> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDetailsResponse> posts) {
        this.posts = posts;
    }
}
