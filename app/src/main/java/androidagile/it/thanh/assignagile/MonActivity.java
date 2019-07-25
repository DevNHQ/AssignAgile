package androidagile.it.thanh.assignagile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MonActivity extends AppCompatActivity {

    private Toolbar toolbarMon;
    private ImageView imgToolBarMon;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon);
        toolbarMon = (Toolbar) findViewById(R.id.toolbar_mon);
        imgToolBarMon = (ImageView) findViewById(R.id.imgToolBarMon);

    }

    public void onTap(View view) {
        Intent intent = new Intent(MonActivity.this, OnTapActivity.class);
        startActivity(intent);
    }

    public void thiThu(View view) {
        Intent intent = new Intent(MonActivity.this, ThiThuActivity.class);
        startActivity(intent);
    }

    public void backToGocHocTap(View view) {
        Intent intent = new Intent(MonActivity.this, GocHocTapActivity.class);
        startActivity(intent);
    }
}
