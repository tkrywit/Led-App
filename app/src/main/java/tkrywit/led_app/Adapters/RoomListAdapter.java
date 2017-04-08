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
import tkrywit.led_app.Model.Room;
import tkrywit.led_app.R;

/**
 * Created by tkryw on 4/8/2017.
 */
public class RoomListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Room> rooms;
    private Fragment fragment;

    public RoomListAdapter(Context context, ArrayList<Room> rooms, Fragment fragment) {
        this.context = context;
        this.rooms = rooms;
        this.fragment = fragment;
    }

    @Override
    public int getCount() {
        return rooms.size();
    }

    @Override
    public Object getItem(int position) {
        return rooms.get(position);
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
            convertView = inflater.inflate(R.layout.room_list_item, parent, false);
            holder = new MyViewHolder();
            holder.roomName = (TextView) convertView.findViewById(R.id.roomTitleTextView);
            holder.desc = (TextView) convertView.findViewById(R.id.roomFixtureTextView);

            convertView.setTag(holder);

        } else {
            //return old viewholder
            holder = (MyViewHolder) convertView.getTag();
        }

        //Bind data to views
        holder.roomName.setText(context.getResources().getString(R.string.bulb));
        holder.desc.setText(rooms.get(position).getName());
        return convertView;
    }

    private static class MyViewHolder {
        TextView roomName;
        TextView desc;

    }

}