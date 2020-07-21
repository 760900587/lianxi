package com.example.di10;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.example.di10.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by 刘洪良 on 2020/4/14.
 */

public class ImageLage extends AsyncTask<String,Integer,Bitmap> {
    private ImageView lv;

    public ImageLage(ImageView lv) {
        this.lv = lv;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            InputStream stream = new URL(strings[0]).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap!=null){
            lv.setImageBitmap(bitmap);
        }else{
            lv.setImageResource(R.drawable.a5);
        }
    }
}
