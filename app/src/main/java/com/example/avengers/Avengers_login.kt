package com.example.avengers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.jar.Attributes

class Avengers_login : AppCompatActivity() , View.OnClickListener {
    override fun onClick(v: View?) {
    }
    lateinit var etEmail: EditText
    lateinit var etPassword : EditText
    lateinit var btnLogin: Button
    val vemail ="rucha@gmail"
    val vpassword= arrayOf("1","2","3")

    lateinit var sharedPreferences:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers_login2)
        title="Log In"

        sharedPreferences=getSharedPreferences(getString(R.string.Avengers_preferences), Context.MODE_PRIVATE)

        var isloggedin = sharedPreferences.getBoolean("isloggedin" ,false)
        setContentView(R.layout.activity_avengers_login2)
        if(isloggedin)
        {
            val intent= Intent(this@Avengers_login,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        sharedPreferences=getSharedPreferences(getString(R.string.Avengers_preferences), Context.MODE_PRIVATE)

        etEmail = findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
           val email= etEmail.text.toString()
            val password= etPassword.text.toString()
            var name="Avenger"
            val intent= Intent(this@Avengers_login,MainActivity::class.java)
            if(email==vemail )
            {
                if (password=="1")
                {
                   name="Iron man"
                    savepreferences(name)
                    intent.putExtra("Name",name)
                    startActivity(intent)
                }
                else if(password=="2")
                {
                    name="captain america"
                    savepreferences(name)
                    intent.putExtra("Name",name)
                    startActivity(intent)
                }
                else if(password=="3")
                {
                    name="The Hulk"
                    savepreferences(name)
                    intent.putExtra("Name",name)
                    startActivity(intent)

                }
                else
                {
                    name="The Avengers"
                    savepreferences(name)
                    intent.putExtra("Name",name)
                    startActivity(intent)
                }


            }
            else {
                Toast.makeText(
                        this@Avengers_login, "Invalid credentials",
                        Toast.LENGTH_LONG).show()

            }
        }

    }

    override fun onPause() {
        super.onPause()
        finish( )
    }

    fun savepreferences(title:String) {

        sharedPreferences.edit().putBoolean("isloggedin",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}