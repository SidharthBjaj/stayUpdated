package com.example.stayupdated.fragments;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.stayupdated.R;
import com.example.stayupdated.adapters.FavoriteAdapter;
import com.example.stayupdated.database.database;
import com.example.stayupdated.pojo.favorite;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.stayupdated.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteFragment extends Fragment {


    private SharedPreferences sharedPreferences;

    Boolean delete ;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavoriteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoriteFragment newInstance(String param1, String param2, String param3) {
        FavoriteFragment fragment = new FavoriteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.favoriteList);

/**
 * reloading arraylist from database to check for values in the database
 * displays the card views with added news articles to favorite screen.
 */
        fab.setImageResource(R.drawable.ic_baseline_add_circle_outline_24);
        fab.hide();
        database db = new database(getContext());
        ArrayList<favorite> favorites = db.getAllFavorites();
        db.close();

        FavoriteAdapter adapter = new FavoriteAdapter(favorites,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
    @Override
    public void onResume() {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        delete = sharedPreferences.getBoolean("drop",false);
        if (delete == true){
            database db = new database(getContext());
            db.dropFavorite();
        }
        super.onResume();
    }

}