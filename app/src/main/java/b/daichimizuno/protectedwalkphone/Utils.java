package b.daichimizuno.protectedwalkphone;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils {
    private final static String TAG = Utils.class.getSimpleName();

    public static void saveFile(Context context, String fileName,List<String> str){
        Log.d(TAG,"#saveFile :" + fileName + ": str: " +str);
        FileOutputStream fileOutputStream = null;

        try{
            fileOutputStream=context.openFileOutput(fileName, Context.MODE_PRIVATE);
            for(int i=0;i<str.size();i++){
                fileOutputStream.write(str.get(i).getBytes());
                fileOutputStream.write(13);
                fileOutputStream.write(10);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String getNowDate(){
        final DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        final Date date = new Date(System.currentTimeMillis());
        return df.format(date);
    }
}
