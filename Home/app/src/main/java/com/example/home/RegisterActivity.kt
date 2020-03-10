package com.example.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val bRegistrarse = findViewById(R.id.bRegister) as Button
        val registeredUser = findViewById(R.id.registroUser) as EditText
        val registeredPass = findViewById(R.id.registroPass) as EditText
        val registeredMail = findViewById(R.id.registroMail) as EditText
        var mdatabaseHelper: DatabaseHelper = DatabaseHelper(this)


        /*
        fun AddDataNombre(newEntry:String) {
            val inserData = mdatabaseHelper.addData(newEntry)
            if (inserData) {
             //   toastMessage("Nombre introducido con exito")
            }
            else {
                toastMessage("Error Nombre")
            }
        }
        fun AddDataPass(newEntry:String) {
            val inserData = mdatabaseHelper.addDataPass(newEntry)
            if (inserData) {
                //toastMessage("Pass introducida con exito")
            }
            else {
               // toastMessage("Error Pass")
                toastMessage(newEntry)
            }
        }

        fun AddDataDinero(newEntry:Double) {
            val inserData = mdatabaseHelper.addDataDinero(newEntry)
            if (inserData) {
                //toastMessage("Introducido con exito")
            }
            else {
                toastMessage("Error Dinero")
            }
        }

        fun AddDataInventario(newEntry:String) {
            val inserData = mdatabaseHelper.addDataInventario(newEntry)
            if (inserData) {
                toastMessage("Introducido con exito")
            }
            else {
                toastMessage("Error")
            }
        }*/





        bRegistrarse.setOnClickListener {
            /* var b = Bundle()
             var mylist: ArrayList<Arma> = ArrayList()
             mylist.add(Arma("Karambit","Lore","De aspecto encubierto",1456.74,R.drawable.karambit_lore))
             var inventario: Inventario = Inventario()
             inventario.inventario = mylist
             val usuarioRegristado = Usuario(
                 registeredUser.text.toString(), registeredPass.text.toString(),
                 inventario, 1000.0)
             b.putSerializable("user", usuarioRegristado)*/
            val intent = Intent(this, LoginActivity::class.java)
            //intent.putExtras(b)
            val newUser: String = registeredUser.text.toString()
            val newPass: String = registeredPass.text.toString()
            val newDinero: Double = 1000.0;
            if (registeredUser.length() != 0 && registeredPass.length() != 0) {

                mdatabaseHelper.addData(newUser,newPass,newDinero)
                // AddDataInventario("Inventario")
                registeredUser.setText("")
                registeredPass.setText("")
                registeredMail.setText("")
            } else {
                toastMessage("No puedes dejar espacio en blanco")
            }

            startActivity(intent)
        }
    }

    private fun toastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
