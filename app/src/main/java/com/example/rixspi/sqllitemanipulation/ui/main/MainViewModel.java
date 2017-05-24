package com.example.rixspi.sqllitemanipulation.ui.main;

import com.example.rixspi.sqllitemanipulation.data.model.author.Author;
import com.example.rixspi.sqllitemanipulation.data.model.news.News;
import com.example.rixspi.sqllitemanipulation.data.news.NewsRepository;
import com.example.rixspi.sqllitemanipulation.ui.base.model.BaseViewModel;
import com.example.rixspi.sqllitemanipulation.ui.base.model.RowViewModel;
import com.example.rixspi.sqllitemanipulation.ui.news.NewsRowViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ryszard Śpiewak on 12.04.2017.
 */

public class MainViewModel extends BaseViewModel {
    @Inject
    protected MainViewAccess mViewAccess;

    @Inject
    NewsRepository mNewsRepo;

    public List<RowViewModel> mNews = new ArrayList<>();


    @Inject
    public MainViewModel(){
    }

    void prepareSampleData(){
        for (int i=1;i<50;i++) {
            Author a = Author.builder()
                    .id(i)
                    .name("Author " + i)
                    .surname("Surname")
                    .build();

            News n = News.builder()
                    .author(a)
                    .id(i)
                    .title("News title")
                    .content(mViewAccess.getSampleContentMessage() + i)
                    .build();

            mNewsRepo.storeInDb(n);
        }
    }


    void fetchNews() {
        Disposable d = mNewsRepo.fetch(null)
                .map(NewsRowViewModel::new)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        rows -> {
                            mNews.clear();
                            mNews.addAll(rows);
                            mViewAccess.notifyDatasetChanged();
                        },
                        throwable -> mViewAccess.showCannotFetchNewsMessage()
                );

        registerDisposable(d);
    }
}
