package com.martinscastanho.marco.snoop;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    Switch spamSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.horn);
        spamSwitch = findViewById(R.id.spamSwitch);
    }

    public void snoop(View view) {
        if(!spamSwitch.isChecked()){
            if(mp.isPlaying()){
                mp.stop();
                try {
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mp.start();
        }
        else{
            MediaPlayer mp2 = MediaPlayer.create(this, R.raw.horn);
            mp2.start();
        }
    }
}
