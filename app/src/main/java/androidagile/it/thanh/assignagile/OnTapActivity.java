package androidagile.it.thanh.assignagile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.ArrayList;

import androidagile.it.thanh.assignagile.adapter.OnTapAdapter;

public class OnTapActivity extends AppCompatActivity {

    private Toolbar toolbarOntap;
    private WebView webView;
    private TextView tv;
    String title;
    String link;
    String monthi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_tap);
        toolbarOntap = (Toolbar) findViewById(R.id.toolbar_ontap);
        tv =  findViewById(R.id.tbontap);
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        link = intent.getStringExtra("link");
        monthi = intent.getStringExtra("monthi");
        webView = findViewById(R.id.webview);
        checkNetworkConnection3();


    }

    public void BackOntap(View view) {
        Intent intent = new Intent(OnTapActivity.this,MonActivity.class);
        intent.putExtra("monthi",monthi);
        intent.putExtra("title",title);
        intent.putExtra("link",link);
        startActivity(intent);
    }
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
        final ProgressDialog progress = new ProgressDialog(OnTapActivity.this);
        progress.setTitle("Loading data...");
        progress.setMessage("please wait !");
        progress.setCancelable(true);
        progress.show();
        Runnable progressRunnable = new Runnable() {
            @Override
            public void run() {
                progress.cancel();
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(link);
                tv.setText("Ôn Tập "+title);
            }
        };
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 5000);
    }
    public void eR(){
        final ProgressDialog progress = new ProgressDialog(OnTapActivity.this);
        progress.setMessage("check internet connection !");
        progress.setTitle("No internet access...");
        progress.setCancelable(true);
        progress.show();
        Runnable progressRunnable = new Runnable() {
            @Override
            public void run() {
                progress.cancel();
                Intent intent = new Intent(OnTapActivity.this,MonActivity.class);
                intent.putExtra("monthi",monthi);
                intent.putExtra("title",title);
                intent.putExtra("link",link);
                startActivity(intent);
                finish();
            }
        };
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 3000);
    }
}
