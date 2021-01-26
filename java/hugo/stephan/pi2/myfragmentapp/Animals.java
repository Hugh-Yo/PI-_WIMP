package hugo.stephan.pi2.myfragmentapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static androidx.navigation.Navigation.findNavController;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Animals#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Animals extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Animals() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Animals.
     */
    // TODO: Rename and change types and number of parameters
    public static Animals newInstance(String param1, String param2) {
        Animals fragment = new Animals();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        Toolbar tb = view.findViewById(R.id.main_activity_toolbar);
        NavController navController = findNavController(getActivity(), R.id.fragment2nav);
        AppBarConfiguration appBarConfig = new AppBarConfiguration.Builder(R.id.animalsFrag, R.id.mapsFrag, R.id.sosFrag, R.id.profileFrag, R.id.moreFrag).build();
        NavigationUI.setupWithNavController(tb, navController, appBarConfig);

        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.topAddAnimalFrag:
                        AddAnimal nextFrag= new AddAnimal();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.animalsLayout, nextFrag)
                                .addToBackStack(null)
                                .commit();
                        return true;
                    default:
                        Toast.makeText(getActivity(), "NOOOOOOOOOT WORKIGN BRUH", Toast.LENGTH_LONG).show();
                        return false;
                }
            }
        });

        List<Animal> AnimalList = new ArrayList<>();
        AnimalList.add(new Animal("Floppy", "GPS : OFF", "Battery : 72%", "Service : OFF", "Active : OFF", "floppy" ));
        AnimalList.add(new Animal("Luke", "GPS : ON", "Battery : 38%", "Service : 4/5", "Active : YES", "luke"));

        ListView AnimalsListView = view.findViewById(R.id.animals_list_view);
        AnimalsListView.setAdapter(new AnimalsAdapter(getContext(), AnimalList));

        AnimalsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowAnimal nextFrag= new ShowAnimal();
                String mBundleKey = "101010101";
                Animal animal = (Animal) AnimalsListView.getItemAtPosition(position);
                String name = (String) animal.getName();

                Bundle bundle = new Bundle();
                bundle.putString(mBundleKey, name);
                nextFrag.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.animalsLayout, nextFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        /*FloatingActionButton fab = view.findViewById(R.id.new_animal_bttn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAnimal nextFrag= new AddAnimal();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.animalsLayout, nextFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });*/
        return view;
    }

/*
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //2 - Inflate the menu and add it to the Toolbar
        inflater.inflate(R.menu.animals_top_menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.topAddAnimalFrag:
                Toast.makeText(getActivity(),"YEAH", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(getActivity(), "NOOOOOOOOOT WORKIGN BRUH", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }
    }*/
}