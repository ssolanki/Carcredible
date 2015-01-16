package com.sahil.carcredible;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Sahil on 1/9/2015.
 */
public class Splash extends Activity {
    MediaPlayer oursong;
    @Override
    protected void onCreate(Bundle solankiLove) {
        super.onCreate(solankiLove);
        setContentView(R.layout.activity_splash);
        /*
            Background Music or starting music
         */
//        oursong = MediaPlayer.create(Splash.this, R.raw.jamesbond) ;
  //      oursong.start();

        /*  ends here */
    /*
        To start other Activities
        */
        Thread timer = new Thread(){
          public void run(){
              try{
                sleep(5000);
              }
              catch (InterruptedException e){
                e.printStackTrace();    // print whatever error is occured in console
              }finally{     // after trying everything do this job
                  Intent openMainscreen = new Intent("com.sahil.carcredible.MAINACTIVITY") ;
                    startActivity(openMainscreen);
              }
          }
        };
        timer.start();
    /*  End here */
    }
/* Preventing the app to show this screen due to back button  */
    @Override
    protected void onPause() {
        super.onPause();
//        oursong.release();
        finish();
    }
}
