package com.project.aplicacoesmoveis.impacta.listacompras;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.project.aplicacoesmoveis.impacta.listacompras.adapter.ProdutoCustomAdapter;
import com.project.aplicacoesmoveis.impacta.listacompras.handler.DatabaseHandlerProduto;
import com.project.aplicacoesmoveis.impacta.listacompras.model.Produto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CadastroProdutoActivity.class);
                startActivity(i);
            }
        });
    }


    DatabaseHandlerProduto db;

    @Override
    protected void onResume() {
        super.onResume();
        db = new DatabaseHandlerProduto(this);

        ListView listViewProduto;
        listViewProduto = (ListView) findViewById(R.id.listProduto);

        ArrayList<Produto> consulta = (ArrayList<Produto>) db.getAllProdutos();

        ProdutoCustomAdapter rankingCustomAdapter;
        rankingCustomAdapter = new ProdutoCustomAdapter(consulta, this);

        listViewProduto.setAdapter(rankingCustomAdapter);


    }
}
