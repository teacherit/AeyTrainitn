package teacherit.mbac.ac.th.aeytraining.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teacherit.mbac.ac.th.aeytraining.R;

/**
 * Created by It9 on 20/3/2561.
 */

public class MainFragment extends Fragment
    {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_main,container,false);

            return view;

        }





    } // The end of Main Class
