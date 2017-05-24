package com.example.rixspi.sqllitemanipulation;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.rixspi.sqllitemanipulation.di.base.AppComponent;
import com.example.rixspi.sqllitemanipulation.di.base.AppModule;
import com.example.rixspi.sqllitemanipulation.di.base.DaggerAppComponent;
import com.facebook.stetho.Stetho;

/**
 * Created by Ryszard Śpiewak on 12.04.2017.
 */

public class SqliteExample extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());

    }

    public @NonNull
    AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static @NonNull SqliteExample get(@NonNull Context context) {
        return (SqliteExample) context.getApplicationContext();
    }
}
