package com.ftninformatika.termin19radnacasu;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {



    private String items[];
    private onClickListener listener;

    public interface  onClickListener{
        void onClick(String text);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvText;
        CardView container;

        public MyViewHolder(View v){
            super(v);
            tvText = v.findViewById(R.id.tvText);
            container = (CardView) v;


        }
        public void bind(final String ime, final onClickListener listener){
            tvText.setText(ime);
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(ime);
                }
            });
        }
    }

    public RvAdapter (String items[], onClickListener listener){
        this.items = items;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item, viewGroup, false);
       MyViewHolder vh = new MyViewHolder(cv);
        return vh;



    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       // holder.tvText.setText(items[position]);
        holder.bind(items[position], listener);


    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
