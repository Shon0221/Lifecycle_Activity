package com.example.shon.lifecycle_activity.model;

import java.util.Date;

/**
 * Created by Shon on 2017/6/22.
 */

public interface Comment {
    int getId();
    int getProductId();
    String getText();
    Date getPostedAt();
}
