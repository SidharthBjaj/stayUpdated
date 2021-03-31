package com.example.stayupdated.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    int number = 20;
    TextView desc;
    TextView head;

    private SharedPreferences sharedPreferences;
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
        desc = view.findViewById(R.id.newsHead);
        head = view.findViewById(R.id.newsDesc);
        fab.setImageResource(R.drawable.ic_baseline_add_circle_outline_24);
        fab.show();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extra = new Bundle();
                extra.putInt(CreateUpdateFragment.ACTION_TYPE, CreateUpdateFragment.CREATE);
                Navigation.findNavController(view).navigate(R.id.nav_create,extra);
            }
        });
        database db = new database(getContext());
        ArrayList<favorite> favorites = db.getAllFavorites();
//        desc.setTextSize(20);
//        head.setTextSize(20);
        db.close();

        FavoriteAdapter adapter = new FavoriteAdapter(favorites,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

//    @Override
//    public void onResume() {
//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
//
//        int textValue = Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "20")));
//
//        if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "20")))) {
//            desc.setTextSize(Float.parseFloat(String.valueOf(textValue)));
//            head.setTextSize(Float.parseFloat(String.valueOf(textValue)));
//            desc.refreshDrawableState();
//            head.refreshDrawableState();
//        } else if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "22")))) {
//            desc.setTextSize(Float.parseFloat(String.valueOf(textValue)));
//            head.setTextSize(Float.parseFloat(String.valueOf(textValue)));
//            desc.refreshDrawableState();
//            head.refreshDrawableState();
//        } else if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "24")))) {
//            desc.setTextSize(Float.parseFloat(String.valueOf(textValue)));
//            head.setTextSize(Float.parseFloat(String.valueOf(textValue)));
//            desc.refreshDrawableState();
//            head.refreshDrawableState();
//        } else if (textValue == Integer.parseInt(Objects.requireNonNull(sharedPreferences.getString("size", "26"))))
//            desc.setTextSize(Float.parseFloat(String.valueOf(textValue)));
//        head.setTextSize(Float.parseFloat(String.valueOf(textValue)));
//        desc.refreshDrawableState();
//        head.refreshDrawableState();
//
//        super.onResume();
//    }
}