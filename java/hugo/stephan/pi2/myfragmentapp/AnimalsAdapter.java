package hugo.stephan.pi2.myfragmentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AnimalsAdapter extends BaseAdapter {

    private Context mContext;
    private List<Animal> mAnimalList;
    private LayoutInflater mInflater;

    public AnimalsAdapter(Context context, List<Animal> animalList) {
        mContext = context;
        mAnimalList = animalList;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {return mAnimalList.size();
    }

    @Override
    public Animal getItem(int position) {return mAnimalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.animal_item, null);

        Animal currentAnimal = getItem(position);
        String animalName  = currentAnimal.getName();
        String animalGPS = currentAnimal.getGps();
        String animalBattery = currentAnimal.getBattery();
        String animalService = currentAnimal.getService();
        String animalActive = currentAnimal.getActive();
        String animalMnemo = currentAnimal.getMnemonic();


        ImageView animalIMGView = convertView.findViewById(R.id.animal_pic);
        int resId = mContext.getResources().getIdentifier(animalMnemo, "drawable", mContext.getPackageName());
        animalIMGView.setImageResource(resId);

        TextView animalNameView = convertView.findViewById(R.id.animal_name);
        animalNameView.setText(animalName);

        TextView animalGPSView = convertView.findViewById(R.id.animal_GPS);
        animalGPSView.setText(animalGPS);

        TextView animalBatteryView = convertView.findViewById(R.id.animal_battery);
        animalBatteryView.setText(animalBattery);

        TextView animalServiceView = convertView.findViewById(R.id.animal_service);
        animalServiceView.setText(animalService);

        TextView animalActiveView = convertView.findViewById(R.id.animal_active);
        animalActiveView.setText(animalActive);

        return convertView;
    }
}
