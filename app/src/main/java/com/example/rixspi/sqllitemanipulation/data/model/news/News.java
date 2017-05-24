package com.example.rixspi.sqllitemanipulation.data.model.news;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.rixspi.sqllitemanipulation.data.model.author.Author;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Ryszard Śpiewak on 12.04.2017.
 */

@AutoValue
public abstract class News implements Parcelable, Serializable {
    @SerializedName("id")
    public abstract int id();

    @SerializedName("title")
    public abstract String title();

    @SerializedName("contet")
    public abstract String content();

    @SerializedName("author")
    public abstract Author author();

    @NonNull
    public static Builder builder() {
        return new AutoValue_News.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract News.Builder id(int id);

        public abstract News.Builder title(@Nullable String title);

        public abstract News.Builder content(@Nullable String content);

        public abstract News.Builder author(@Nullable Author author);

        public abstract News build();
    }
}
