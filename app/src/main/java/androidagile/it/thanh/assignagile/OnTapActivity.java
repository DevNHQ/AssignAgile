package androidagile.it.thanh.assignagile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import androidagile.it.thanh.assignagile.adapter.OnTapAdapter;

public class OnTapActivity extends AppCompatActivity {

    private Toolbar toolbarOntap;
    private RecyclerView recyvleviewOntap;


    ArrayList<String> onTapList;
    OnTapAdapter onTapAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_tap);
        toolbarOntap = (Toolbar) findViewById(R.id.toolbar_ontap);
        recyvleviewOntap = (RecyclerView) findViewById(R.id.recyvleview_ontap);

//        setSupportActionBar(toolbarOntap);
//        toolbarOntap.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getListOnTap();
    }

    public void getListOnTap() {
        onTapList = new ArrayList<>();
        onTapList.add("Bài 1");
        onTapList.add("Bài 2");
        onTapList.add("Bài 3");
        onTapAdapter = new OnTapAdapter(OnTapActivity.this, onTapList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyvleviewOntap.setLayoutManager(manager);
        recyvleviewOntap.setAdapter(onTapAdapter);

    }

    public void backToMon(View view) {
    }
}
