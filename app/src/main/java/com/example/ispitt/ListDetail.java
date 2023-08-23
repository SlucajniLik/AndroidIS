package com.example.ispitt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;


;import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ListDetail extends AppCompatActivity {

 ImageView imgs;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);


        TextView receiver_msg1 = (TextView) findViewById(R.id.textView1);
        TextView receiver_msg2 = (TextView) findViewById(R.id.textView2);
        TextView receiver_msg3 = (TextView) findViewById(R.id.textView3);
        Intent intent = getIntent();
        //String str = intent.getStringExtra("aa");
        Job jobss = (Job) intent.getSerializableExtra("aa");




       String imagee="https://firebasestorage.googleapis.com/v0/b/library-a1c76.appspot.com/o/uploads%2FEnglish_Football_League_Logo.png?alt=media&token=60dd4941-086b-4eed-b617-6516b075c987";
imgs = findViewById(R.id.img);


Picasso.get().load(imagee).into(imgs);








     /*   StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            URL url =new URL(imagee);
            Bitmap bmp=BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imgs.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


        // imgs = findViewById(R.id.img);
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imagee)
        //imgs.setImageBitmap();

        receiver_msg1.setText(jobss.getName());
        receiver_msg2.setText(jobss.getNumber());
        receiver_msg3.setText(jobss.getType());




    }
}