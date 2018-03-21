package teacherit.mbac.ac.th.aeytraining.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import teacherit.mbac.ac.th.aeytraining.MainActivity;
import teacherit.mbac.ac.th.aeytraining.R;
import teacherit.mbac.ac.th.aeytraining.utility.MyAlert;

/**
 * Created by It9 on 21/3/
 */

public class RegisterFragment extends Fragment{

        //Explicit
        private String nameString,userString, passwordString;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createToolbar();
//        Register Controller
        registerController();

    }

    private void registerController() {
        Button button = getView().findViewById(R.id.btnRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               Get value From Edit Text
                EditText nameEditText = getView().findViewById(R.id.edtName);
                EditText userEditText = getView().findViewById(R.id.edtPassword);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);
//                Change EditText to String
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
//                Check Space
                if (nameString.isEmpty()||userString.isEmpty()||passwordString.isEmpty())
                {
//                    Have Space
                    //Create Instance
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog("Have Space", "Please fill all Blank");

                } else
                    {

//                      No Space
                }

            }
        });
    }

    private void createToolbar() {
        // Create Toolbar
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);
        // Create Catch
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        // Setup Title From Project to another Word
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Register");
//        Show Navigator Icon
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
       // return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}//Main Class


