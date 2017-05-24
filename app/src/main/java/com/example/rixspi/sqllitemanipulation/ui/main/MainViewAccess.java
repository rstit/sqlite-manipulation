package com.example.rixspi.sqllitemanipulation.ui.main;

import android.support.annotation.NonNull;

import com.example.rixspi.sqllitemanipulation.ui.base.adapter.MultiViewAdapter;

/**
 * Created by Ryszard Śpiewak on 12.04.2017.
 */

public interface MainViewAccess {
    @NonNull MultiViewAdapter getAdapter();

    @NonNull String getSampleContentMessage();

    void showCannotFetchNewsMessage();
    void notifyDatasetChanged();
}
