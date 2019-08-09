package androidagile.it.thanh.assignagile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class GocHocTapActivity extends AppCompatActivity {

    private LinearLayout linearLayoutDialy;
    private Toolbar toolbarGochotap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goc_hoc_tap);
        linearLayoutDialy = (LinearLayout) findViewById(R.id.linear_layout_dialy);
        toolbarGochotap = (Toolbar) findViewById(R.id.toolbar_gochotap);
        setSupportActionBar(toolbarGochotap);
        toolbarGochotap.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void diaLy(View view) {
        checkNetworkConnection1();
    }

    public void lichsu(View view) {
        checkNetworkConnection2();
    }

    public void gdcd(View view) {
        checkNetworkConnection3();
    }

    public void sinhoc(View view) {
        checkNetworkConnection();
    }
    //
    public boolean checkNetworkConnection()
    {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = false;
        if (networkInfo != null && (isConnected = networkInfo.isConnected())) {
            Connect();
        } else {
            eR();
        }

        return isConnected;
    }
    public void Connect(){
        final ProgressDialog progress = new ProgressDialog(GocHocTapActivity.this);
        progress.setTitle("Loading data...");
        progress.setMessage("please wait !");
        progress.setCancelable(true);
        progress.show();
        Runnable progressRunnable = new Runnable() {
            @Override
            public void run() {
                progress.cancel();
                Intent  intent = new Intent(GocHocTapActivity.this,MonActivity.class);
                intent.putExtra("monthi","SinhHoc");
                intent.putExtra("title","Sinh Học");
                intent.putExtra("link","https://drive.google.com/file/d/0Bzx3-_MRlkBgU3pBTEhMSXVzT0E/view");
                startActivity(intent);
                finish();
            }
        };
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 2000);
    }
    //Dia Ly
    public boolean checkNetworkConnection1()
    {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = false;
        if (networkInfo != null && (isConnected = networkInfo.isConnected())) {
            Connect1();
        } else {
            eR();
        }

        return isConnected;
    }
    public void Connect1(){
        final ProgressDialog progress = new ProgressDialog(GocHocTapActivity.this);
        progress.setTitle("Loading data...");
        progress.setMessage("please wait !");
        progress.setCancelable(true);
        progress.show();
        Runnable progressRunnable = new Runnable() {
            @Override
            public void run() {
                progress.cancel();
                Intent intent = new Intent(GocHocTapActivity.this, MonActivity.class);
                intent.putExtra("monthi","DiaLy");
                intent.putExtra("title","Địa Lý");
                intent.putExtra("link","https://drive.google.com/file/d/1wlMRxr15dU88CShkqx3Juo-njTJwJR4s/view");
                startActivity(intent);
                finish();
            }
        };
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 2000);
    }
    //LichSu
    public boolean checkNetworkConnection2()
    {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = false;
        if (networkInfo != null && (isConnected = networkInfo.isConnected())) {
            Connect2();
        } else {
            eR();
        }

        return isConnected;
    }
    public void Connect2(){
        final ProgressDialog progress = new ProgressDialog(GocHocTapActivity.this);
        progress.setTitle("Loading data...");
        progress.setMessage("please wait !");
        progress.setCancelable(true);
        progress.show();
        Runnable progressRunnable = new Runnable() {
            @Override
            public void run() {
                progress.cancel();
                Intent intent = new Intent(GocHocTapActivity.this, MonActivity.class);
                intent.putExtra("monthi","LichSu");
                intent.putExtra("title","Lịch Sử");
                intent.putExtra("link","https://drive.google.com/file/d/1UHBe81Y-zHT-uNd9MTINN4CkSuy8VtWr/view");
                startActivity(intent);
                finish();
            }
        };
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 2000);
    }
    //DiLy
    public boolean checkNetworkConnection3()
    {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = false;
        if (networkInfo != null && (isConnected = networkInfo.isConnected())) {
            Connect3();
        } else {
            eR();
        }

        return isConnected;
    }
    public void Connect3(){
        final ProgressDialog progress = new ProgressDialog(GocHocTapActivity.this);
        progress.setTitle("Loading data...");
        progress.setMessage("please wait !");
        progress.setCancelable(true);
        progress.show();
        Runnable progressRunnable = new Runnable() {
            @Override
            public void run() {
                progress.cancel();
                Intent intent = new Intent(GocHocTapActivity.this, MonActivity.class);
                intent.putExtra("monthi","GDCD");
                intent.putExtra("title","GDCD");
                intent.putExtra("link","https://drive.google.com/file/d/1v04lxqmnnNeO-zaGjHLaPU4FUD2Z5hDF/view");
                startActivity(intent);
                finish();
            }
        };
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 2000);
    }
    public void eR(){
        final ProgressDialog progress = new ProgressDialog(GocHocTapActivity.this);
        progress.setMessage("check internet connection !");
        progress.setTitle("No internet access...");
        progress.setCancelable(true);
        progress.show();
        Runnable progressRunnable = new Runnable() {
            @Override
            public void run() {
                progress.cancel();
            }
        };
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 3000);
    }
}
