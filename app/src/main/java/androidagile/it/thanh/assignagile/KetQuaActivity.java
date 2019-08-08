package androidagile.it.thanh.assignagile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.util.ArrayList;
import java.util.List;
import androidagile.it.thanh.assignagile.database.DatabaseHelper;
import androidagile.it.thanh.assignagile.model.LuuKetQua;

public class KetQuaActivity extends AppCompatActivity {
    private TextView tvChuatraloi,tvsoCaudung,tvSocausai,tvDiem;
    String TAG = "LoginFaceActivity";
    private ShareDialog shareDialog;
    private CallbackManager manager;
    int dalam;
    int dung;
    int sai;
    int chualam;
    String putdata;
    private DatabaseHelper database;
    List<LuuKetQua> luuKetQuaList;
    String aa = "dâdada";
    double d;
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);
        //
        luuKetQuaList = new ArrayList<>();
        database = new DatabaseHelper(this);

        //
        shareDialog = new ShareDialog(KetQuaActivity.this);
        manager = CallbackManager.Factory.create();
        tvChuatraloi = findViewById(R.id.tvchualam);
        tvSocausai = findViewById(R.id.tvCauSai);
        tvsoCaudung = findViewById(R.id.tvCauDung);
        tvDiem = findViewById(R.id.tvdiem);
        Intent intent = getIntent();
         dalam = Integer.parseInt(intent.getStringExtra("DaLam"));
         dung = Integer.parseInt(intent.getStringExtra("Dung"));
         chualam = 40-dalam;
         sai = 40-dung-chualam;
        tvsoCaudung.setText(dung+" / 40");
        tvSocausai.setText(sai+" / 40");
        tvChuatraloi.setText(chualam+" / 40");
        tvDiem.setText(0.25*dung+ " / 10");
        Intent intent1 = getIntent();
        putdata = intent1.getStringExtra("putdata");

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
        Intent intent = new Intent(KetQuaActivity.this,TracNghiemActivity.class);
        intent.putExtra("putdata",putdata);
        startActivity(intent);
    }

    public void LuuDiem(View view) {
        ShowCustomDialog();
    }

    public void Thoat(View view) {
        Intent intent = new Intent(KetQuaActivity.this,GocHocTapActivity.class);
        startActivity(intent);
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
        //Luuket qua
    public void ShowCustomDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(KetQuaActivity.this);
        builder.setTitle("Lưu kết quả !");
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View viewDialog = inflater.inflate(R.layout.dialog_luuketqua,null);
        builder.setView(viewDialog);
        final EditText edtname = viewDialog.findViewById(R.id.edtname);
        builder.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = edtname.getText().toString();
                String monhoc =putdata;
                String diem = String.valueOf(dung * 0.25);
                cursor = database.getdata();
                if(!name.equals("") ||!monhoc.equals("")||!diem.equals("")){
                    final LuuKetQua kq =new LuuKetQua(name,monhoc,diem);
                    boolean a = false;
                    if (cursor.moveToNext()){
                        cursor.moveToFirst();
                        do {
                            final  LuuKetQua luuKetQua = new LuuKetQua(cursor.getString(1),cursor.getString(2),cursor.getString(3));
                            if (luuKetQua.toString().equals(kq.toString())){
                                    a = true;
                            }
                        }while (cursor.moveToNext());
                    }
                    if(a==false){
                        database.insert(name,monhoc,diem);
                    }
                }

            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }

}
