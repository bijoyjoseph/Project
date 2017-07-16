package com.finance.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finance.R;

/**
 * Created by Bijoy on 8/18/2015.
 */
public class ProductDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] productIllustrationTypes = {"Aajeevan sampatti+","Aajeevan saridhi", "Elite advantage", "Triple health plan",
            "Flexi save", "Monthly income plan","Super series"};
    private View.OnClickListener listener = null;

    public ProductDetailsAdapter(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PriceTrackerDetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_illustration, parent, false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PriceTrackerDetailsViewHolder priceTrackerDetailsViewHolder = (PriceTrackerDetailsViewHolder) holder;
        priceTrackerDetailsViewHolder.itemView.setOnClickListener(listener);
        priceTrackerDetailsViewHolder.itemView.setTag(position);
        priceTrackerDetailsViewHolder.tvTitle.setText(productIllustrationTypes[position]);
    }


    @Override
    public int getItemCount() {
        return productIllustrationTypes.length;
    }


    public class PriceTrackerDetailsViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle = null;

        public PriceTrackerDetailsViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }

}
