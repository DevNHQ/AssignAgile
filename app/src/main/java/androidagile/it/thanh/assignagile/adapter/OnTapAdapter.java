package androidagile.it.thanh.assignagile.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidagile.it.thanh.assignagile.OnTapActivity;
import androidagile.it.thanh.assignagile.R;
import androidagile.it.thanh.assignagile.StartOnActivity;
import androidagile.it.thanh.assignagile.StartThiActivity;

public class OnTapAdapter extends RecyclerView.Adapter<OnTapAdapter.OnTapHolder> {

    OnTapActivity context;
    ArrayList<String> onTapLists;

    public OnTapAdapter(OnTapActivity context, ArrayList<String> onTapLists) {
        this.context = context;
        this.onTapLists = onTapLists;
    }

    @NonNull
    @Override
    public OnTapHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview_ontap, parent, false);
        return new OnTapHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnTapHolder holder, int position) {
        holder.tvItemOnTap.setText(onTapLists.get(position));
        holder.linearItemOnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, StartOnActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return onTapLists.size();
    }

    public class OnTapHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearItemOnTap;
        private TextView tvItemOnTap;

        public OnTapHolder(View itemView) {
            super(itemView);
            linearItemOnTap = (LinearLayout) itemView.findViewById(R.id.linearItemOnTap);
            tvItemOnTap = (TextView) itemView.findViewById(R.id.tvItemOnTap);
        }
    }
}
