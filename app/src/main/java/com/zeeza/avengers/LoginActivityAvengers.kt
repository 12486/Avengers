package com.zeeza.avengers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivityAvengers : AppCompatActivity(){

    lateinit var etMobileNumber : EditText
    lateinit var etPassword : EditText
    lateinit var btnLogin : Button
    lateinit var txtForPass : TextView
    lateinit var txtReg : TextView
    val validMobileNumber = arrayOf("1111111111","2222222222","3333333333","4444444444","5555555555","6666666666","7777777777")
    val validPassword = arrayOf("Tony", "Steve", "Thor", "Wanda", "Bruce", "Natasha", "T'Challa")
    lateinit var sharedPreference : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreference = getSharedPreferences(getString(R.string.preference_file_name) ,Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreference.getBoolean("isLoggedIn",false)
        setContentView(R.layout.avengers_activity_login)
        if (isLoggedIn){
            val intent = Intent(this@LoginActivityAvengers,AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForPass = findViewById(R.id.txtForPass)
        txtReg = findViewById(R.id.txtReg)

        btnLogin.setOnClickListener{
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameOfAvenger = "Avenger"
            val intent = Intent(this@LoginActivityAvengers, AvengersActivity::class.java)

           if((password == validPassword[0]) && (mobileNumber == validMobileNumber[0]) ) {
                nameOfAvenger = "Iron Man"
                savePreferences(nameOfAvenger)
                startActivity(intent)
            } else  if((password == validPassword[1]) && (mobileNumber == validMobileNumber[1]) ) {
               nameOfAvenger = "Captain America"
               savePreferences(nameOfAvenger)
               startActivity(intent)
           } else  if((password == validPassword[2]) && (mobileNumber == validMobileNumber[2]) ) {
               nameOfAvenger = "Thor Thunder"
               savePreferences(nameOfAvenger)
               startActivity(intent)
           } else  if((password == validPassword[3]) && (mobileNumber == validMobileNumber[3]) ) {
               nameOfAvenger = "Scarlet Witch"
               savePreferences(nameOfAvenger)
               startActivity(intent)
           } else  if((password == validPassword[4]) && (mobileNumber == validMobileNumber[4]) ) {
               nameOfAvenger = "THe Hulk"
               savePreferences(nameOfAvenger)
               startActivity(intent)
           } else  if((password == validPassword[5]) && (mobileNumber == validMobileNumber[5]) ) {
               nameOfAvenger = "Black Widow"
               savePreferences(nameOfAvenger)
               startActivity(intent)
           } else  if((password == validPassword[6]) && (mobileNumber == validMobileNumber[6]) ) {
               nameOfAvenger = "Black Panther"
               savePreferences(nameOfAvenger)
               startActivity(intent)
           }
           else {
                Toast.makeText(this@LoginActivityAvengers,"Incorrect Credentials",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun  savePreferences(title : String){
        sharedPreference.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreference.edit().putString("Title",title).apply()
    }
}