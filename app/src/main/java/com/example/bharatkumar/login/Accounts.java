package com.example.bharatkumar.login;


public class Accounts {
    private int _id;
    private String _username;
    private String _userpassword;

    public Accounts()
    {

    }

    public Accounts(String _accountname,String _accountpassword)
    {
        this._username=_accountname;
        this._userpassword=_accountpassword;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_accountname(String _accountname) {
        this._username = _accountname;
    }

    public void set_accountpassword(String _accountpassword) {
        this._userpassword = _accountpassword;
    }

    public int get_id() {
        return _id;
    }

    public String get_accountname() {
        return _username;
    }

    public String get_accountpassword() {
        return _userpassword;
    }


}
