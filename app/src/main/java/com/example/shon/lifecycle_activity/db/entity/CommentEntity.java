package com.example.shon.lifecycle_activity.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.example.shon.lifecycle_activity.model.Comment;

import java.util.Date;
/**
 * Created by Shon on 2017/6/22.
 */

@Entity(tableName = "comments", foreignKeys = {
        @ForeignKey(entity = ProductEntity.class,
                parentColumns = "id",
                childColumns = "productId",
                onDelete = ForeignKey.CASCADE)}, indices = {
        @Index(value = "productId")
})
public class CommentEntity implements Comment {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int productId;
    private String text;
    private Date postedAt;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public CommentEntity() {
    }

    public CommentEntity(Comment comment) {
        id = comment.getId();
        productId = comment.getProductId();
        text = comment.getText();
        postedAt = comment.getPostedAt();
    }
}
