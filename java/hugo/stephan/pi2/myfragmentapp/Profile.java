package hugo.stephan.pi2.myfragmentapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profile.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
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
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        Toolbar tb = v.findViewById(R.id.profile_activity_toolbar);
        NavController navController = findNavController(getActivity(), R.id.fragment2nav);
        AppBarConfiguration appBarConfig = new AppBarConfiguration.Builder(R.id.animalsFrag, R.id.mapsFrag, R.id.sosFrag, R.id.profileFrag, R.id.moreFrag).build();
        NavigationUI.setupWithNavController(tb, navController, appBarConfig);


        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.topEditProfileFrag:
                        AddPerson nextFrag= new AddPerson();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.profileLayout, nextFrag)
                                .addToBackStack(null)
                                .commit();
                        return true;
                    default:
                        Toast.makeText(getActivity(), "NOOOOOOOOOT WORKIGN BRUH", Toast.LENGTH_LONG).show();
                        return false;
                }
            }
        });


        /*FloatingActionButton fab = v.findViewById(new_person_bttn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddPerson nextFrag= new AddPerson();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.profileLayout, nextFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });*/

        return v;
    }
}