package com.example.stayupdated.pojo;

public class favorite {
    public String heading;
    public String description;
    public String imageUrl;
    private int id;



    public favorite( int id,String heading, String description, String imageUrl) {
        this.id = id;
        this.heading = heading;
        this.description = description;
        this.imageUrl = imageUrl;

    }

    public favorite(String heading, String description, String imageUrl) {
        this.heading = heading;
        this.description = description;
        this.imageUrl = imageUrl;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
