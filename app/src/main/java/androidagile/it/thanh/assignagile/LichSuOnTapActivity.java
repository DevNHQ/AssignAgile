package androidagile.it.thanh.assignagile;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidagile.it.thanh.assignagile.adapter.LuuKetQuaAdapter;
import androidagile.it.thanh.assignagile.database.DatabaseHelper;
import androidagile.it.thanh.assignagile.model.LuuKetQua;

public class LichSuOnTapActivity extends AppCompatActivity {
    private List<LuuKetQua> luuKetQuaList;
    private ListView lv;
    private DatabaseHelper database;
    private Cursor cursor;
    private LuuKetQuaAdapter luuKetQuaAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_on_tap);
        luuKetQuaList = new ArrayList<>();
        database = new DatabaseHelper(this);
        lv = findViewById(R.id.lvketqua);
        toolbar = findViewById(R.id.tbl);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lịch sử làm bài");
        getLichSu();

    }
    public void getLichSu(){
        cursor = database.getdata();
        if (cursor.moveToNext()) {
            cursor.moveToFirst();
            do {
                final LuuKetQua ketQua = new LuuKetQua(cursor.getString(1),cursor.getString(2),cursor.getString(3));
                luuKetQuaList.add(ketQua);
                luuKetQuaAdapter = new LuuKetQuaAdapter(LichSuOnTapActivity.this,cursor,true);
                lv.setAdapter(luuKetQuaAdapter);
            } while (cursor.moveToNext());

        }
    }

    public void backLuu(View view) {
        Intent intent = new Intent(LichSuOnTapActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
