package main.api.response.tagsResponse;

import java.util.ArrayList;

public class TagsResponse {

    private ArrayList<TagWishWeight> tags = new ArrayList<>();

    public TagsResponse(ArrayList<TagWishWeight> tags) {
        this.tags = tags;
    }

    public TagsResponse() {
    }

    public ArrayList<TagWishWeight> getTags() {
        return tags;
    }

    public void setTags(ArrayList<TagWishWeight> tags) {
        this.tags = tags;
    }
}
