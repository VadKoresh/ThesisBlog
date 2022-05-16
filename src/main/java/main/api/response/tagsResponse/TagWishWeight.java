package main.api.response.tagsResponse;

public class TagWishWeight {

    private String name;
    private Double weight;

    public TagWishWeight(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public TagWishWeight() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
