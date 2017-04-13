package tkrywit.led_app.Fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tkrywit.led_app.Adapters.RoomListAdapter;
import tkrywit.led_app.R;
import tkrywit.led_app.Utilities.StateManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomListFragment extends Fragment {

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
        RoomListAdapter adapter = new RoomListAdapter(stateManager.getProjects().get(projectIndex).getRooms());
        list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.roomListFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This is probably not the best way to do this

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                AddRoomFrag roomDialogFrag = new AddRoomFrag();
                ft.replace(R.id.roomContainer, roomDialogFrag, "projectFrag");

                ft.commit();
            }
        });

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(stateManager.getProjects().get(projectIndex).getTitle());

        return view;
    }



}
