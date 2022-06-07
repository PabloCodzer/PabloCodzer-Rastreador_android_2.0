package rastreador.gps_rastreador;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class gps_usuario extends AppCompatActivity {


   FusedLocationProviderClient fusedLocationProviderClient;
   private LocationCallback locationCallback;
   Handler handler = new Handler();
   int i =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_gps_usuario);

       // loop_posicao.run();
        Intent gps_background = new Intent(this,gps.class);
       // startService(gps_background);
       startForegroundService(gps_background);
    }
/*

    void envia_posicao_gps(){
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        if (ContextCompat.checkSelfPermission(gps_usuario.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }

        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(gps_usuario.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if( location != null )
                {
                        System.out.println(" Latitude: " + String.valueOf(location.getLatitude()));
                        System.out.println(" Longitude: " + String.valueOf(location.getLongitude()));
                        System.out.println(" Extras: " + String.valueOf(location.getExtras()));

                        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = new Date(location.getTime());
                        String formatted = format.format(date);
                        System.out.println("Tempo: " + formatted);
                }
            }
        });
    }

    private Runnable loop_posicao = new Runnable() {
        @Override
        public void run() {
            envia_posicao_gps();
            handler.postDelayed(this,5000);
        }
    };

 */
}