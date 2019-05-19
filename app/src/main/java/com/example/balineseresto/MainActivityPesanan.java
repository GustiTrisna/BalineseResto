package com.example.balineseresto;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class MainActivityPesanan extends AppCompatActivity {
    private Button button;
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";
    public static final String EXTRA_NUMBER1 = "com.example.application.example.EXTRA_NUMBER1";
    public static final String EXTRA_NUMBER2 = "com.example.application.example.EXTRA_NUMBER2";


    TextView txtJumlah;
    int minteger = 0;
    private static final String TAG = "MainActivityPesanan";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pesanan);

        button = (Button) findViewById(R.id.order_pesanan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivityKeranjang();
            }
        });

        txtJumlah = (TextView) findViewById(R.id.counter_pesanan);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    public void openMainActivityKeranjang(){

        TextView editText1 = (EditText) findViewById(R.id.counter_pesanan);
        int number1 = Integer.parseInt(editText1.getText().toString());

        TextView editText2 = (EditText) findViewById(R.id.nama_pesanan);
        String text = editText2.getText().toString();

        TextView editText3 = (EditText) findViewById(R.id.harga_pesanan);
        int number2 = Integer.parseInt(editText3.getText().toString());


        Intent intent = new Intent(this, MainActivityKeranjang.class);
        intent.putExtra(EXTRA_NUMBER1, number1); //kalau ini dihilangkan, layout jumlah dan harga terisikan harga
        intent.putExtra(EXTRA_TEXT, text);
        intent.putExtra(EXTRA_NUMBER2, number2);

        startActivity(intent);
    }

    public void kurang(View view){
        minteger = minteger-1;
        txtJumlah.setText(""+minteger);
    }
    public void tambah(View view){
        minteger = minteger+1;
        txtJumlah.setText(""+minteger);
    }


    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking.");
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("harga")) {
            Log.d(TAG, "getIncomingIntent: found intent.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String harga = getIntent().getStringExtra("harga");

            setImage(imageUrl,imageName, harga);
        }
    }

    private void setImage(String imageUrl, String imageName, String harga){
        EditText Nama = findViewById(R.id.nama_pesanan);
        Nama.setText(imageName);

        EditText Harga = findViewById(R.id.harga_pesanan);
        Harga.setText(harga);

        ImageView image = findViewById(R.id.image_pesanan);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
