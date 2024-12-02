package com.jonatas.finapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExtratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_extrato)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.listView)

        //Criar uma view para header
        val headerView: View = LayoutInflater.from(this).inflate(R.layout.activity_header_view, listView, false)
        listView.addHeaderView(headerView)

        val arrayOperaçoesStrng = arrayListOf<String>()
        arrayOperaçoesStrng.add("Tipo    |   Descrição  |   Valor")

        for (operacao in operacoes) {
            arrayOperaçoesStrng.add(Operacao_ToStr(operacao))
        }

        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, arrayOperaçoesStrng
        )

        listView.adapter = arrayAdapter

    }

    fun Operacao_ToStr(operacao: Operacao): String {
        return "${operacao.tipo} | ${operacao.descricao}  | ${"%.2f".format(operacao.valor)}"
    }
}