package androidagile.it.thanh.assignagile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import androidagile.it.thanh.assignagile.adapter.ThiThuAdapter;

public class ThiThuActivity extends AppCompatActivity {

    ThiThuAdapter thiThuAdapter;
    ArrayList<String> thithuLists;

    private Toolbar toolbarThiThu;
    private RecyclerView recyvleviewThithu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_thu);

        toolbarThiThu = (Toolbar) findViewById(R.id.toolbar_thithu);
        recyvleviewThithu = (RecyclerView) findViewById(R.id.recyvleview_thithu);
        getListThiThu();

    }

    public void getListThiThu() {
        thithuLists = new ArrayList<>();
        thithuLists.add("Đề 1");
        thithuLists.add("Đề 2");
        thithuLists.add("Đề 3");
        thiThuAdapter = new ThiThuAdapter(ThiThuActivity.this, thithuLists);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyvleviewThithu.setLayoutManager(manager);
        recyvleviewThithu.setAdapter(thiThuAdapter);

    }

    public void backToMon(View view) {
        Intent intent = new Intent(ThiThuActivity.this, MonActivity.class);
        startActivity(intent);
    }
}
