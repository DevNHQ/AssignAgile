package androidagile.it.thanh.assignagile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gocHocTap(View view) {
        Intent intent = new Intent(MainActivity.this, GocHocTapActivity.class);
        startActivity(intent);
    }

    public void LichSuLamBai(View view) {
        Intent intent1 = new Intent(MainActivity.this,LichSuOnTapActivity.class);
        startActivity(intent1);
    }
}
