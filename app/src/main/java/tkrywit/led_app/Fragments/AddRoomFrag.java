package tkrywit.led_app.Fragments;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import tkrywit.led_app.Adapters.AddBulbAdapter;
import tkrywit.led_app.R;

/**
 * Created by tkryw on 4/13/2017.
 */

public class AddRoomFrag extends Fragment {

    private AddRoomListener mListener;

    public AddRoomFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_room_dialog, container, false);

        EditText title = (EditText) view.findViewById(R.id.newRoomTitle);
        EditText desc = (EditText) view.findViewById(R.id.newRoomDesc);
        Button accept = (Button) view.findViewById(R.id.addRoomAccept);
        Button cencal = (Button) view.findViewById(R.id.addRoomCancel);
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.addRoomRecycler);

        recycler.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        AddBulbAdapter adapter = new AddBulbAdapter();
        recycler.setAdapter(adapter);

        return view;
    }

   /*
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    */

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AddRoomListener) {
            mListener = (AddRoomFrag.AddRoomListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface AddRoomListener {
        // TODO: Update argument type and name
        void onAddRoom(String name, String desc);
    }
}
