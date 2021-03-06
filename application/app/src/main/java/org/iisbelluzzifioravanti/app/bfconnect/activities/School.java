/**
 * @class School.java
 */
package org.iisbelluzzifioravanti.app.bfconnect.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.vision.text.Text;

import org.iisbelluzzifioravanti.app.bfconnect.BaseActivity;
import org.iisbelluzzifioravanti.app.bfconnect.R;

/**
 * This class is linked to the "activity_school.xml" in "res/layout/activity_school.xml".
 * @extends BaseActivity
 *
 * This is one of the three main pages.
 */
public class School extends BaseActivity {

    private VideoView video;
    private boolean isPlaying = false;

    @Override
    public void activityPage() {
        //for center the image
        ScrollView scr = (ScrollView)findViewById(R.id.scrolling);
        RelativeLayout tecnico = findViewById(R.id.cwcontainerTecnico);
        RelativeLayout professionale = findViewById(R.id.cwcontainerProfessionale);

        TextView subtitleCV1 = findViewById(R.id.subTitleCV1School);
        TextView titleCV1 = findViewById(R.id.titleCV1School);
        TextView titleCV2 = findViewById(R.id.titleCV2School);
        TextView subtitleCV2 = findViewById(R.id.subTitleCV2School);

        Thread giroImmagine = new Thread(new Runnable() {
        @Override
            public void run() {
                do{
                    try {
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tecnico.setBackground(ContextCompat.getDrawable(School.this, R.drawable.mast_banner));
                            }
                        });
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tecnico.setBackground(ContextCompat.getDrawable(School.this, R.drawable.carp_banner));
                            }
                        });
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tecnico.setBackground(ContextCompat.getDrawable(School.this,R.drawable.of_banner));
                            }
                        });
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tecnico.setBackground(ContextCompat.getDrawable(School.this,R.drawable.filo_banner));
                                subtitleCV1.setTextColor(getResources().getColor(R.color.black));
                                titleCV1.setTextColor(getResources().getColor(R.color.black));
                            }
                        });
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tecnico.setBackground(ContextCompat.getDrawable(School.this,R.drawable.texa_banner));
                            }
                        });
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tecnico.setBackground(ContextCompat.getDrawable(School.this, R.drawable.stem_banner));
                                subtitleCV1.setVisibility(View.INVISIBLE);
                                titleCV1.setVisibility(View.INVISIBLE);
                            }
                        });
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tecnico.setBackground(ContextCompat.getDrawable(School.this,R.drawable.desi_banner));
                                subtitleCV1.setVisibility(View.VISIBLE);
                                titleCV1.setVisibility(View.VISIBLE);
                                subtitleCV1.setTextColor(getResources().getColor(R.color.white));
                                titleCV1.setTextColor(getResources().getColor(R.color.white));
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }while(true);
            }

        });
        giroImmagine.start();
        Thread giroImmaginePr = new Thread(new Runnable() {
            @Override
            public void run() {
                do{
                    try {
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                professionale.setBackground(ContextCompat.getDrawable(School.this, R.drawable.of_banner));
                            }
                        });
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                professionale.setBackground(ContextCompat.getDrawable(School.this, R.drawable.magneti_banner));
                                subtitleCV2.setVisibility(View.INVISIBLE);
                                titleCV2.setVisibility(View.INVISIBLE);
                            }
                        });
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                professionale.setBackground(ContextCompat.getDrawable(School.this, R.drawable.texa_banner));
                                subtitleCV2.setVisibility(View.VISIBLE);
                                titleCV2.setVisibility(View.VISIBLE);
                                subtitleCV2.setTextColor(getResources().getColor(R.color.black));
                                titleCV2.setTextColor(getResources().getColor(R.color.black));
                            }
                        });
                        Thread.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                professionale.setBackground(ContextCompat.getDrawable(School.this, R.drawable.toyota_banner));
                                subtitleCV2.setTextColor(getResources().getColor(R.color.white));
                                titleCV2.setTextColor(getResources().getColor(R.color.white));
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }while(true);
            }

        });
        giroImmaginePr.start();
        //scr.setBackgroundResource(R.drawable.school);

        //to set scrolling start
        /*Display display = getWindowManager().getDefaultDisplay();
        Point p = new Point();
        display.getSize(p);
        scr.post(new Runnable() {
            public void run() {
                scr.scrollTo(0,scr.getHeight()/2);
            }
        });
*/
        video = findViewById(R.id.videoView);
        //MediaController media = new MediaController(this);
        video.setVideoPath("android.resource://"+getPackageName()+"/"+ R.raw.school);
        //media.setAnchorView(video);
        //video.setMediaController(media);
        video.start();
        isPlaying = true;

        CardView CVTecnico = findViewById(R.id.cardViewIndirizziTecnico);//this button is inked to Tecnico page.
        CardView CVProfessionale = findViewById(R.id.cardViewIndirizziProfessionale);//this button is inked to Professionale page.
        CardView CVIisBelluzzi = findViewById(R.id.cardViewIisBF);
        CardView CVprogettiTecnico = findViewById(R.id.cardViewProgettiTecnico);
        CardView CVprogettiProfessionale = findViewById(R.id.cardViewProgettiProfessionale);

        CVprogettiProfessionale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(School.this, ProgettiProfessionale.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fadein, R.anim.fadeout);
                startActivity(intent , options.toBundle());
            }
        });

        CVprogettiTecnico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(School.this, ProgettiTecnico.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fadein, R.anim.fadeout);
                startActivity(intent , options.toBundle());
            }
        });

        CVIisBelluzzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPlaying){video.pause();isPlaying=false;}
                else{video.start();isPlaying=true;}
            }
        });

        CVTecnico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(School.this, Tecnico.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fadein, R.anim.fadeout);
                startActivity(intent , options.toBundle());
            }
        });
        CVProfessionale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(School.this, Professionale.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fadein, R.anim.fadeout);
                startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        video.start();
        isPlaying = true;
    }

    @Override
    public int getContentViewId() { return R.layout.activity_school; }

    @Override
    public int getNavigationMenuItemId() { return R.id.school; }
}
