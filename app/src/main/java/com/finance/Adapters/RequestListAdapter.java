package com.finance.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finance.R;
import com.finance.Util.Const;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bijoy on 8/18/2015.
 */
public class RequestListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* private String[] productIllustrationTypes = {"Child advantage", "Samridhi", "Elite advantage", "Aajeevan sampatti+",
             "secure in come plan", "Flexi save", "Monthly income plan"};*/
    private View.OnClickListener listener = null;
    private ArrayList<HashMap<String, String>> maps = null;
    private Context context = null;
    private boolean callVisiblity = true;

    public RequestListAdapter(View.OnClickListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PriceTrackerDetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_request_list, parent, false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PriceTrackerDetailsViewHolder priceTrackerDetailsViewHolder = (PriceTrackerDetailsViewHolder) holder;
        priceTrackerDetailsViewHolder.itemView.setOnClickListener(listener);
        priceTrackerDetailsViewHolder.itemView.setTag(position);
        priceTrackerDetailsViewHolder.tvTitle.setText(maps.get(position).get(Const.FbConst.NAME));
        if (callVisiblity) {
            if (maps.get(position).get(Const.FbConst.CALLED).equals("1")) {
                priceTrackerDetailsViewHolder.tvCalled.setTextColor(context.getResources().getColor(R.color.red));
                priceTrackerDetailsViewHolder.tvHold.setTextColor(context.getResources().getColor(R.color.gold));
            } else if (maps.get(position).get(Const.FbConst.CALLED).equals("2")) {
                priceTrackerDetailsViewHolder.tvCalled.setTextColor(context.getResources().getColor(R.color.gold));
                priceTrackerDetailsViewHolder.tvHold.setTextColor(context.getResources().getColor(R.color.red));
            } else {
                priceTrackerDetailsViewHolder.tvCalled.setTextColor(context.getResources().getColor(R.color.gold));
                priceTrackerDetailsViewHolder.tvHold.setTextColor(context.getResources().getColor(R.color.gold));
            }
        } else {
            priceTrackerDetailsViewHolder.tvCalled.setVisibility(View.GONE);
            priceTrackerDetailsViewHolder.tvHold.setVisibility(View.GONE);
        }
        priceTrackerDetailsViewHolder.tvCalled.setOnClickListener(listener);
//        priceTrackerDetailsViewHolder.tvRejected.setOnClickListener(listener);
        priceTrackerDetailsViewHolder.tvHold.setOnClickListener(listener);
    }

    public void setValue(ArrayList<HashMap<String, String>> maps) {
        this.maps = maps;
    }

    @Override
    public int getItemCount() {
        if (maps != null) {
            return maps.size();

        } else {
            return 0;

        }
    }


    public class PriceTrackerDetailsViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle = null;
        TextView tvCalled = null;
        TextView tvRejected = null;
        TextView tvHold = null;

        public PriceTrackerDetailsViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvCalled = (TextView) itemView.findViewById(R.id.tvCalled);
            tvRejected = (TextView) itemView.findViewById(R.id.tvRejected);
            tvHold = (TextView) itemView.findViewById(R.id.tvHold);
        }
    }

    public void setCallVisisblity(boolean isVisible) {
        this.callVisiblity = isVisible;
    }

}
