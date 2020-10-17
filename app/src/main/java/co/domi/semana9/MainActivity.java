package co.domi.semana9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.domi.semana9.events.OnMessageListener;
import co.domi.semana9.model.Images;

public class MainActivity extends AppCompatActivity implements OnMessageListener {

    private UDP udp;
    private ImageButton imageOne, imageTwo, imageThree, imageFour;
    private String fecha;
    private String hola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageOne = findViewById(R.id.imageOne);
        imageTwo = findViewById(R.id.imageTwo);
        imageThree = findViewById(R.id.imageThree);
        imageFour = findViewById(R.id.imageFour);

        //UDP Starts
        udp = new UDP();
        udp.setObserver(this);
        udp.start();

        //Tiempo
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm:ss");
        sdf.format(date);
        fecha = sdf.format(date);
        System.out.println(fecha);

        //SetOnClickListeners
        //One
        imageOne.setOnClickListener(
                (v) -> {
                    String choco = "Chocolates";
                    Images chocolates = new Images(choco,50,50,fecha);
                    Gson gson = new Gson();
                    String json = gson.toJson(chocolates);
                    udp.sendMessage(json);
                }
        );
        //Two
        imageTwo.setOnClickListener(
                (v) -> {
                    String salpi = "Salpicon";
                    Images salpicon = new Images(salpi,50,50,fecha);
                    Gson gson = new Gson();
                    String json = gson.toJson(salpicon);
                    udp.sendMessage(json);
                }
        );
        //Three
        imageThree.setOnClickListener(
                (v) -> {
                    String hel = "Helado";
                    Images helado = new Images(hel,50,50,fecha);
                    Gson gson = new Gson();
                    String json = gson.toJson(helado);
                    udp.sendMessage(json);
                }
        );
        //Four
        imageFour.setOnClickListener(
                (v) -> {
                    String wonka = "AlmuerzoWonka";
                    Images almuerzoWonka = new Images(wonka,50,50,fecha);
                    Gson gson = new Gson();
                    String json = gson.toJson(almuerzoWonka);
                    udp.sendMessage(json);
                }
        );
        if(hola != null) {
            if (hola.equals("terminado")) {
                Toast.makeText(this, "Tu orden esta terminado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onImagesReceive(String string) {
        this.hola = string;
    }
}