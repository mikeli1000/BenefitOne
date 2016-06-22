package com.itf.benefitone;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TodayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TodayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodayFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_today,null);
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
