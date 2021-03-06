package com.example.stayupdated.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.stayupdated.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreditsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreditsFragment extends Fragment {
    ViewPager2 creditsViewPager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreditsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreditsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreditsFragment newInstance(String param1, String param2) {
        CreditsFragment fragment = new CreditsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * inserted values in credits page manually with image
     * also made CustomerAdaptor
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_credits, container, false);
        creditsViewPager = view.findViewById(R.id.creditsViewPager);
        creditsViewPager.setAdapter(new CustomViewPager2Adapter(getActivity()));
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.animate_in);
        view.startAnimation(animation);
        return view;
    }



    private class CustomViewPager2Adapter extends FragmentStateAdapter {
        public CustomViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }
        /**
         * trying to load data from api
         */
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {

                case 0:
                    return ViewPager2Fragment.newInstance("Phone Icon", R.drawable.telephone, "\n\nThis cover has been designed using resources from Flaticon.com");
                case 1:
                    return ViewPager2Fragment.newInstance("Maps Icon", R.drawable.googlemaps, "\n\nThis cover has been designed using resources from Flaticon.com");
                case 2:
                    return ViewPager2Fragment.newInstance("LinkedIn Icon", R.drawable.linkedin, "\n\nThis cover has been designed using resources from Flaticon.com");
                case 3:
                    return ViewPager2Fragment.newInstance("Gmail Icon", R.drawable.gmail, "\n\nThis cover has been designed using resources from Flaticon.com");
                case 4:
                    return ViewPager2Fragment.newInstance("Contact Us", R.drawable.newpage, "\n\nImage By Visuals from UnSplash");

                default:
                    return ViewPager2Fragment.newInstance("default", R.drawable.telephone, "none");
            }
        }




        @Override
        public int getItemCount() {
            return 5;
        }
    }
}