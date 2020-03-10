package com.example.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    var usuarioRegistrado: Usuario = Usuario()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        /*
        var b: Bundle = intent.extras as Bundle
        if (b != null) {
            if (b.containsKey("user")) {
                usuarioRegistrado = b.getSerializable("user") as Usuario
            }
            }

            */

        val bEnviar = findViewById(R.id.bLogin) as Button
        val user = findViewById(R.id.tuUser) as EditText
        val pass = findViewById(R.id.tuPass) as EditText

        bEnviar.setOnClickListener {
            val dbh = DatabaseHelper(this)
            usuarioRegistrado = dbh.comprobarUsuario(user.text.toString(), pass.text.toString())
            if (user.text.toString().equals(usuarioRegistrado.user) && pass.text.toString().equals(
                    usuarioRegistrado.pass
                )
            ) {
                var bun = Bundle()
                val user = usuarioRegistrado
                bun.putSerializable("user2", user)
                val it = Intent(this, PantallaSelectCase::class.java)
                it.putExtras(bun)
                startActivity(it);

            } else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


