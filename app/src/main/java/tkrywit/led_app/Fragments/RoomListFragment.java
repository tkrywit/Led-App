package tkrywit.led_app.Fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import tkrywit.led_app.Adapters.ProjectListAdapter;
import tkrywit.led_app.Adapters.RoomListAdapter;
import tkrywit.led_app.R;
import tkrywit.led_app.Utilities.StateManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomListFragment extends Fragment {

    RoomListAdapter adapter;
    StateManager stateManager;
    int projectIndex = 0;

    public RoomListFragment() {
        // Required empty public constructor
        Bundle bundle = this.getArguments();

        stateManager = StateManager.getInstance();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView list = (ListView) view.findViewById(R.id.projList);
        adapter = new RoomListAdapter(getActivity().getApplicationContext(), stateManager.getProjects().get(projectIndex).getRooms(), this);
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.mainFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Launch a new project fragment
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                RoomListFragment pf = new RoomListFragment();
                ft.replace(R.id.fragmentContainer, pf, "projectFrag");

                ft.commit();
            }
        });

        return view;
    }

}
