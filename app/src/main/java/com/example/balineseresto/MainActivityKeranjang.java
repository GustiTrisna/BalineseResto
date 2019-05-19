package com.example.balineseresto;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityKeranjang extends AppCompatActivity {

    private Button button1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_keranjang);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        button = (Button) findViewById(R.id.print);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


        Intent intent = getIntent();
        int number1 = intent.getIntExtra(MainActivityPesanan.EXTRA_NUMBER1, 0);
        String text = intent.getStringExtra(MainActivityPesanan.EXTRA_TEXT);
        int number2 = intent.getIntExtra(MainActivityPesanan.EXTRA_NUMBER2,0);

        TextView textView1 = (EditText) findViewById(R.id.jumlah_pesanan1);
        TextView textView2 = (EditText) findViewById(R.id.nama_pesanan1);
        TextView textView3 = (EditText) findViewById(R.id.harga_pesanan1);
        TextView textView4 = (EditText) findViewById(R.id.total_pesanan);

        textView1.setText("" + number1);
        textView2.setText(text);
        textView3.setText("Rp." + number2);
        textView4.setText("Rp." + number1 * number2);
    }

    public void openHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openDialog(){
    openDialog openDialog = new openDialog();
    openDialog.show(getSupportFragmentManager(),"");
    }
}