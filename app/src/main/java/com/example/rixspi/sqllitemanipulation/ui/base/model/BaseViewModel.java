package com.example.rixspi.sqllitemanipulation.ui.base.model;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Marcin Przepiórkowski
 * @since 08.03.2016
 */
public class BaseViewModel extends BaseObservable {
    protected final CompositeDisposable mDisposables = new CompositeDisposable();

    protected void registerDisposable(@NonNull Disposable d) {
        mDisposables.add(checkNotNull(d));
    }

    public void clearDisposables() {
        mDisposables.clear();
    }
}