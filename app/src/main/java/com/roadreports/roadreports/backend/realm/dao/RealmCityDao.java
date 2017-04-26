package com.roadreports.roadreports.backend.realm.dao;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by andreea on 4/26/17.
 */

public class RealmCityDao extends RealmObject {
    @PrimaryKey
    private int Id;
    private String Name;
    private RealmList<RealmServiceLocationDao> ServiceLocations;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public RealmList<RealmServiceLocationDao> getServiceLocations() {
        return ServiceLocations;
    }

    public void setServiceLocations(RealmList<RealmServiceLocationDao> serviceLocations) {
        ServiceLocations = serviceLocations;
    }

    @Override
    public String toString() {
        return "RealmCityDao{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", ServiceLocations=" + ServiceLocations +
                '}';
    }
}
