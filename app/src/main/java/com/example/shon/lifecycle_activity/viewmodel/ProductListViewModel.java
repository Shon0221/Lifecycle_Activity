package com.example.shon.lifecycle_activity.viewmodel;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

import com.example.shon.lifecycle_activity.db.DatabaseCreator;
import com.example.shon.lifecycle_activity.db.entity.ProductEntity;

import java.util.List;

/**
 * Created by Shon on 2017/6/22.
 */

public class ProductListViewModel extends AndroidViewModel {

    private static final MutableLiveData ABSENT = new MutableLiveData();

    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }

    private final LiveData<List<ProductEntity>> mObservableProducts;

    public ProductListViewModel(Application application) {
        super(application);

        final DatabaseCreator databaseCreator = DatabaseCreator.getInstance(this.getApplication());

        LiveData<Boolean> databaseCreated = databaseCreator.isDatabaseCreated();
        mObservableProducts = Transformations.switchMap(databaseCreated,
                new Function<Boolean, LiveData<List<ProductEntity>>>() {
                    @Override
                    public LiveData<List<ProductEntity>> apply(Boolean isDbCreated) {
                        if (!Boolean.TRUE.equals(isDbCreated)) { // Not needed here, but watch out for null
                            //noinspection unchecked
                            return ABSENT;
                        } else {
                            //noinspection ConstantConditions
                            return databaseCreator.getDatabase().productDao().loadAllProducts();
                        }
                    }
                });

        databaseCreator.createDb(this.getApplication());
    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<ProductEntity>> getProducts() {
        return mObservableProducts;
    }
}