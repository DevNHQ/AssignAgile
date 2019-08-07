package androidagile.it.thanh.assignagile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartThiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_thi);
    }

    public void backToThiThu(View view) {
        Intent intent = new Intent(StartThiActivity.this, ThiThuActivity.class);
        startActivity(intent);
    }

    public void resultThiTracNghiem(View view) {
        Intent intent = new Intent(StartThiActivity.this, TracNghiemActivity.class);
        startActivity(intent);
    }
}
