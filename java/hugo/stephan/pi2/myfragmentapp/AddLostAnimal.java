package hugo.stephan.pi2.myfragmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddLostAnimal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddLostAnimal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddLostAnimal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddLostAnimal.
     */
    // TODO: Rename and change types and number of parameters
    public static AddLostAnimal newInstance(String param1, String param2) {
        AddLostAnimal fragment = new AddLostAnimal();
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
        View v = inflater.inflate(R.layout.fragment_add_lost_animal, container, false);

        List<Animal> AnimalList = new ArrayList<>();
        AnimalList.add(new Animal("Floppy", "GPS : OFF", "Battery : 72%", "Service : OFF", "Active : OFF", "floppy" ));
        AnimalList.add(new Animal("Luke", "GPS : ON", "Battery : 38%", "Service : 4/5", "Active : YES", "luke"));

        ListView AnimalsListView = v.findViewById(R.id.loose_animal_list_view);
        AnimalsListView.setAdapter(new AnimalsAdapter(getContext(), AnimalList));

        Button button = v.findViewById(R.id.declare_other_loss_bttn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddOtherLostAnimal nextFrag= new AddOtherLostAnimal();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.addLostAnimalLayout, nextFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }
}