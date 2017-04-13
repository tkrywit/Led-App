package tkrywit.led_app.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import tkrywit.led_app.Adapters.ProjectListAdapter;
import tkrywit.led_app.Fragments.AddProjectDialogFrag;
import tkrywit.led_app.R;
import tkrywit.led_app.Utilities.StateManager;

public class MainActivity extends AppCompatActivity implements AddProjectDialogFrag.AddProjectListener{

    ProjectListAdapter adapter;
    StateManager stateManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_list_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        stateManager = StateManager.getInstance();

        RecyclerView list = (RecyclerView) findViewById(R.id.projRecycler);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new ProjectListAdapter();
        list.setAdapter(adapter);

        TextView noProjects = (TextView) findViewById(R.id.no_project_tv);
        if (list.getAdapter().getItemCount() == 0) {
            noProjects.setVisibility(View.VISIBLE);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.mainFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Launch a new project fragment
                // close existing dialog fragments

                AddProjectDialogFrag addDialogFrag = new AddProjectDialogFrag();
                addDialogFrag.show(getSupportFragmentManager(), "AddFrag");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onAddProject(String title, String desc) {
        stateManager.addProject(title, desc);
        Intent intent = new Intent(this, RoomActivity.class);
        startActivity(intent);
    }
}
