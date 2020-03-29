package com.estechvmg.esTechAppProyect;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;

class VMGAccountManager{
    private VMGAccount[] accs;
    VMGAccountManager(){
        accs=new VMGAccount[0];
    }
    VMGAccountManager(VMGAccount[] usersList){
        accs=usersList;
    }
    public int getAccountsListSize(){
        return accs.length;
    }
    public boolean createAccount(String user,String pass){
        if(!searchDuplicates(user,pass)){
            addAccount(user,pass);
            return true;
        }else{
            return false;
        }
    }
    public boolean checkLoginCredentials(String user,String pass){
        return searchDuplicates(user,pass);
    }
    private void addAccount(String user,String pass){
        increaseListSize();
        accs[accs.length-1]=new VMGAccount(user,pass);
    }
    private boolean searchDuplicates(String user,String pass){
        for(int a=0;a!=accs.length;a++){
            if(accs[a].isThisAccount(user,pass)){
                return true;
            }
        }
        return false;
    }
    private void increaseListSize(){
        VMGAccount[] newAccs=new VMGAccount[accs.length+1];
        for(int a=0;a!=accs.length;a++){
            newAccs[a]=accs[a];
        }
        accs=newAccs;
    }
}
class VMGAccount{
    private String user,password;
    VMGAccount(String user,String password){
        this.user=user;
        this.password=password;
    }
    public boolean isThisAccount(VMGAccount in){
        return isThisAccount(in.user,in.password);
    }
    public boolean isThisAccount(String user,String password){
        return checkUser(user) && checkPassword(password);
    }
    public boolean setPassword(String oldPassword,String newPassword){
        if(checkPassword(oldPassword)){
            password=newPassword;
            return true;
        }else{
            return false;
        }
    }
    public String getUser() {
        return user;
    }
    private boolean checkPassword(String password){
        return this.password.equals(password);
    }
    private boolean checkUser(String user){
        return this.user.equals(user);
    }
    public boolean setUser(String password,String newUser) {
        if(checkPassword(password)){
            user=newUser;
            return true;
        }else{
            return false;
        }
    }
}
class DialogCreator{
    private static AlertDialog.Builder alert;
    public static AlertDialog.Builder createBasicDialog(Context context, String title, String message){
        alert=new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setCancelable(true);
        return alert;
    }
}
class DummyClass{
    //This class is only a set of empty methods to simulate unimplementable features.
    public static void requestPasswordMailReset(String email){

    }
}