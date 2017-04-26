package com.roadreports.roadreports.backend.realm;

import io.realm.DynamicRealm;
import io.realm.RealmSchema;

/**
 * Created by andreea on 4/26/17.
 */

public class RealmPublicMigration implements io.realm.RealmMigration{
    public static int SCHEMA_VERSION = 0;

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

        if (oldVersion == 0) {
            /*schema.get("RealmAdviceDao")
                    .addField("testField", String.class);*/
            oldVersion++;
        }

    }
}
