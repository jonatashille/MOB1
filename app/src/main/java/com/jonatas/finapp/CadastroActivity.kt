package com.jonatas.finapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun salvar(view: View) {
        val descricao = findViewById<EditText>(R.id.editTextDesc)
        val valor = findViewById<EditText>(R.id.editTextValor)
        val debito = findViewById<RadioButton>(R.id.radioButtonDebito)

        val operacao = Operacao(descricao.text.toString(), valor.text.toString().toDouble(), if (debito.isChecked) "Débito" else "Crédito")
        operacoes.add(operacao)

        descricao.text = null
        valor.text = null
    }

}