package com.example.stayupdated.pojo;

public class news {
    public String heading;
    public String description;
    public String imageUrl;
    public String detailUrl;

    public news(String heading, String description, String imageUrl, String detailUrl) {
        this.heading = heading;
        this.description = description;
        this.imageUrl = imageUrl;
        this.detailUrl = detailUrl;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }
}
