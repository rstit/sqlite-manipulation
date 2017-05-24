package com.example.rixspi.sqllitemanipulation.data.news;

import android.support.annotation.NonNull;

import com.example.rixspi.sqllitemanipulation.data.base.Repository;
import com.example.rixspi.sqllitemanipulation.data.model.news.News;

/**
 * Created by Ryszard Śpiewak on 12.04.2017.
 */

public interface NewsRepository extends Repository<News, NewsRepositorySpecification> {
    void storeInDb(@NonNull News news);
}
