package com.roadreports.roadreports.backend.realm.dao;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by andreea on 4/26/17.
 */

public class RealmServiceLocationDao extends RealmObject {
    @PrimaryKey
    private int Id;
    private String Location;
    //private int CityId;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    /*public int getCityId() {
        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }*/

    @Override
    public String toString() {
        return "RealmServiceLocationDao{" +
                "Id=" + Id +
                ", Location='" + Location + '\'' +
               // ", CityId=" + CityId +
                '}';
    }
}
