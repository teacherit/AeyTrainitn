package teacherit.mbac.ac.th.aeytraining.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import teacherit.mbac.ac.th.aeytraining.R;

/**
 * Created by It9 on 20/3/2561.
 */

public class MainFragment extends Fragment
    {
        //Step 2
        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            //Step 3
            //  Register Controller
               TextView textView = getView().findViewById(R.id.txtRegister);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//     Step 4                   Replace Fragment
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.contentMainFragment, new RegisterFragment())
                                .addToBackStack(null)
                                .commit();

                    }
                });


        }   // Main Method
//Step 1
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_main,container,false);

            return view;

        }





    } // The end of Main Class
