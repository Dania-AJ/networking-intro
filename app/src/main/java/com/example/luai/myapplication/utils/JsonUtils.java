//Code author: Luai Iwidat 

package com.example.luai.myapplication.utils;

import android.net.Uri;

import com.example.luai.myapplication.models.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.luai.myapplication.utils.NetworkUtils.USERS_BASE_URL;
import static com.example.luai.myapplication.utils.NetworkUtils.getResponseFromHttpUrl;


public class JsonUtils {
    final static String USERS_BASE_URL =
            "https://jsonplaceholder.typicode.com/users";

    public static List<User> getUsers() {
        // TODO (1): Get response data from API
        try {
            URL url = new URL(USERS_BASE_URL);

            String jsonString = getResponseFromHttpUrl(url);
            // TODO (2): Make a JSON array from the response data
             JSONArray jsonArray=new JSONArray(jsonString);
            // TODO (3): Create an array of User (return value)
            List <User> list= new ArrayList<>();
            // TODO (4): Go through the JSON array and fill the users array with id, name, username and email.
           for (int i=0;i<jsonArray.length();i++){
               JSONObject jsonObject =jsonArray.getJSONObject(i);
               String name =jsonObject.getString("name");
               String email =jsonObject.getString("email");
               String username =jsonObject.getString("username");
               int id =jsonObject.getInt("id");
               User user=new User(id,name,username,email);
               list.add(user);

           }
           return list;
        }catch(Exception r){

        }
return null;
    }

}
