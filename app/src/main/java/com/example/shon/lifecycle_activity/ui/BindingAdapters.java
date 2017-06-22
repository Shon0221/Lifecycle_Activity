package com.example.shon.lifecycle_activity.ui;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by Shon on 2017/6/22.
 */

public class BindingAdapters {

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
