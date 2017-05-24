package com.example.rixspi.sqllitemanipulation.data.news;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.rixspi.sqllitemanipulation.data.base.EntityConverter;
import com.example.rixspi.sqllitemanipulation.data.model.db.Author;
import com.example.rixspi.sqllitemanipulation.data.model.db.News;

/**
 * Created by Ryszard Śpiewak on 13.04.2017.
 */

public class NewsConverter implements EntityConverter<News, com.example.rixspi.sqllitemanipulation.data.model.news.News> {
    public @Nullable com.example.rixspi.sqllitemanipulation.data.model.author.Author convertBackAuthor(@Nullable Author author) {
        if (author == null) {
            return null;
        }

        return com.example.rixspi.sqllitemanipulation.data.model.author.Author.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();
    }

    @Override
    public @NonNull  com.example.rixspi.sqllitemanipulation.data.model.news.News convert(@NonNull News news) {
        return com.example.rixspi.sqllitemanipulation.data.model.news.News.builder()
                .author(convertBackAuthor(news.getAuthor()))
                .content(news.getContent())
                .title(news.getTitle())
                .id(news.getId())
                .build();
    }

    @Override
    public @NonNull  News convertBack(@NonNull com.example.rixspi.sqllitemanipulation.data.model.news.News news) {
        News ndb = new News();
        ndb.setId(news.id());
        ndb.setAuthor(convertAuthor(news.author()));
        ndb.setContent(news.content());
        ndb.setTitle(news.title());
        return ndb;
    }

    private @Nullable Author convertAuthor(com.example.rixspi.sqllitemanipulation.data.model.author.Author author) {
        if (author == null) {
            return null;
        }

        Author dbAuthor = new Author();
        dbAuthor.setId(author.id());
        dbAuthor.setName(author.name());
        dbAuthor.setSurname(author.surname());
        return dbAuthor;
    }
}
