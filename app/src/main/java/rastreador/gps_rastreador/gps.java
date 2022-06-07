package rastreador.gps_rastreador;


import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class gps extends Service {

    FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;
    Handler handler = new Handler();
    int i = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(
                new Runnable() {
                    @Override
                    public void run()
                    {
                        while (true)
                        {
                            envia_posicao_gps();
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();
        final String ID_CANAL = "GPS Operando em Foreground";
        NotificationChannel canal = new NotificationChannel(ID_CANAL,ID_CANAL, NotificationManager.IMPORTANCE_LOW );
        getSystemService(NotificationManager.class).createNotificationChannel(canal);

        Notification.Builder notificacao = new Notification.Builder(this, ID_CANAL);
        notificacao.setContentText("GPS Enviando Coordenadas");
        notificacao.setContentTitle("GPS Funcionando");
        notificacao.setSmallIcon(R.drawable.ic_launcher_foreground);

        startForeground(999, notificacao.build());
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    void envia_posicao_gps() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    System.out.println(" Latitude: " + String.valueOf(location.getLatitude()));
                    System.out.println(" Longitude: " + String.valueOf(location.getLongitude()));
                    System.out.println(" Extras: " + String.valueOf(location.getExtras()));

                    DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date(location.getTime());
                    String tempo_formatado = format.format(date);
                    System.out.println("Tempo: " + tempo_formatado);
                }
            }
        });
    }
   /* private Runnable loop_posicao = new Runnable() {
        @Override
        public void run() {
            envia_posicao_gps();
            handler.postDelayed(this,5000);
        }
    };
  */
}
