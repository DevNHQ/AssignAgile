package androidagile.it.thanh.assignagile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class KetQuaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);
    }

    public void backToThiThu(View view) {
        Intent intent = new Intent(KetQuaActivity.this, ThiThuActivity.class);
        startActivity(intent);
    }
}
