package com.example.rixspi.sqllitemanipulation.data.model.db;

import android.os.Parcelable;

import io.requery.Entity;
import io.requery.Key;
import io.requery.Persistable;

/**
 * Created by Ryszard Śpiewak on 12.04.2017.
 */
@Entity
public abstract class AbstractAuthor implements Persistable, Parcelable {
    @Key
    int id;

    String name;

    String surname;

    String nickname;
}
