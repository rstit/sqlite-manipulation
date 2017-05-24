package com.example.rixspi.sqllitemanipulation.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.example.rixspi.sqllitemanipulation.R;
import com.example.rixspi.sqllitemanipulation.SqliteExample;
import com.example.rixspi.sqllitemanipulation.databinding.ActivityMainBinding;
import com.example.rixspi.sqllitemanipulation.di.main.MainModule;
import com.example.rixspi.sqllitemanipulation.ui.base.activity.BaseActivity;
import com.example.rixspi.sqllitemanipulation.ui.base.adapter.MultiViewAdapter;
import com.example.rixspi.sqllitemanipulation.ui.news.NewsRowViewModel;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainViewAccess {

    @Inject
    protected MainViewModel mModel;

    protected MultiViewAdapter mAdapter;

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SqliteExample.get(this)
                .getAppComponent()
                .plus(new MainModule(this))
                .inject(this);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setModel(mModel);
        mBinding.setView(this);

        initRecyclerView();

        mAdapter = new MultiViewAdapter.Builder(mModel.mNews)
                .register(R.layout.item_news, NewsRowViewModel.class)
                .build();

        mModel.prepareSampleData();
    }

    @Override
    public void onResume() {
        super.onResume();

        mModel.fetchNews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mModel.clearDisposables();
    }

    protected void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mBinding.rvNews.setLayoutManager(layoutManager);
    }

    @Override
    @NonNull public MultiViewAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    @NonNull public String getSampleContentMessage() {
        return getString(R.string.sample_content);
    }

    @Override
    public void showCannotFetchNewsMessage() {
        Snackbar.make(mBinding.getRoot(), getString(R.string.error_fetching_news), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void notifyDatasetChanged() {
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }
}
