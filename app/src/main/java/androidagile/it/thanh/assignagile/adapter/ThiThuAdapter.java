package androidagile.it.thanh.assignagile.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidagile.it.thanh.assignagile.R;
import androidagile.it.thanh.assignagile.StartThiActivity;
import androidagile.it.thanh.assignagile.ThiThuActivity;

public class ThiThuAdapter extends RecyclerView.Adapter<ThiThuAdapter.ThiThuHolder> {

    ThiThuActivity context;
    List<String> thithulist;

    public ThiThuAdapter(ThiThuActivity context, List<String> thithulist) {
        this.context = context;
        this.thithulist = thithulist;
    }

    @NonNull
    @Override
    public ThiThuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_thithu, parent, false);
        return new ThiThuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThiThuHolder holder, int position) {
        holder.tvItemThiThu.setText(thithulist.get(position));
        holder.linearItemThiThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, StartThiActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.e("size", String.valueOf(thithulist.size()));
        return thithulist.size();

    }

    public class ThiThuHolder extends RecyclerView.ViewHolder {
        LinearLayout linearItemThiThu;
        TextView tvItemThiThu;


        public ThiThuHolder(View itemView) {
            super(itemView);
            linearItemThiThu = (LinearLayout) itemView.findViewById(R.id.linearItemThiThu);
            tvItemThiThu = (TextView) itemView.findViewById(R.id.tvItemThiThu);

        }
    }
}
