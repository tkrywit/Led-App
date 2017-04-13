package tkrywit.led_app.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import tkrywit.led_app.Model.Bulb;
import tkrywit.led_app.R;
import tkrywit.led_app.Utilities.BulbTypeReader;
import tkrywit.led_app.Utilities.StateManager;

/**
 * Created by tkryw on 4/13/2017.
 */


public class AddBulbAdapter extends RecyclerView.Adapter<AddBulbAdapter.BulbViewHolder>  {

    private StateManager stateManager;
    private BulbTypeReader bulbTypeReader;
    ArrayList<Bulb> bulbs;

    public class BulbViewHolder extends RecyclerView.ViewHolder {

        public EditText bulbNumEt;
        public Spinner bulbSpinner;
        public Button addButton;

        public BulbViewHolder(View view) {
            super(view);
            bulbNumEt = (EditText) view.findViewById(R.id.bulbNumberEt);
            bulbSpinner = (Spinner) view.findViewById(R.id.bulbSpinner);
            addButton = (Button) view.findViewById(R.id.addBulbRowButton);
        }
    }

    public AddBulbAdapter() {
        bulbs = new ArrayList<>();
    }

    @Override
    public BulbViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.add_room_list_item, parent, false);

        return new BulbViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BulbViewHolder holder, int position) {
        //holder.setOn...

    }

    @Override
    public int getItemCount() {
        return bulbs.size();
    }

}
