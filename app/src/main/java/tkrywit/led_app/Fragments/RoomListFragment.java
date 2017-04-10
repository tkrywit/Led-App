package tkrywit.led_app.Fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

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
        View view = inflater.inflate(R.layout.room_list_fragment, container, false);
        RecyclerView list = (RecyclerView) view.findViewById(R.id.roomRecyclerView);
        list.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        adapter = new RoomListAdapter(stateManager.getProjects().get(projectIndex).getRooms());
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.roomListFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Launch a new project fragment
                Toast.makeText(getActivity().getApplicationContext(), "FABulous", Toast.LENGTH_SHORT).show();
            }
        });

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(stateManager.getProjects().get(projectIndex).getTitle());

        return view;
    }

}
