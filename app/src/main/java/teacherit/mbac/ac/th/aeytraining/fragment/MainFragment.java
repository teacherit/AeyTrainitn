package teacherit.mbac.ac.th.aeytraining.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import teacherit.mbac.ac.th.aeytraining.R;
import teacherit.mbac.ac.th.aeytraining.utility.GetAllUser;
import teacherit.mbac.ac.th.aeytraining.utility.MyAlert;
import teacherit.mbac.ac.th.aeytraining.utility.MyConstant;

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
            registerController();
              // Login Controller
            loginController();


        }   // Main Method

        private void loginController() {
            Button button = getView().findViewById(R.id.btnLogin);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText userEditText = getView().findViewById(R.id.edtUser);
                    EditText passwordEditText = getView().findViewById(R.id.edtPassword);
                    String userString = userEditText.getText().toString().trim();
                    String passwordString = passwordEditText.getText().toString().trim();
                    if (userString.isEmpty()||passwordString.isEmpty()) {
                        // Have space
                         MyAlert myAlert = new MyAlert(getActivity());
                         myAlert.myDialog(getString(R.string.have_space),
                                 getString((R.string.message_have_space)));

                    }
                    else
                    {
                        // No space
                        try
                        {
                            MyConstant myConstant = new MyConstant();
                            GetAllUser getAllUser = new GetAllUser(getActivity());
                            getAllUser.execute(myConstant.getUrlGetAllUserString());
                            String jsonString = getAllUser.get();
                            Log.d("22March2018","JSON==>" + jsonString);
                            String[] columnUserStrings = myConstant.getLoginString();
                            //Number of column at mySQL in userTABLE
                            String[] loginStrings = new String[columnUserStrings.length];
                            boolean statusBool = true;
                            JSONArray jsonArray = new JSONArray(jsonString);
                            for (int i=0;i<jsonArray.length();i+=1)
                            {
                              JSONObject jsonObject = jsonArray.getJSONObject(i);
                              if(userString.equals(jsonObject.getString(columnUserStrings[2])))
                              {
                                  statusBool = false;
                                  for (int i1=0;i1<columnUserStrings.length;i1+=1)
                                  {
                                      loginStrings[i] = jsonObject.getString(columnUserStrings[i1]);
                                      Log.d("22March2018", "loginString[" + i1 + "] ==>" +loginStrings[i1]);

                                  }
                              }
                              if (statusBool)
                              {
//                                  User False
                                  MyAlert myAlert = new MyAlert(getActivity());
                                  myAlert.myDialog("User False",
                                "No this user in Mysql");
                            }
                              else if(passwordString.equals(loginStrings[3]))
                             {
                                 //  Password True

                                 Toast.makeText(getActivity(), "Welcome" + loginStrings[1],
                                       Toast.LENGTH_SHORT).show();

                              }
                              else
                              {
                                  //Password False
                                  MyAlert myAlert = new MyAlert(getActivity());
                                  myAlert.myDialog("Password False",
                                          "Please try again password false");


                              }

                            }

                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }

                    }


                } //on click
            });
        }

        private void registerController() {
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
        }

        //Step 1
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_main,container,false);

            return view;

        }





    } // The end of Main Class
