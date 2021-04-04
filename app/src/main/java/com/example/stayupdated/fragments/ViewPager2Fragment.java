package com.example.stayupdated.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stayupdated.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewPager2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPager2Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;
    private String mParam3;

    public ViewPager2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewPager2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewPager2Fragment newInstance(String param1, int param2, String param3) {
        ViewPager2Fragment fragment = new ViewPager2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_view_pager2, container, false);
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.animate_in);
        view.startAnimation(animation);
/**
 * assigning values to viewpager using ids from layout
 */
        if (mParam1 != null){
            TextView heading = view.findViewById(R.id.nameCredits);
            heading.setText(mParam1);
        }
        if (mParam2 != 0){
            ImageView imageView = view.findViewById(R.id.imageCredits);
            imageView.setImageResource(mParam2);
        }
        if (mParam3 != null){
            TextView description = view.findViewById(R.id.descriptionCredit);
            description.setText(mParam3);
        }
        return view;
    }
}