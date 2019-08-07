package androidagile.it.thanh.assignagile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MonActivity extends AppCompatActivity {
    private Toolbar toolbarMon;
    private ImageView imgToolBarMon;
    String monthi;
    String title;
    private TextView txtb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon);
        toolbarMon = (Toolbar) findViewById(R.id.toolbar_mon);
        imgToolBarMon = (ImageView) findViewById(R.id.imgToolBarMon);
        txtb = findViewById(R.id.tvToolbar);
        Intent intent = getIntent();
        monthi = intent.getStringExtra("monthi");
        title = intent.getStringExtra("Title");
        txtb.setText(title);

    }

    public void onTap(View view) {
        Intent intent = new Intent(MonActivity.this, OnTapActivity.class);
        startActivity(intent);
    }

    public void thiThu(View view) {
        Intent intent = new Intent(MonActivity.this, ThiThuActivity.class);
        intent.putExtra("m",monthi);
        intent.putExtra("tt",title);
        startActivity(intent);
    }

    public void backToGocHocTap(View view) {
        Intent intent = new Intent(MonActivity.this, GocHocTapActivity.class);
        startActivity(intent);
    }
}
