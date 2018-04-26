package com.fingertip.seekaround.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fingertip.seekaround.R;

import java.util.ArrayList;
import java.util.List;

public class HorizontalRVAdapter extends RecyclerView.Adapter<HorizontalRVAdapter.ViewHolder> {

    private List<String> itemsList = new ArrayList<>();
    private Context mContext;
    private int type;

    public HorizontalRVAdapter(Context mContext, List<String> itemsList, int type) {
        this.itemsList = itemsList;
        this.mContext = mContext;
        this.type = type;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rvViwe;
        if (type == 1) {
            rvViwe = LayoutInflater.from(mContext).inflate(R.layout.cat_rv_item, null);
        } else if (type==2){
            rvViwe = LayoutInflater.from(mContext).inflate(R.layout.offer_rv_item, null);
        }else if (type==3){
            rvViwe = LayoutInflater.from(mContext).inflate(R.layout.restaurent_rv_item, null);
        }else {
            rvViwe = LayoutInflater.from(mContext).inflate(R.layout.popular_rv_item, null);
        }

        return new ViewHolder(rvViwe);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 0) {
            CardView.LayoutParams buttonLayoutParams = new CardView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            buttonLayoutParams.setMargins(20, 0, 0, 0);
            holder.containerCardView.setLayoutParams(buttonLayoutParams);
        } else if (position == 9) {
            CardView.LayoutParams buttonLayoutParams = new CardView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            buttonLayoutParams.setMargins(0, 0, 20, 0);
            holder.containerCardView.setLayoutParams(buttonLayoutParams);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView containerCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            containerCardView = itemView.findViewById(R.id.containerCardView);
        }
    }
}
