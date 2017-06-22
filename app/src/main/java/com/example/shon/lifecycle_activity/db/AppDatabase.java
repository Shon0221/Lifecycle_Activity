package com.example.shon.lifecycle_activity.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.shon.lifecycle_activity.db.converter.DateConverter;
import com.example.shon.lifecycle_activity.db.dao.CommentDao;
import com.example.shon.lifecycle_activity.db.dao.ProductDao;
import com.example.shon.lifecycle_activity.db.entity.CommentEntity;
import com.example.shon.lifecycle_activity.db.entity.ProductEntity;

/**
 * Created by Shon on 2017/6/22.
 */

@Database(entities = {ProductEntity.class, CommentEntity.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    static final String DATABASE_NAME = "basic-sample-db";

    public abstract ProductDao productDao();

    public abstract CommentDao commentDao();
}
