package com.example.rixspi.sqllitemanipulation.di.main;


import com.example.rixspi.sqllitemanipulation.di.base.scope.ActivityScope;
import com.example.rixspi.sqllitemanipulation.ui.main.MainActivity;

import dagger.Subcomponent;

/**
 * @author Marcin Przepiórkowski
 * @since 25.02.2017
 */
@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    MainActivity inject(MainActivity mainActivity);
}