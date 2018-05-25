package b.daichimizuno.protectedwalkphone.camera;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by daichimizuno on 2018/04/27.
 */

public class MediaUtils {
    private final static String TAG = MediaUtils.class.getSimpleName();

    private static MediaPlayer mMediaPlayer;
    private static AssetFileDescriptor mAssetFileDescriptor;

    public static void initPlayer(Context context){

        try {
            mAssetFileDescriptor = context.getAssets().openFd("test.m4a");

            if(mAssetFileDescriptor != null){
                initMediaPlayer(mAssetFileDescriptor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initMediaPlayer(AssetFileDescriptor assetFileDescriptor){
        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
                    assetFileDescriptor.getStartOffset(),assetFileDescriptor.getLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startPlayer(){
        if(!mMediaPlayer.isPlaying()){
            try {
                mMediaPlayer.setVolume(100,100);
                mMediaPlayer.prepare();
                mMediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void stopPlayer(){
        if(mMediaPlayer.isPlaying()){
            mMediaPlayer.stop();
        }
    }

    public static void releaesPlayer(){
        if(mMediaPlayer != null){
            mMediaPlayer.release();
        }
    }
}
