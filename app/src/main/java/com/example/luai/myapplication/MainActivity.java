//Code author: Luai Iwidat 

package com.example.luai.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.luai.myapplication.models.User;

import java.util.List;

import static com.example.luai.myapplication.utils.JsonUtils.getUsers;


public class MainActivity extends AppCompatActivity {

    private TextView mTextViewUserWithId1;
    private TextView mTextViewUserWithId5;
    private TextView mTextViewUserWithId7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO (5): Find the 3 text views in the activity and inject them in the variables
          mTextViewUserWithId1 =findViewById(R.id.tv_user1);
          mTextViewUserWithId5 =findViewById(R.id.tv_user2);
          mTextViewUserWithId7 =findViewById(R.id.tv_user3);
        // TODO (7): Execute the AsyncTask and enjoy the show
        MyAsyncTask myAsyncTask=new MyAsyncTask();
        myAsyncTask.execute();

    }

    // TODO (6): Create an AsyncTask class that fetches list of users and then fill the text views with user data (for ids 1, 5 and 7). Use getStringFromUser method
       public class MyAsyncTask extends AsyncTask<Void,Void,List<User>>{



        @Override
        protected List<User> doInBackground(Void... voids) {
            List<User> list=getUsers();
            return list;
        }

        @Override
        protected void onPostExecute(List<User> list) {
            super.onPostExecute(list);
            mTextViewUserWithId1.setText(getStringFromUser(list.get(0)));
            mTextViewUserWithId5.setText(getStringFromUser(list.get(4)));
            mTextViewUserWithId7.setText(getStringFromUser(list.get(6)));

        }
    }

    public static String getStringFromUser(User user) {

        return  user.getId() + "\n"
                + user.getEmail() + "\n"
                + user.getName() + "\n"
                + user.getUsername();

    }

}
