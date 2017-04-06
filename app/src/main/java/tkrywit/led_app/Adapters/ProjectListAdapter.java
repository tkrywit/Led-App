package tkrywit.led_app.Adapters;

import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tkrywit.led_app.Model.Project;
import tkrywit.led_app.R;

/**
 * Created by tkryw on 4/6/2017.
 */

public class ProjectListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Project> projects;
    private Fragment fragment;

    public ProjectListAdapter(Context context, ArrayList<Project> projects, Fragment fragment) {
        this.context = context;
        this.projects = projects;
        this.fragment = fragment;
    }

    @Override
    public int getCount() {
        return projects.size();
    }

    @Override
    public Object getItem(int position) {
        return projects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        LayoutInflater inflater = fragment.getActivity().getLayoutInflater();
        final MyViewHolder holder;

        //if view has not been inflated yet
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.project_list_item, parent, false);
            holder = new MyViewHolder();
            holder.photo =  (ImageView) convertView.findViewById(R.id.listProjImage);
            holder.title = (TextView) convertView.findViewById(R.id.listProjTitle);
            holder.desc = (TextView) convertView.findViewById(R.id.listProjDesc);

            convertView.setTag(holder);

        } else {
            //return old viewholder
            holder = (MyViewHolder) convertView.getTag();
        }

        //Bind data to views
        holder.title.setText(projects.get(position).getTitle());
        holder.desc.setText(projects.get(position).getDescription());
        holder.photo.setImageBitmap(projects.get(position).getPhoto());

        return convertView;
    }

    private static class MyViewHolder {
        TextView title;
        TextView desc;
        ImageView photo;
    }

}
