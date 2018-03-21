package teacherit.mbac.ac.th.aeytraining.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teacherit.mbac.ac.th.aeytraining.MainActivity;
import teacherit.mbac.ac.th.aeytraining.R;

/**
 * Created by It9 on 21/3/
 */

public class RegisterFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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


