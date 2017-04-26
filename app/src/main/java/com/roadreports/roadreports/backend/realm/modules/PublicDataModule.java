package com.roadreports.roadreports.backend.realm.modules;

import com.roadreports.roadreports.backend.realm.dao.RealmCityDao;
import com.roadreports.roadreports.backend.realm.dao.RealmServiceLocationDao;
import com.roadreports.roadreports.backend.realm.dao.RealmTripDao;

import io.realm.annotations.RealmModule;

/**
 * Created by andreea on 4/26/17.
 */

@RealmModule(classes = {RealmCityDao.class, RealmServiceLocationDao.class, RealmTripDao.class})

public class PublicDataModule {

}
