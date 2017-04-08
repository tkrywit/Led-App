package tkrywit.led_app.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tkrywit.led_app.Adapters.ProjectListAdapter;
import tkrywit.led_app.Model.Project;
import tkrywit.led_app.Model.Room;
import tkrywit.led_app.R;
import tkrywit.led_app.Utilities.StateManager;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProjectListFragment extends Fragment {

    ProjectListAdapter adapter;
    StateManager stateManager;

    public ProjectListFragment() {
        stateManager = StateManager.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView list = (ListView) view.findViewById(R.id.projList);
        adapter = new ProjectListAdapter(getActivity().getApplicationContext(), this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,
                                            int position, long id) {

                        Toast.makeText(getActivity().getApplicationContext(), "List item clicked", Toast.LENGTH_LONG).show();
                    }
                }
        );

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
