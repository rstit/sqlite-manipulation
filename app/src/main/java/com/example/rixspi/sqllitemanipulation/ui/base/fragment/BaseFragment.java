package com.example.rixspi.sqllitemanipulation.ui.base.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * @author Marcin Przepiórkowski
 * @since 06.03.2017
 */
public class BaseFragment extends Fragment {
    protected final BroadcastReceiver mConnectivityBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (isOnline()) {
                onOnlineModeEnabled();
            } else {
                onOfflineModeEnabled();
            }
        }
    };

    protected boolean isOnline() {
        Activity activity = getActivity();
        if (activity == null) {
            return false;
        }

        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        }

        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }

    protected void onOnlineModeEnabled() {
    }

    protected void onOfflineModeEnabled() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Activity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(mConnectivityBroadcastReceiver, new IntentFilter(
                    ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }
}