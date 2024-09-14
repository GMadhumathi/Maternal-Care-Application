package com.example.mommygram;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {

    ImageView play,prev,next,imageView;
    TextView songTitle;
    SeekBar mSeekBarTime,mSeekBarVol;
    static MediaPlayer mMediaPlayer;
    private Runnable runnable;
    private AudioManager mAudioManager;
    int currentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        mAudioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        //initializing views
        play=findViewById(R.id.play);
        prev=findViewById(R.id.prev);
        next=findViewById(R.id.next);
        songTitle=findViewById(R.id.songTitle);
        imageView=findViewById(R.id.imageView);
        mSeekBarTime=findViewById(R.id.seekBarTime);
        mSeekBarVol=findViewById(R.id.seekBarVol);

        //creating an ArrayList to store our songs
        ArrayList<Integer> songs=new ArrayList<>();
        songs.add(0, R.raw.kaalaiyil);
        songs.add(1,R.raw.kannalane);
        songs.add(2,R.raw.pookalpookum);
        songs.add(3,R.raw.senyoreeta);
        songs.add(4,R.raw.thandavam);
        songs.add(5,R.raw.urugi);

        //initializing mediaplayer
        mMediaPlayer= MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));

        //seekbar volume
        int maxV=mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV=mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mSeekBarVol.setMax(maxV);
        mSeekBarVol.setProgress(curV);

        mSeekBarVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {


                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //above seekbar volume


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                if(mMediaPlayer!=null && mMediaPlayer.isPlaying()){
                    mMediaPlayer.pause();
                    play.setImageResource(R.drawable.play_btn);
                }
                else {
                    mMediaPlayer.start();
                    play.setImageResource(R.drawable.pause_btn);
                }
                songNames();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mMediaPlayer!=null){
                    play.setImageResource(R.drawable.pause_btn);
                }

                if(currentIndex<songs.size()-1){
                    currentIndex++;
                }
                else{
                    currentIndex=0;

                }

                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }

                mMediaPlayer= MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mMediaPlayer!=null){
                    play.setImageResource(R.drawable.pause_btn);
                }

                if(currentIndex>0){
                    currentIndex--;
                }
                else{
                    currentIndex=songs.size()-1;
                }
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }

                mMediaPlayer= MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });
    }

    //create a separate section for all names and putting it in each view
    private void songNames(){
        if(currentIndex==0){
            songTitle.setText("Kaalaiyil Thinamum");
            imageView.setImageResource(R.drawable.kaalaiyil);
        }
        if(currentIndex==1){
            songTitle.setText("Kannalane");
            imageView.setImageResource(R.drawable.kannalane);
        }
        if(currentIndex==2){
            songTitle.setText("Oru Pathi Kathavu");
            imageView.setImageResource(R.drawable.thandavam);
        }
        if(currentIndex==3){
            songTitle.setText("Pookal Pookum");
            imageView.setImageResource(R.drawable.pookal);
        }
        if(currentIndex==4){
            songTitle.setText("Senyoreeta");
            imageView.setImageResource(R.drawable.senyoreeta);
        }
        if(currentIndex==5){
            songTitle.setText("Urugi Urugi-Joe");
            imageView.setImageResource(R.drawable.urugi);
        }

        //seekbar duration
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                mMediaPlayer.start();
            }
        });

        mSeekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mMediaPlayer.seekTo(progress);
                    mSeekBarTime.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mMediaPlayer!=null){
                    try {
                        if(mMediaPlayer.isPlaying())
                        {
                            Message message = new Message();
                            message.what = mMediaPlayer.getCurrentPosition();
                            handler.sendMessage(message);
                            Thread.sleep(1000);
                        }
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @SuppressLint("Handler Leak")
    Handler handler=new Handler (){
        @Override
        public void handleMessage(Message msg){
            mSeekBarTime.setProgress(msg.what);
        }
    };
}