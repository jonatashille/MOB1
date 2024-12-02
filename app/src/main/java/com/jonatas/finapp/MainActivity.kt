package com.jonatas.finapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

val operacoes = arrayListOf<Operacao>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sairButton = findViewById<Button>(R.id.btnSalvar)
        sairButton.setOnClickListener {
            finish()
        }
    }

    fun goCadastro(view: View) {
        //Instancia a Intent
        val intent = Intent(this, CadastroActivity::class.java)
        //Inicia a Activity
        startActivity(intent)
    }

    fun goExtrato(view: View) {
        //Instancia a Intent
        val intent = Intent(this, ExtratoActivity::class.java)
        //Inicia a Activity
        startActivity(intent)

    }
}