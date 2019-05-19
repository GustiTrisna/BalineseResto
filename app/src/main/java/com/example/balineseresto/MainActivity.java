package com.example.balineseresto;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;

    private static final String TAG = "MainActivity";

    private String title = "Menu Makanan";
    final String STATE_TITLE = "state_string";
    final String STATE_MODE = "state_mode";
    int mode;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mHarga = new ArrayList<>();
    private ArrayList<String> mNames2 = new ArrayList<>();
    private ArrayList<String> mImageUrls2 = new ArrayList<>();
    private ArrayList<String> mHarga2 = new ArrayList<>();
    private ArrayList<String> mNames3 = new ArrayList<>();
    private ArrayList<String> mImageUrls3 = new ArrayList<>();
    private ArrayList<String> mHarga3 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityKeranjang();
            }
        });

        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
        initImageBitmaps2();
        initImageBitmaps3();
    }
    public void openActivityKeranjang(){
        Intent intent = new Intent(this, MainActivityKeranjang.class);
        startActivity(intent);
    }

    private void initImageBitmaps() {
        mImageUrls.add("https://2.bp.blogspot.com/-pgVMm4TFOYM/XOFeBo6i-9I/AAAAAAAAASQ/1TSw8QkCrtIwsX-JF8ce9mOwW7C67QOVwCEwYBhgL/s320/Babi%2BGuling.jpg");
        mNames.add("Nasi Babi Guling");
        mHarga.add("15000");
        mImageUrls.add("https://1.bp.blogspot.com/-gmm_bkh3Uf4/XOFeBvlLH_I/AAAAAAAAASM/2LYziFfOjC40nHX91P1HTVP0uQiB2vYpACEwYBhgL/s320/Siobak.png");
        mNames.add("Siobak");
        mHarga.add("15000");
        mImageUrls.add("https://2.bp.blogspot.com/-YQTjqKbLU-I/XOFes4odQUI/AAAAAAAAASk/OjPa7SB_6n0N0ocgFJm8dZDALc91-6e8wCEwYBhgL/s320/Nasi%2BLawar.jpg");
        mNames.add("Nasi Lawar");
        mHarga.add("15000");
        mImageUrls.add("https://3.bp.blogspot.com/-S-kbYGA_T_I/XOFg4SSn34I/AAAAAAAAATs/m1zi9LsR-9UUlqP8bl55fxMEpa5EkxRswCLcBGAs/s1600/Sate%2BBabi.jpg");
        mNames.add("Sate Babi");
        mHarga.add("10000");
        mImageUrls.add("https://2.bp.blogspot.com/-N4j2YgGQIPk/XOFeszzQF3I/AAAAAAAAASg/1D-QiUsBLXwQx6eEv2cPw6B-GCkAlBZPACEwYBhgL/s1600/Nasi%2BBetutu.jpg");
        mNames.add("Nasi Betutu");
        mHarga.add("20000");

        initRecycleView();
    }

    private void initImageBitmaps2(){
        mImageUrls2.add("https://1.bp.blogspot.com/-fJeKAP-Dp9k/XOFg26ZuV-I/AAAAAAAAATQ/aVp4JdsoLZo8wvYJIsXK9EM63_Mnn_9nQCLcBGAs/s1600/Es%2BTeh.jpg");
        mNames2.add("Es Teh");
        mHarga2.add("3000");
        mImageUrls2.add("https://2.bp.blogspot.com/-qJmMOv5lSc4/XOFg2cj6BvI/AAAAAAAAATI/3fNrpOgs6c8w36ux5IWCx4QXS-FgzXy3wCLcBGAs/s1600/Es%2BJeruk.jpg");
        mNames2.add("Es Jeruk");
        mHarga2.add("4000");
        mImageUrls2.add("https://1.bp.blogspot.com/-EWjRCeYPvLg/XOFg2Xges7I/AAAAAAAAATM/clZ4DgoAiCorB0i03WPz-b9lQjVeLoCbwCLcBGAs/s1600/Es%2BKelapa%2BMuda.jpg");
        mNames2.add("Es Kelapa Muda");
        mHarga2.add("5000");
        mImageUrls2.add("https://3.bp.blogspot.com/-Cc_ft56CRW8/XOFg1g8Lg3I/AAAAAAAAAS4/47jkx1VMwcQKqOuWFGnKRK2mzecIu3gPwCLcBGAs/s1600/Es%2BCampur.jpg");
        mNames2.add("Es Campur");
        mHarga2.add("5000");
        mImageUrls2.add("https://3.bp.blogspot.com/-MN0arcbtqTY/XOFg2BW0otI/AAAAAAAAATE/YJMAVBH36jkc-dQ-hRRoPb2-F8F7LzcDQCLcBGAs/s1600/Es%2BDaluman.jpg");
        mNames2.add("Es Daluman");
        mHarga2.add("4000");

        showRecyclerMinuman();
    }

    private void initImageBitmaps3(){
        mImageUrls3.add("https://4.bp.blogspot.com/-5uoPAt_sIHw/XOFg4E9kNgI/AAAAAAAAATo/nkopMkchj_APWUyaE05GCilvapfHng9xgCLcBGAs/s1600/Pisang%2BRai.jpg");
        mNames3.add("Pisang Rai");
        mHarga3.add("8000");
        mImageUrls3.add("https://1.bp.blogspot.com/-dIWBrnUtfT4/XOFg3MiuBeI/AAAAAAAAATY/uFNbUrmzzfk3gyzD9f63C3BLchsj-AH7gCLcBGAs/s1600/Klepon.jpg");
        mNames3.add("Klepon");
        mHarga3.add("5000");
        mImageUrls3.add("https://3.bp.blogspot.com/-014Hh7dLRYc/XOFg3AkB5LI/AAAAAAAAATU/IsBoLrnaYG87yY2UbfbrCt7qFgQ1ff0TgCLcBGAs/s1600/Jaje%2BLukis.jpg");
        mNames3.add("Jaje Lukis");
        mHarga3.add("5000");
        mImageUrls3.add("https://4.bp.blogspot.com/-gX2LI6FEUCE/XOFg1qvFkBI/AAAAAAAAATA/y9MG-FJ9-vMaSMdKa62ShU3Q0vqLepXQwCLcBGAs/s1600/Bubuh%2BSumsum.jpg");
        mNames3.add("Bubuh Sumsum");
        mHarga3.add("5000");
        mImageUrls3.add("https://3.bp.blogspot.com/-s1Y0btro9RQ/XOFg3sbpbPI/AAAAAAAAATc/nM3nySIBDdUmOZTUCryiFNhJ5w8Rnbg6gCLcBGAs/s1600/Laklak.jpg");
        mNames3.add("Laklak");
        mHarga3.add("8000");

        showRecyclerJajan();
    }

    private void initRecycleView() {
        Log.d(TAG, "initRecycleView: init recycleview.");

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mHarga);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void showRecyclerMinuman() {
        Log.d(TAG, "initRecycleView: init recycleview.");

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames2, mImageUrls2, mHarga2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void showRecyclerJajan() {
        Log.d(TAG, "initRecycleView: init recycleview.");

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames3, mImageUrls3, mHarga3);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_makanan:
                title = "Menu Makanan";
                initRecycleView();
                break;

            case R.id.action_minuman:
                title = "Menu Minuman";
                showRecyclerMinuman();
                break;

            case R.id.action_jajan:
                title = "Menu Jajan";
                showRecyclerJajan();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putInt(STATE_MODE, mode);
    }
}
