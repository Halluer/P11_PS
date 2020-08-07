package sg.edu.rp.p11ps;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {

    Button btnEditBio;
    TextView tvBio;

    public BioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bio, container, false);

        tvBio = view.findViewById(R.id.tvBio);
        btnEditBio = view.findViewById(R.id.btnEditBio);


        btnEditBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v2 = inflater.inflate(R.layout.dialog_edit, null, false);
                final EditText etText = (EditText) v2.findViewById(R.id.editTextContent);
                etText.setText(tvBio.getText().toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Edit Bio").setView(v2).setPositiveButton("OK", (dialog, id){
                    tvBio.setText(etText.getText().toString());
                })
                .setNegavtiveButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id){
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });


        return view;



    }
}
