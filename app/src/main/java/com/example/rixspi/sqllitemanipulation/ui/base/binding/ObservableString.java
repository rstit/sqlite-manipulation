package com.example.rixspi.sqllitemanipulation.ui.base.binding;

import android.databinding.ObservableField;
import android.support.annotation.Nullable;

/**
 * @author Marcin Przepiórkowski
 * @since 21.06.2016
 */
public class ObservableString extends ObservableField<String> {
    public ObservableString() {
        super();
    }

    public ObservableString(@Nullable String text) {
        super(text);
    }
}