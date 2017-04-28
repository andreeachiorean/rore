package com.roadreports.roadreports.backend.realm;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;

import com.roadreports.roadreports.RoadReportsApplication;
import com.roadreports.roadreports.backend.realm.dao.RealmCityDao;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by andreea on 4/28/17.
 */

public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        //realm = Realm.getDefaultInstance();
        realm = Realm.getInstance(((RoadReportsApplication)application).getRealmDefaultConfiguration());
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        //realm.refresh();
    }

    //clear all objects from Book.class
    public void clearAll() {

        realm.beginTransaction();
        realm.delete(RealmCityDao.class);
        realm.commitTransaction();
    }

    //find all objects in the Book.class
    public RealmResults<RealmCityDao> getCities() {

        return realm.where(RealmCityDao.class).findAll();
    }

    //query a single item with the given id
    public RealmCityDao getCity(int id) {

        return realm.where(RealmCityDao.class).equalTo("Id", id).findFirst();
    }

    public boolean hasCities() {

        return !realm.where(RealmCityDao.class).findAll().isEmpty();
    }

    //query example
    public RealmResults<RealmCityDao> getCitiesByName(String cityName) {

        return realm.where(RealmCityDao.class)
                .contains("Name", cityName)
                .findAll();

    }

    public void setRealmData() {

       List<RealmCityDao> cityList = new ArrayList<>();

        RealmCityDao city1 = new RealmCityDao();
        city1.setId(1);
        city1.setName("Cluj-Napoca");
        cityList.add(city1);

        RealmCityDao city2 = new RealmCityDao();
        city2.setId(2);
        city2.setName("Alba Iulia");
        cityList.add(city2);


        for (RealmCityDao city  : cityList) {
            // Persist your data easily
            realm.beginTransaction();
            realm.copyToRealm(city);
            realm.commitTransaction();
        }



    }


}
