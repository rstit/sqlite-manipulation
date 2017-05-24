package com.example.rixspi.sqllitemanipulation.di.base;


import com.example.rixspi.sqllitemanipulation.di.main.MainComponent;
import com.example.rixspi.sqllitemanipulation.di.main.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Marcin Przepiórkowski
 * @since 08.05.2016
 */
@Singleton
@Component(modules = {
        AppModule.class,
        RepositoryModule.class
})

public interface AppComponent {
    MainComponent plus(MainModule module);
}