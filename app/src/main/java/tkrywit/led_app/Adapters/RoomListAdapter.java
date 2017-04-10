package tkrywit.led_app.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import tkrywit.led_app.Model.Room;
import tkrywit.led_app.R;

/**
 * Created by tkryw on 4/8/2017.
 */
public class RoomListAdapter extends RecyclerView.Adapter<RoomListAdapter.RoomViewHolder> {

    private ArrayList<Room> rooms;

    public class RoomViewHolder extends RecyclerView.ViewHolder {

        public TextView roomName, desc;

        public RoomViewHolder(View view) {
            super(view);
            roomName = (TextView) view.findViewById(R.id.roomTitleTextView);
            desc = (TextView) view.findViewById(R.id.roomFixtureTextView);
        }
    }

    public RoomListAdapter(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.room_list_item, parent, false);

        return new RoomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RoomViewHolder holder, int position) {
        Room room = rooms.get(position);
        holder.roomName.setText(room.getName());
        holder.desc.setText(room.getDesc());
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

}