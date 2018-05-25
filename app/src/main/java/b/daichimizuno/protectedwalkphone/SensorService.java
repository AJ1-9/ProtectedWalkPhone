package b.daichimizuno.protectedwalkphone;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SensorService extends Service {
    public SensorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");


    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId){
//        to do something
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }
}
