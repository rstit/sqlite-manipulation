package com.example.rixspi.sqllitemanipulation.di.base;

import android.support.annotation.NonNull;

import com.example.rixspi.sqllitemanipulation.data.base.EntityConverter;
import com.example.rixspi.sqllitemanipulation.data.model.news.News;
import com.example.rixspi.sqllitemanipulation.data.news.NewsConverter;
import com.example.rixspi.sqllitemanipulation.data.news.NewsRepository;
import com.example.rixspi.sqllitemanipulation.data.news.NewsRepositoryImpl;
import com.example.rixspi.sqllitemanipulation.db.DatabaseWrapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ryszard Śpiewak on 13.04.2017.
 */
@Module
public class RepositoryModule {

    @Singleton
    @Provides
    /*package*/ EntityConverter<com.example.rixspi.sqllitemanipulation.data.model.db.News, News> provideWorkoutConverter() {
        return new NewsConverter();
    }

    @Singleton
    @Provides
    /*package*/ NewsRepository provideNewsRepository( @NonNull DatabaseWrapper db,
                                                      @NonNull EntityConverter<com.example.rixspi.sqllitemanipulation.data.model.db.News, News> converter) {
        return new NewsRepositoryImpl( db, converter);
    }
}
