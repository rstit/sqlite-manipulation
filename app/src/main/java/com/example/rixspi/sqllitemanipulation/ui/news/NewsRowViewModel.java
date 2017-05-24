package com.example.rixspi.sqllitemanipulation.ui.news;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.example.rixspi.sqllitemanipulation.data.model.author.Author;
import com.example.rixspi.sqllitemanipulation.data.model.news.News;
import com.example.rixspi.sqllitemanipulation.ui.base.binding.ObservableString;
import com.example.rixspi.sqllitemanipulation.ui.base.model.BaseViewModel;
import com.example.rixspi.sqllitemanipulation.ui.base.model.RowViewModel;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Ryszard Śpiewak on 13.04.2017.
 */

public class NewsRowViewModel extends BaseViewModel implements RowViewModel {
    public final ObservableString mTitle = new ObservableString();
    public final ObservableString mContent = new ObservableString();
    public final ObservableField<Author> mAuthor = new ObservableField<>();

    protected final News mNews;

    public NewsRowViewModel(@NonNull News mNews) {
        this.mNews = checkNotNull(mNews);

        mTitle.set(mNews.title());
        mAuthor.set(mNews.author());
        mContent.set(mNews.content());
    }
}
