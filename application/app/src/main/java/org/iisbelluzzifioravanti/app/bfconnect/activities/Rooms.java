package org.iisbelluzzifioravanti.app.bfconnect.activities;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import org.iisbelluzzifioravanti.app.bfconnect.R;
import org.iisbelluzzifioravanti.app.bfconnect.activities.threeDots.aboutus.AboutUs;
import org.iisbelluzzifioravanti.app.bfconnect.activities.threeDots.helpactivity.HNFCuno;
import org.iisbelluzzifioravanti.app.bfconnect.database.DbBaseColumns;
import org.iisbelluzzifioravanti.app.bfconnect.database.DbTools;

public class Rooms extends AppCompatActivity {
    public static TextView content, title;
    public static ImageView[] images;
    private static CardView[] cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_rooms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        title =findViewById(R.id.titleRoom);
        content = (TextView)findViewById(R.id.content);
        cards = new CardView[6];
        images = new ImageView[6];

        images[0] = (ImageView) findViewById(R.id.imageOne);
        images[0].setDrawingCacheEnabled(true);
        images[1] = (ImageView) findViewById(R.id.imageTwo);
        images[1].setDrawingCacheEnabled(true);
        images[2] = (ImageView) findViewById(R.id.imageThree);
        images[2].setDrawingCacheEnabled(true);
        images[3] = (ImageView) findViewById(R.id.imageFour);
        images[3].setDrawingCacheEnabled(true);
        images[4] = (ImageView) findViewById(R.id.imageFive);
        images[4].setDrawingCacheEnabled(true);
        images[5] = (ImageView) findViewById(R.id.imageSix);
        images[5].setDrawingCacheEnabled(true);
        cards[0] = findViewById(R.id.cvp1);
        cards[1] = findViewById(R.id.cvp2);
        cards[2] = findViewById(R.id.cvp3);
        cards[3] = findViewById(R.id.cvp4);
        cards[4] = findViewById(R.id.cvp5);
        cards[5] = findViewById(R.id.cvp6);

        try {
            Bundle datapassed = getIntent().getExtras();
            DbTools dbHandler = new DbTools(getApplicationContext());
            Cursor cursor = dbHandler.getCursorLineById(datapassed.getString("id"));

            if(!cursor.move(1)) return;

            byte[][] byteArray= new byte[6][];
            //getting the content of the room
            String title = cursor.getString(cursor.getColumnIndexOrThrow(DbBaseColumns.KEY_TITLE));
            String content = cursor.getString(cursor.getColumnIndexOrThrow(DbBaseColumns.KEY_CONTENT));
            byteArray[0] = cursor.getBlob(cursor.getColumnIndexOrThrow(DbBaseColumns.KEY_IMAGE));
            byteArray[1] = cursor.getBlob(cursor.getColumnIndexOrThrow(DbBaseColumns.KEY_IMAGE2));
            byteArray[2]= cursor.getBlob(cursor.getColumnIndexOrThrow(DbBaseColumns.KEY_IMAGE3));
            byteArray[3] = cursor.getBlob(cursor.getColumnIndexOrThrow(DbBaseColumns.KEY_IMAGE4));
            byteArray[4] = cursor.getBlob(cursor.getColumnIndexOrThrow(DbBaseColumns.KEY_IMAGE5));
            byteArray[5] = cursor.getBlob(cursor.getColumnIndexOrThrow(DbBaseColumns.KEY_IMAGE6));
            this.content.setText(content);
            this.title.setText(title.toUpperCase());

            for (int i=0 ;i<images.length;i++) {
                try{
                    Bitmap bmp = BitmapFactory.decodeByteArray(byteArray[i], 0, byteArray[i].length);
                    images[i].setImageBitmap(bmp);
                }catch (Exception ex){
                    Log.d("immagine nulla","immagine nulla");
                    images[i].setVisibility(View.INVISIBLE);
                    images[i].setImageResource(0);
                    cards[i].setVisibility(View.INVISIBLE);
                }

            }
        }catch(Exception ex){
            Log.e("ERROR",ex.getMessage());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.three_dots,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about_us:
                startActivity(new Intent(this, AboutUs.class));
                return true;
            case R.id.help:
                startActivity(new Intent(this, HNFCuno.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startActivity(new Intent(this, Home.class));
    }
}