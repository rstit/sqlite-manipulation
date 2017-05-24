package com.example.rixspi.sqllitemanipulation.data.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Observable;

/**
 * @author Marcin Przepiórkowski
 * @since 23.11.2016
 */
public interface Repository<T, S extends Repository.Specification> {
    /**
     * Marker interface for query specification.
     */
    interface Specification {
    }

    /**
     * Fetches all instances and saves them in a local cache if necessary. The first source to be
     * checked for presence of items is local cache, then other sources like for instance local
     * database or web api.
     *
     * @param specification     query specification
     * @return                  an observable that contains fetched items
     */
    @NonNull Observable<T> fetch(@Nullable S specification);
}