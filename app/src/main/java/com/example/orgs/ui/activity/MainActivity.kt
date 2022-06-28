package com.example.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.model.Produto
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Bem vindo(a) ao Orgs!", Toast.LENGTH_SHORT).show()

        setContentView(R.layout.activity_main)

        //val nome = findViewById<TextView>(R.id.nome)
        //nome.text = "Cesta de frutas"

      //  val descricao = findViewById<TextView>(R.id.descricao)
      //  descricao.text = "Laranja, manga e maça"

     //   val valor = findViewById<TextView>(R.id.valor)
     //   valor.text = "19.99"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dao = ProdutosDao()

        val produtoP1 = Produto(nome = "Salada de Frutas",
            descricao = "Maça, Banana e Laranja",
            valor = BigDecimal("25.39"))

        dao.adiciona(produtoP1)

        Log.i("MainActivity", "onCreate: ${dao.buscaTodos()}")
        
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

//        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
//            Produto(nome = "teste", descricao = "teste desc", valor = BigDecimal("19.99")
//            ),
//            Produto(nome = "teste 1", descricao = "teste desc 1", valor = BigDecimal("29.99")
//            ),



 //       ))
        //Pode se configurar por aqui ou pela view
        //recyclerView.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener{
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dao = ProdutosDao()

        Log.i("MainActivity", "onCreate: ${dao.buscaTodos()}")

        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener{
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }


}