package com.example.example;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.icu.text.DateTimePatternGenerator;
import android.net.Uri;
import android.view.View;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ViewToImageView {
    private Context context;
    private String uriFileName;
    private View view;
    private File file;

    public ViewToImageView(Context context,View view, String uriFileName) {
        this.context = context;
        this.view = view;
        this.uriFileName = uriFileName;

    }

    public Uri getImageuri() {
        Bitmap bitmap = getBitmapFromView(view);
        try {
            file = new File(context.getExternalCacheDir(),"myfirstimageview.png");
            FileOutputStream fout = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fout);
            fout.flush();
            fout.close();
            file.setReadable(true,false);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Uri.fromFile(file) ;
    }

    @SuppressLint("ResourceAsColor")
    private Bitmap getBitmapFromView(View view){
        Bitmap rbotmap = Bitmap.createBitmap(view.getWidth(),view.getHeight(),Bitmap.Config.ARGB_8888);

        Canvas rcanvas = new Canvas(rbotmap);
        Drawable bg = view.getBackground();
        if (bg != null){
            bg.draw(rcanvas);
        }else {
            rcanvas.drawColor(android.R.color.white);
        }
        view.draw(rcanvas);
        return rbotmap;
    }
}
