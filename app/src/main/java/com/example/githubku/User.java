package com.example.githubku;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class User extends ArrayList<Parcelable> implements Parcelable {
    private int image;
    private String username;
    private String name;
    private String followers;
    private String following;
    private String location;
    private String repository;
    private String company;

    protected User(Parcel in) {
        image = in.readInt();
        username = in.readString();
        name = in.readString();
        followers = in.readString();
        following = in.readString();
        location = in.readString();
        repository = in.readString();
        company = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User() {

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(username);
        parcel.writeString(name);
        parcel.writeString(followers);
        parcel.writeString(following);
        parcel.writeString(location);
        parcel.writeString(repository);
        parcel.writeString(company);
    }
}
