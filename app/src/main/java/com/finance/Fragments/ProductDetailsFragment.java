package com.finance.Fragments;

/**
 * Created by Bijoy on 5/13/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finance.Adapters.ProductDetailsAdapter;
import com.finance.Adapters.ProductIllustrationAdapter;
import com.finance.MainActivity;
import com.finance.ProductDetailActivity;
import com.finance.ProductIllustrationActivity;
import com.finance.R;
import com.finance.Util.Const;

/**
 * Created by Bijoy on 3/12/2016.
 */
public class ProductDetailsFragment extends Fragment implements View.OnClickListener {
    private RecyclerView rvProductIllustrationList = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_illustration, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi(view);
    }

    private void initUi(View view){
        rvProductIllustrationList = (RecyclerView) view.findViewById(R.id.rvProductIllustrationList);

        rvProductIllustrationList.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rvProductIllustrationList.setAdapter(new ProductDetailsAdapter(this));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
        intent.putExtra(Const.IntentConst.LIST_POSITION,String.valueOf(v.getTag()));
        startActivity(intent);
       /* switch (v.getTag().toString()){
            case "0":
                ((MainActivity)getActivity()).addChildAdvantageFragment();
                break;
            case "1":
                ((MainActivity)getActivity()).addSamridhiFragment();
                break;
        }*/
    }
}
