package com.example.rixspi.sqllitemanipulation.di.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.rixspi.sqllitemanipulation.data.model.db.Models;
import com.example.rixspi.sqllitemanipulation.db.DatabaseWrapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.requery.Persistable;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.reactivex.ReactiveEntityStore;
import io.requery.reactivex.ReactiveSupport;
import io.requery.sql.Configuration;
import io.requery.sql.ConfigurationBuilder;
import io.requery.sql.EntityDataStore;
import io.requery.sql.TableCreationMode;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Marcin Przepiórkowski
 * @since 08.05.2016
 */
@Module
public class AppModule {
    Application mApplication;

    public AppModule(@NonNull Application application) {
        mApplication = checkNotNull(application);
    }

    @Provides
    @Singleton
    ReactiveEntityStore<Persistable> provideDataStore() {
        DatabaseSource source = new DatabaseSource(mApplication, Models.DEFAULT, 1) {
            @Override
            protected void onConfigure(ConfigurationBuilder builder) {
                super.onConfigure(builder);

                builder.setQuoteColumnNames(true);
                builder.setQuoteTableNames(true);
            }
        };
        source.setTableCreationMode(TableCreationMode.DROP_CREATE);
        Configuration configuration = source.getConfiguration();

        return ReactiveSupport.toReactiveStore(new EntityDataStore<>(configuration));
    }

    @Provides
    @Singleton
    DatabaseWrapper provideDatabaseWrapper(@NonNull ReactiveEntityStore<Persistable> singleEntityStore) {
        return new DatabaseWrapper(singleEntityStore);
    }

    @Provides
    @NonNull Context provideContext() {
        return mApplication.getApplicationContext();
    }
}