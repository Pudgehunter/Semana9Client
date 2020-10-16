package co.domi.semana9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.google.gson.Gson;

import co.domi.semana9.model.Images;

public class MainActivity extends AppCompatActivity {

    private UDP udp;
    private ImageButton imageOne, imageTwo, imageThree, imageFour;

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
        udp.start();

        //SetOnClickListeners
        //One
        imageOne.setOnClickListener(
                (v) -> {
                    Images chocolates = new Images("Chocolates");
                    Gson gson = new Gson();
                    String json = gson.toJson(chocolates);
                    udp.sendMessage(json);
                }
        );
        //Two
        imageTwo.setOnClickListener(
                (v) -> {
                    Images salpicon = new Images("Salpicon");
                    Gson gson = new Gson();
                    String json = gson.toJson(salpicon);
                    udp.sendMessage(json);
                }
        );
        //Three
        imageThree.setOnClickListener(
                (v) -> {
                    Images helado = new Images("Helado");
                    Gson gson = new Gson();
                    String json = gson.toJson(helado);
                    udp.sendMessage(json);
                }
        );
        //Four
        imageFour.setOnClickListener(
                (v) -> {
                    Images almuerzoWonka = new Images("AlmuerzoWonka");
                    Gson gson = new Gson();
                    String json = gson.toJson(almuerzoWonka);
                    udp.sendMessage(json);
                }
        );

    }
}