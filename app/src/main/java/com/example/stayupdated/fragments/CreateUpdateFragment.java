package com.example.stayupdated.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.stayupdated.R;
import com.example.stayupdated.database.database;
import com.example.stayupdated.pojo.favorite;

public class CreateUpdateFragment extends Fragment {

    favorite favorite;
    public static final int UPDATE = 1;
    public static final int CREATE = 2;

    public static final String FAVORITE = "Record";
    public static final String ACTION_TYPE="action_type";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_update, container, false);
        EditText name = view.findViewById(R.id.memberName);
        EditText postion = view.findViewById(R.id.positionText);
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.animate_in);
        view.startAnimation(animation);
        Button submit = view.findViewById(R.id.submitButton);

        if (getArguments() != null){
            if(getArguments().getInt(ACTION_TYPE) == UPDATE){
                favorite = getArguments().getParcelable(FAVORITE);
                submit.setText("UPDATE DATA");

                if (favorite != null){
                    name.setText(favorite.getHeading());
                    postion.setText(favorite.getDescription());

                }
            }
            else {
                favorite = new favorite();
                submit.setText("CREATE DATA");
            }
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    favorite.setHeading(name.getText().toString());
                    favorite.setDescription(postion.getText().toString());


                    database db = new database(getContext());
                    if (getArguments().getInt(ACTION_TYPE) == UPDATE){
                        db.updateData(favorite);
                    }else  if (getArguments().getInt(ACTION_TYPE) == CREATE){
                        db.addFavorite(favorite);
                    }
                    db.close();
                    Navigation.findNavController(view).popBackStack();
                }
            });
        }

        return view;
    }
}