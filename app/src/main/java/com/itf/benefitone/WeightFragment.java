package com.itf.benefitone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeightFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_weight,null);
        return view;
    }

    @Override
    public  void setMenuVisibility(boolean menuVisibility) {
        super.setMenuVisibility(menuVisibility);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibility ? View.VISIBLE : View.GONE);
        }
    }

}
