package androidagile.it.thanh.assignagile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class KetQuaActivity extends AppCompatActivity {
    private TextView tvChuatraloi,tvsoCaudung,tvSocausai,tvDiem;
    String TAG = "LoginFaceActivity";
    private ShareDialog shareDialog;
    private CallbackManager manager;
    int dalam;
    int dung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);
        shareDialog = new ShareDialog(KetQuaActivity.this);
        manager = CallbackManager.Factory.create();
        tvChuatraloi = findViewById(R.id.tvchualam);
        tvSocausai = findViewById(R.id.tvCauSai);
        tvsoCaudung = findViewById(R.id.tvCauDung);
        tvDiem = findViewById(R.id.tvdiem);
        Intent intent = getIntent();
         dalam = Integer.parseInt(intent.getStringExtra("DaLam"));
         dung = Integer.parseInt(intent.getStringExtra("Dung"));
        tvsoCaudung.setText(dung+" / 20");
        tvSocausai.setText(20 - dalam+" / 20");
        tvChuatraloi.setText(20 - dalam+" / 20");
        tvDiem.setText(0.5*dung+ " / 10");


        manager = CallbackManager.Factory.create();
        shareDialog.registerCallback(manager, new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result) {
                Toast.makeText(KetQuaActivity.this.getApplicationContext(), "Share success!", Toast.LENGTH_SHORT).show();
                Log.e(TAG,"Fb onSuccess");
            }

            @Override
            public void onCancel() {
                Toast.makeText(KetQuaActivity.this.getApplicationContext(), "Did not share", Toast.LENGTH_SHORT).show();
                Log.e(TAG,"Fb onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(KetQuaActivity.this.getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                Log.e(TAG,"Fb onError");
            }
        }, 90);
    }

    public void backToThiThu(View view) {
        Intent intent = new Intent(KetQuaActivity.this, ThiThuActivity.class);
        startActivity(intent);
    }

    public void LamLai(View view) {
    }

    public void LuuDiem(View view) {
    }

    public void Thoat(View view) {
    }
    public void Share(View view) {
        checkInternet();
    }
    private boolean checkInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager)KetQuaActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo ==null){
            final ProgressDialog progress = new ProgressDialog(KetQuaActivity.this);
            progress.setMessage("Không có kết nối mạng...");
            progress.setCancelable(true);
            progress.show();
            return false;
        }
        if(!networkInfo.isConnected()){
            final ProgressDialog progress = new ProgressDialog(KetQuaActivity.this);
            progress.setMessage("Không có kết nối mạng...");
            progress.setCancelable(true);
            progress.show();
            return false;
        }
        if(!networkInfo.isAvailable()){
            final ProgressDialog progress = new ProgressDialog(KetQuaActivity.this);
            progress.setMessage("Không có kết nối mạng...");
            progress.setCancelable(true);
            progress.show();
            return false;
        }
        else{
            ShareLinkContent content = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse("https://drive.google.com/drive/u/0/folders/1dT4JgX0Zik4KF3PpoPKPCtcqnrYQLHa0"))
                    .setQuote("Ôn Tập THPT "+" - "+" "+
                            "Thành tích : "+dung +" điểm")
                    .build();
            shareDialog.show(content);
            return true;}
    }

}
