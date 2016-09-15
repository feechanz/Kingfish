package com.directdev.portal

import android.app.Application
import com.facebook.stetho.Stetho
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
import io.realm.Realm
import io.realm.RealmConfiguration
import net.danlew.android.joda.JodaTimeAndroid

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this)
        val realmConfiguration = RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(realmConfiguration)

        if (BuildConfig.DEBUG)
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build())
    }
}
