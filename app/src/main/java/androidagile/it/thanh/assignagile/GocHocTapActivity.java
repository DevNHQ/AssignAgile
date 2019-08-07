package androidagile.it.thanh.assignagile;

import android.content.Intent;
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
        Intent intent = new Intent(GocHocTapActivity.this, MonActivity.class);
        intent.putExtra("monthi","DiaLy");
        intent.putExtra("Title","Địa Lý");
        startActivity(intent);
    }

    public void lichsu(View view) {
        Intent intent = new Intent(GocHocTapActivity.this, MonActivity.class);
        intent.putExtra("monthi","LichSu");
        intent.putExtra("Title","Lịch Sử");
        startActivity(intent);
    }

    public void gdcd(View view) {
        Intent intent = new Intent(GocHocTapActivity.this, MonActivity.class);
        intent.putExtra("monthi","GDCD");
        intent.putExtra("Title","Giáo Dục Công Dân");
        startActivity(intent);
    }

    public void sinhoc(View view) {
        Intent intent = new Intent(GocHocTapActivity.this, MonActivity.class);
        intent.putExtra("monthi","DiaLy");
        intent.putExtra("Title","Sinh Học");
        startActivity(intent);
    }
}
