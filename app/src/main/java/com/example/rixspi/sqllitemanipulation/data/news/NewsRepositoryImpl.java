package com.example.rixspi.sqllitemanipulation.data.news;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.rixspi.sqllitemanipulation.data.base.EntityConverter;
import com.example.rixspi.sqllitemanipulation.data.model.news.News;
import com.example.rixspi.sqllitemanipulation.db.DatabaseWrapper;

import io.reactivex.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Ryszard Śpiewak on 13.04.2017.
 */

public class NewsRepositoryImpl implements NewsRepository {

    private DatabaseWrapper mDbWrapper;
    private EntityConverter<com.example.rixspi.sqllitemanipulation.data.model.db.News, News> mConverter;

    public NewsRepositoryImpl(DatabaseWrapper db, EntityConverter<com.example.rixspi.sqllitemanipulation.data.model.db.News, News> entityConverter){
        this.mDbWrapper = checkNotNull(db);
        this.mConverter = checkNotNull(entityConverter);
    }

    public void storeInDb(@NonNull News news) {
        com.example.rixspi.sqllitemanipulation.data.model.db.News newsFromDb = mConverter.convertBack(checkNotNull(news));

        mDbWrapper.getData().upsert(newsFromDb).subscribe();
    }


    @Override
    public Observable<News> fetch(@Nullable NewsRepositorySpecification specification) {
        return mDbWrapper.getAllNews()
                .map(mConverter::convert);
    }
}
