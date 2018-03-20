package teacherit.mbac.ac.th.aeytraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import teacherit.mbac.ac.th.aeytraining.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // saveInstanceState  keep progress
        setContentView(R.layout.activity_main);
        //Add Fragment to Activity
        if(savedInstanceState==null)
        {
           getSupportFragmentManager()
                   .beginTransaction()
                   .add(R.id.contentMainFragment,new MainFragment())
                   .commit();

        }




    }//Main Method

}//Main Class
