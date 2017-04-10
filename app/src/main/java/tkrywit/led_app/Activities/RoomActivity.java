package tkrywit.led_app.Activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import tkrywit.led_app.Fragments.RoomListFragment;
import tkrywit.led_app.R;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        RoomListFragment pf = new RoomListFragment();
        ft.replace(R.id.roomContainer, pf, "projectFrag");

        ft.commit();

    }
}
