package com.example.rixspi.sqllitemanipulation.ui.base.binding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author Marcin Przepiórkowski
 * @since 03.08.2016
 */
public interface Converter<U, V> {
    @NonNull V convert(@Nullable U input);
}