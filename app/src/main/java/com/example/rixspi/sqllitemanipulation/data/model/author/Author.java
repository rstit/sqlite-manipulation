package com.example.rixspi.sqllitemanipulation.data.model.author;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Ryszard Śpiewak on 12.04.2017.
 */

@AutoValue
public abstract class Author implements Parcelable, Serializable {
    @SerializedName("id")
    public abstract int id();

    @SerializedName("name")
    public abstract String name();

    @SerializedName("surname")
    public abstract String surname();

    @NonNull
    public static Builder builder() {
        return new AutoValue_Author.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder id(int id);

        public abstract Builder name(@Nullable String name);

        public abstract Builder surname(@Nullable String surname);

        public abstract Author build();
    }
}
