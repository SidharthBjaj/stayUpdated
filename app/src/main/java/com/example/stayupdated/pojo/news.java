package com.example.stayupdated.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class news {
    public String heading;
    public String description;
    public String imageUrl;
    public String source;
    public String detailUrl;



    public news(String heading, String description, String detailUrl, String source) {
        this.heading = heading;
        this.description = description;
        this.detailUrl = detailUrl;
        this.source = source;
    }

    public news(String heading, String description, String detailUrl, String source, String section, String imageUrl) {
        this.heading = heading;
        this.description = description;
        this.detailUrl = detailUrl;
        this.source = source;
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

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


}
