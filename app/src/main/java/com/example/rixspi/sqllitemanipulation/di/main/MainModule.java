package com.example.rixspi.sqllitemanipulation.di.main;

import android.support.annotation.NonNull;

import com.example.rixspi.sqllitemanipulation.di.base.scope.ActivityScope;
import com.example.rixspi.sqllitemanipulation.ui.main.MainActivity;
import com.example.rixspi.sqllitemanipulation.ui.main.MainViewAccess;

import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Marcin Przepiórkowski
 * @since 25.02.2017
 */
@Module
public class MainModule {
    private MainActivity mMainActivity;

    public MainModule(@NonNull MainActivity mainActivity) {
        mMainActivity = checkNotNull(mainActivity);
    }

    @Provides
    @ActivityScope
    @NonNull MainActivity provideMainActivity() {
        return mMainActivity;
    }

    @Provides
    @ActivityScope
    @NonNull MainViewAccess provideMainViewAccess() {
        return mMainActivity;
    }
}