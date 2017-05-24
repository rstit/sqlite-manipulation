package com.example.rixspi.sqllitemanipulation.data.base;

import android.support.annotation.NonNull;

/**
 * @author Marcin Przepiórkowski
 * @since 12.12.2016
 */
public interface EntityConverter<T, U> {
    @NonNull U convert(@NonNull T t);

    @NonNull T convertBack(@NonNull U u);
}