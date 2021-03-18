package com.example.stayupdated.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class favorite implements Parcelable {
    public String heading;
    public String description;
    public String imageUrl;
//    private String editButton;
    private int id;


//    public favorite(int id,String heading, String description, String imageUrl) {
//        this.id = id;
//        this.heading = heading;
//        this.description = description;
//        this.imageUrl = imageUrl;
////        this.editButton = editButton;
//    }

    public favorite(int id, String heading, String description, String imageUrl) {
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

    protected favorite(Parcel in) {
        id = in.readInt();
        heading = in.readString();
        description = in.readString();
        imageUrl = in.readString();
//        editButton = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(heading);
        dest.writeString(description);
        dest.writeString(imageUrl);
//        dest.writeString(editButton);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<favorite> CREATOR = new Creator<favorite>() {
        @Override
        public favorite createFromParcel(Parcel in) {
            return new favorite(in);
        }

        @Override
        public favorite[] newArray(int size) {
            return new favorite[size];
        }
    };

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

//    public String getEditButton() {
//        return editButton;
//    }
//
//    public void setEditButton(String editButton) {
//        this.editButton = editButton;
//    }


}
