package com.example.shon.lifecycle_activity.db;

import com.example.shon.lifecycle_activity.db.entity.CommentEntity;
import com.example.shon.lifecycle_activity.db.entity.ProductEntity;
import com.example.shon.lifecycle_activity.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shon on 2017/6/22.
 */

public class DatabaseInitUtil {
    private static final String[] FIRST = new String[]{
            "Special edition", "New", "Cheap", "Quality", "Used"};
    private static final String[] SECOND = new String[]{
            "Three-headed Monkey", "Rubber Chicken", "Pint of Grog", "Monocle"};
    private static final String[] DESCRIPTION = new String[]{
            "is finally here", "is recommended by Stan S. Stanman",
            "is the best sold product on Mêlée Island", "is \uD83D\uDCAF", "is ❤️", "is fine"};
    private static final String[] COMMENTS = new String[]{
            "Comment 1", "Comment 2", "Comment 3", "Comment 4", "Comment 5", "Comment 6",
    };

    static void initializeDb(AppDatabase db) {
        List<ProductEntity> products = new ArrayList<>(FIRST.length * SECOND.length);
        List<CommentEntity> comments = new ArrayList<>();

        generateData(products, comments);

        insertData(db, products, comments);
    }

    private static void generateData(List<ProductEntity> products, List<CommentEntity> comments) {
        Random rnd = new Random();
        for (int i = 0; i < FIRST.length; i++) {
            for (int j = 0; j < SECOND.length; j++) {
                ProductEntity product = new ProductEntity();
                product.setName(FIRST[i] + " " + SECOND[j]);
                product.setDescription(product.getName() + " " + DESCRIPTION[j]);
                product.setPrice(rnd.nextInt(240));
                product.setId(FIRST.length * i + j + 1);
                products.add(product);
            }
        }

        for (Product product : products) {
            int commentsNumber = rnd.nextInt(5) + 1;
            for (int i = 0; i < commentsNumber; i++) {
                CommentEntity comment = new CommentEntity();
                comment.setProductId(product.getId());
                comment.setText(COMMENTS[i] + " for " + product.getName());
                comment.setPostedAt(new Date(System.currentTimeMillis()
                        - TimeUnit.DAYS.toMillis(commentsNumber - i) + TimeUnit.HOURS.toMillis(i)));
                comments.add(comment);
            }
        }
    }

    private static void insertData(AppDatabase db, List<ProductEntity> products, List<CommentEntity> comments) {
        db.beginTransaction();
        try {
            db.productDao().insertAll(products);
            db.commentDao().insertAll(comments);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }
}
