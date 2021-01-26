package hugo.stephan.pi2.myfragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static androidx.navigation.Navigation.findNavController;
import static androidx.navigation.ui.NavigationUI.setupWithNavController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView botNavView = findViewById(R.id.bot_nav_bar);
        NavController navController = findNavController(this, R.id.fragment2nav);
        setupWithNavController(botNavView, navController);
        /*Toolbar tb = findViewById(R.id.main_activity_toolbar);

        AppBarConfiguration appBarConfig = new AppBarConfiguration.Builder(R.id.animalsFrag, R.id.mapsFrag, R.id.sosFrag, R.id.profileFrag, R.id.moreFrag).build();
        NavigationUI.setupWithNavController(tb, navController, appBarConfig);*/
    }

}