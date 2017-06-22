package com.example.shon.lifecycle_activity.db.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Shon on 2017/6/22.
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
