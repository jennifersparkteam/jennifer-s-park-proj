package com.example.jennifers.jenniferspark;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jennifer's Team on 10/18/2017.
 */

public class ClientStorage {
    SharedPreferences storage;

    /**
     * Constructor of client storage
     * @param context the context request storage
     */
    public ClientStorage(Context context){
        storage = context.getSharedPreferences("Information",0);
    }

    /**
     * This method store current user's information when they login into the system
     * and set login status on
     * @param user user who login into the system
     */
    public void login(User user){
        SharedPreferences.Editor s = storage.edit();
        s.putString("Username",user.getName());
        s.putString("Email",user.getEmail());
        s.putInt("Admin",user.getIsAdmin());
        s.putBoolean("isLogin",true);
        s.commit();
    }
    /**
     * This method return current user
     * @return Current user
     * */
    public User getCurrentUser(){
        return new User(storage.getString("Username",""),storage.getString("Email",""),storage.getInt("Admin",0));
    }

    /**
     * This method set login status off when user logout
     */
    public void logout(){
        SharedPreferences.Editor s = storage.edit();
        s.putBoolean("isLogin",false);
        s.commit();
    }

    /**
     * The method return current login status
     * @return login status
     */
    public boolean getLoginStatus(){
        return storage.getBoolean("isLogin",false);
    }

    /**
     * This method reset all information to default value
     */
    public void clear(){
        SharedPreferences.Editor s = storage.edit();
        s.clear();
        s.commit();
    }
}
