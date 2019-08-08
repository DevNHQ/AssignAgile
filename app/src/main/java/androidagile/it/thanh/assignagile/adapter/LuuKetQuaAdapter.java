package androidagile.it.thanh.assignagile.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidagile.it.thanh.assignagile.R;
import androidagile.it.thanh.assignagile.model.LuuKetQua;

public class LuuKetQuaAdapter  extends CursorAdapter {
    public LuuKetQuaAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view  = LayoutInflater.from(context).inflate(R.layout.item_lichsu_ontap,viewGroup,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        List<LuuKetQua> luuKetQuas = new ArrayList<>();
        TextView name = view.findViewById(R.id.tvname);
        TextView monhoc = view.findViewById(R.id.tvmonhoc);
        TextView diem = view.findViewById(R.id.tvdiem);
        name.setText("Tên : "+cursor.getString(1));
        monhoc.setText("Môn :"+cursor.getString(2));
        diem.setText("Điểm : "+cursor.getString(3));
    }
}
