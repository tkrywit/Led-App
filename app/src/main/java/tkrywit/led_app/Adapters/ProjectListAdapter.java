package tkrywit.led_app.Adapters;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tkrywit.led_app.Model.Project;
import tkrywit.led_app.Model.Room;
import tkrywit.led_app.R;
import tkrywit.led_app.Utilities.StateManager;

/**
 * Created by tkryw on 4/6/2017.
 */

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectViewHolder>  {

    private StateManager stateManager;

    public class ProjectViewHolder extends RecyclerView.ViewHolder {

        public TextView roomName, desc;
        public ImageView image;

        public ProjectViewHolder(View view) {
            super(view);
            roomName = (TextView) view.findViewById(R.id.listProjTitle);
            desc = (TextView) view.findViewById(R.id.listProjDesc);
            image = (ImageView) view.findViewById(R.id.listProjImage);
        }
    }

    public ProjectListAdapter() {
        this.stateManager = StateManager.getInstance();
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_list_item, parent, false);

        return new ProjectViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        holder.roomName.setText(stateManager.getProjects().get(position).getTitle());
        holder.desc.setText(stateManager.getProjects().get(position).getDescription());
        holder.image.setImageBitmap(stateManager.getProjects().get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return stateManager.getProjects().size();
    }

}
