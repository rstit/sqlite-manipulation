package com.example.rixspi.sqllitemanipulation.data.model.db;

import io.requery.Entity;
import io.requery.ForeignKey;
import io.requery.Key;
import io.requery.OneToOne;
import io.requery.Persistable;

/**
 * Created by Ryszard Śpiewak on 12.04.2017.
 */
@Entity
public abstract class AbstractNews implements Persistable {
    @Key
    int id;

    String title;

    String content;

    @ForeignKey @OneToOne
    Author author;
}
