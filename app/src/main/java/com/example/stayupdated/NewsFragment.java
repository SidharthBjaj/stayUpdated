package com.example.stayupdated;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.stayupdated.pojo.news;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String REQUEST_URL = "http://newsapi.org/v2/everything?q=apple&from=2021-03-16&to=2021-03-16&sortBy=popularity&apiKey=26349142ab734d36820657e1b2658eef";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        /**
         * recycler view added
         */
        ArrayList<news> newsArrayList = new ArrayList<>();

        RecyclerView recyclerView = view.findViewById(R.id.newsList);
        /**
         * trying to load data from api
         */
//

//
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(new NewAdapter(newsArrayList, getContext()));

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("loading");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, REQUEST_URL,
                response -> {

                    try {
                        JSONObject baseObject = new JSONObject(response);
                        JSONArray articles = baseObject.getJSONArray("articles");

                        for (int i = 0; i < articles.length(); i++) {
                            JSONObject jsonObject = articles.getJSONObject(i);
                            news newsItem = new news(jsonObject.getString("title"),
                                    jsonObject.getString("description"),
                                    jsonObject.getString("urlToImage"),
                                    jsonObject.getString("url"));

//                            progressDialog.dismiss();
                            newsArrayList.add(newsItem);
                        }
                    } catch (JSONException e) {
                        Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

        NewAdapter adapter = new NewAdapter(newsArrayList,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}