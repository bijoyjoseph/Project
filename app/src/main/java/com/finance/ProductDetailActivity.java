package com.finance;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.finance.Util.Const;

/**
 * Created by Avinash on 5/13/2016.
 */
public class ProductDetailActivity extends Activity {
    private TextView tvHeader = null;
    private TextView tvSubtiltle = null;
    private TextView tvDetails = null;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        position = Integer.parseInt(getIntent().getStringExtra(Const.IntentConst.LIST_POSITION));

        tvHeader = (TextView) findViewById(R.id.tvHeader);
        tvSubtiltle = (TextView) findViewById(R.id.tvSubtiltle);
        tvDetails = (TextView) findViewById(R.id.tvDetails);

        tvHeader.setText(getResources().getStringArray(R.array.data_title)[position]);
        tvSubtiltle.setText(getResources().getStringArray(R.array.data_subtitle)[position]);
        tvDetails.setText(getResources().getStringArray(R.array.data_four_reasons)[position]);
    }
}
