package com.roadreports.roadreports.backend.realm.dao;

import java.sql.Timestamp;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by andreea on 4/26/17.
 */

public class RealmTripDao extends RealmObject {
    @PrimaryKey
    private int Id;
    private String StartDate;
    private String EndDate;
    private long StartKm;
    private long EndKm;
    private long Distance;

    private RealmList<RealmServiceLocationDao> ServiceLocations;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public long getStartKm() {
        return StartKm;
    }

    public void setStartKm(long startKm) {
        StartKm = startKm;
    }

    public long getEndKm() {
        return EndKm;
    }

    public void setEndKm(long endKm) {
        EndKm = endKm;
    }

    public long getDistance() {
        return Distance;
    }

    public void setDistance(long distance) {
        Distance = distance;
    }

    public RealmList<RealmServiceLocationDao> getServiceLocations() {
        return ServiceLocations;
    }

    public void setServiceLocations(RealmList<RealmServiceLocationDao> serviceLocations) {
        ServiceLocations = serviceLocations;
    }

    @Override
    public String toString() {
        return "RealmTripDao{" +
                "Id=" + Id +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                ", StartKm=" + StartKm +
                ", EndKm=" + EndKm +
                ", Distance=" + Distance +
                ", ServiceLocations=" + ServiceLocations +
                '}';
    }
}
