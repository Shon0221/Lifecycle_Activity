package com.example.shon.lifecycle_activity;

import android.os.AsyncTask;

/**
 * Created by Shon on 2017/6/20.
 */

public class Task extends AsyncTask<Void, Void, Void> {

    private  OnFinishListener onFinishListener = null;

    public void setOnFinishListener(OnFinishListener onFinishListener) {
        this.onFinishListener = onFinishListener;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (onFinishListener != null)
            onFinishListener.onFinish();
    }

    public interface OnFinishListener {
        void onFinish();
    }
}
