package tkrywit.led_app.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import tkrywit.led_app.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddProjectDialogFrag.AddProjectListener} interface
 * to handle interaction events.
 */
public class AddProjectDialogFrag extends DialogFragment {

    private AddProjectListener mListener;

    public AddProjectDialogFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_project_dialog, container, false);

        final EditText name = (EditText) view.findViewById(R.id.titleEditText);
        final EditText desc = (EditText) view.findViewById(R.id.descEditText);
        Button accept = (Button) view.findViewById(R.id.projAcceptButton);
        Button cancel = (Button) view.findViewById(R.id.projCancelButton);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onAddProject(name.getText().toString(), desc.getText().toString());
                dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

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
        if (context instanceof AddProjectListener) {
            mListener = (AddProjectListener) context;
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
    public interface AddProjectListener {
        // TODO: Update argument type and name
        void onAddProject(String name, String desc);
    }
}
