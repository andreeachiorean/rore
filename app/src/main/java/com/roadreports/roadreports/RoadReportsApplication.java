package com.roadreports.roadreports;

import android.app.Application;
import android.os.Environment;
import android.util.Base64;

import com.facebook.stetho.Stetho;
import com.roadreports.roadreports.backend.realm.RealmPublicMigration;
import com.roadreports.roadreports.backend.realm.modules.PublicDataModule;

import java.security.SecureRandom;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by andreea on 4/26/17.
 */

public class RoadReportsApplication extends Application {

    private RealmConfiguration realmDefaultConfiguration;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

       /* String keyString = SharedPrefUtil.readPreferences(this, SharedPrefUtil.KEY_ENCRYPTION, null);
        byte[] key = new byte[64];
        if (keyString != null) {
            //we already have a key
            key = Base64.decode(keyString, 0);
        } else {
            //generate key
            new SecureRandom().nextBytes(key);
            SharedPrefUtil.savePreferences(this, SharedPrefUtil.KEY_ENCRYPTION, Base64.encodeToString(key, 0));
        }*/

        //Log.d("App", byteArrayToHex(key));

        Realm.init(this);
        realmDefaultConfiguration = new RealmConfiguration.Builder()
                .directory(Environment.getExternalStorageDirectory())
               // .encryptionKey(key)
                .name("RoRe.realm") //AppConfig.APP_NAME
                .schemaVersion(RealmPublicMigration.SCHEMA_VERSION)
                .migration(new RealmPublicMigration())
                .modules(new PublicDataModule())
                .build();
        Realm.setDefaultConfiguration(realmDefaultConfiguration);
    }

    public RealmConfiguration getRealmDefaultConfiguration() {
        return realmDefaultConfiguration;
    }

}
