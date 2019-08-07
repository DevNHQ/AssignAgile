package androidagile.it.thanh.assignagile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import androidagile.it.thanh.assignagile.model.Cauhoi;

public class TracNghiemActivity extends AppCompatActivity {
    List<Cauhoi> cauhoiList;
    private RadioGroup radioGroup;
    private RadioButton rdA;
    private RadioButton rdB;
    private RadioButton rdC;
    private RadioButton rdD;
    private TextView tvNum, tvCauHoi,tvThoigian,tvKiemTra;
    private Button btnNext;
    String link;
    String tt;
    int z = 0;
    int daLam = 0;
    int dung = 0;
    String result;
    private int Thoigian;
    private CounterClass time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trac_nghiem);
        tvThoigian = findViewById(R.id.tvTimer);
        tvNum = findViewById(R.id.tvNum);
        tvCauHoi = findViewById(R.id.tvQuestion);
        tvKiemTra = findViewById(R.id.tvKiemTra);
        rdA = findViewById(R.id.radA);
        rdB = findViewById(R.id.radB);
        rdC = findViewById(R.id.radC);
        rdD = findViewById(R.id.radD);
        radioGroup = findViewById(R.id.radGroup);
        cauhoiList = new ArrayList<>();
        btnNext = findViewById(R.id.nexttt);
        Intent intent = getIntent();
        link = intent.getStringExtra("putdata");
        tt = intent.getStringExtra("tt");
        tvKiemTra.setText(tt);
        Log.e("đa141", link);
        GetHttpTask getHttpTask = new GetHttpTask();
        getHttpTask.execute("http://14.232.125.187:3000/api/" + link);
        Log.e("linkkda", "http://14.232.125.187:3000/api/" + link);
            //Time
        Thoigian = 25;
        time = new CounterClass(Thoigian*60*1000,1000);
        time.start();
    }

    public void Nextttt(View view) {
        kiemtra();
        quiz();
    }
    public void quiz() {

        //xog 10 câu sẽ chuyển sang màn hình kết quả
        if (z > 39) {
            Intent intent = new Intent(TracNghiemActivity.this, KetQuaActivity.class);
            intent.putExtra("DaLam", String.valueOf(daLam));
            intent.putExtra("Dung", String.valueOf(dung));
            intent.putExtra("putdata",link);
            startActivity(intent);
        }

        //set uncheck cho radio
        rdA.setChecked(false);
        rdB.setChecked(false);
        rdC.setChecked(false);
        rdD.setChecked(false);


        //lấy 10 câu hỏi ngẫu nhiên
        for (int i = z; i < 40; i++) {
            tvNum.setText("Câu " + (z + 1) + ": ");
            Random random = new Random();
            int choose = random.nextInt(160);
            Cauhoi cauhoi = cauhoiList.get(choose);
            result = cauhoi.dapAn;
            //cau hoi
            tvCauHoi.setText(cauhoi.cauHoi);
            //cau tra loi
            rdA.setText("A : " + cauhoi.ketQuaA);
            rdB.setText("B : " + cauhoi.ketQuaB);
            rdC.setText("C : " + cauhoi.ketQuaC);
            rdD.setText("D : " + cauhoi.ketQuaD);

            Log.e("z", z + "");
            z++;
            break;
        }
    }
    public void kiemtra() {
        //lấy kết quả

        Log.e("result", z + " - " + result);

        //kiểm tra radiobuuton nào check -> ktra giá trị đó đúng/sai?
        if (rdA.isChecked()) {
            if (rdA.getText().equals("A : "+result)) {
                dung++;
                Toast.makeText(TracNghiemActivity.this, "Đáp án :" + rdA.getText(), Toast.LENGTH_SHORT).show();
            }
        }
        else if (rdB.isChecked()) {
            if (rdB.getText().equals("B : "+result)) {
                dung++;
                Toast.makeText(this, "Đáp án :" +rdB.getText(), Toast.LENGTH_SHORT).show();
            }
        }
        else if (rdC.isChecked()) {
            if (rdC.getText().equals("C : "+result)) {
                dung++;
                Toast.makeText(this, "Đáp án :"+rdC.getText(), Toast.LENGTH_SHORT).show();
            }
        }
        else if (rdD.isChecked()) {
            if (rdD.getText().equals("D : "+result)) {
                dung++;
                Toast.makeText(this, "Đáp án "+rdD.getText(), Toast.LENGTH_SHORT).show();
            }
        }

        //đã làm +1;
        else if (rdA.isChecked() || rdB.isChecked() || rdC.isChecked() || rdD.isChecked()) {
            daLam++;
        }
    }

    //THoi gian
    public class CounterClass extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tvThoigian.setText(countTime);
        }

        @Override
        public void onFinish() {
            tvThoigian.setText("00:00");
            time.cancel();
            ShowAlertDialog();
            Intent intent = new Intent(TracNghiemActivity.this, KetQuaActivity.class);
            intent.putExtra("DaLam", String.valueOf(daLam));
            intent.putExtra("Dung", String.valueOf(dung));
            intent.putExtra("putdata",link);
            startActivity(intent);

        }
        public void ShowAlertDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(TracNghiemActivity.this);
            builder.setTitle("Thông Báo !");
            builder.setMessage("Bạn đã hết thời gian làm bài !");
            builder.setPositiveButton("Đồng Ý", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.show();
        }
    }

    public class GetHttpTask extends AsyncTask<String, Long, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                BufferedReader r = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                String line = "";

                StringBuilder builder = new StringBuilder();

                while ((line = r.readLine()) != null) {
                    builder.append(line);
                }
                return String.valueOf(builder);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONArray root = new JSONArray(s);

                for (int i = 0; i < root.length(); i++) {
                    JSONObject jsonObject = root.getJSONObject(i);

                    String cauHoi = jsonObject.getString("cauhoi");
                    String ketQuaA = jsonObject.getString("A");
                    String ketQuaB = jsonObject.getString("B");
                    String ketQuaC = jsonObject.getString("C");
                    String ketQuaD = jsonObject.getString("D");

                    //tách đáp án
                    String dapAn = jsonObject.getString("ketqua").substring(4,5);
                    String answer = jsonObject.getString(dapAn);

                    Cauhoi cauhoi = new Cauhoi();
                    cauhoi.cauHoi = cauHoi;
                    cauhoi.ketQuaA = ketQuaA;
                    cauhoi.ketQuaB = ketQuaB;
                    cauhoi.ketQuaC = ketQuaC;
                    cauhoi.ketQuaD = ketQuaD;
                    cauhoi.dapAn = answer;
                    cauhoiList.add(cauhoi);
                }

                //gọi quiz ->load câu hỏi ngay khi có dữ liệu
                quiz();
                //kiemtra();


            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("error ", s);
            }
        }
    }
    //Back
    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
            AlertDialog.Builder builder = new AlertDialog.Builder(TracNghiemActivity.this);
            builder.setTitle("Bạn đang trong  quá trình làm bài !");
            builder.setMessage("Xác nhận thoát !");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.show();

        }
}
