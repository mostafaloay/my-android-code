package com.example.iraq.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=findViewById(R.id.text);
        final ImageView imageView=findViewById(R.id.imageView);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        movieinterface interfacee=retrofit.create( movieinterface.class);
        Call<MovieModel> call=interfacee.getmovie("tt2283362","6657cdc1");

        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                textView.setText(String.valueOf(response.body().getTitle()));
                Picasso.with(getApplicationContext()).load(response.body().getPoster()).into(imageView);
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"good",Toast.LENGTH_LONG).show();


            }
        });

    }
}
