package com.project.aplicacoesmoveis.impacta.listacompras;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.project.aplicacoesmoveis.impacta.listacompras.handler.DatabaseHandlerProduto;
import com.project.aplicacoesmoveis.impacta.listacompras.model.Produto;

public class InfoProdutoActivity extends AppCompatActivity {


    private DatabaseHandlerProduto db;
    TextView nome_produto, valor_produto, categoria_produto, favorito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_produto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Drawable drawableAux = getResources().getDrawable(R.drawable.back);
        Bitmap bitmap = ((BitmapDrawable) drawableAux).getBitmap();
        Drawable drawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 30, 30, true));
        toolbar.setNavigationIcon(drawable);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent i = getIntent();
        String id = i.getStringExtra("id");

        db = new DatabaseHandlerProduto(this);

        Produto produto = db.getProduto(Integer.parseInt(id));

        nome_produto = (TextView) findViewById(R.id.tv_nome_produto);
        valor_produto = (TextView) findViewById(R.id.tv_valor_produto);
        categoria_produto = (TextView) findViewById(R.id.tv_categoria_produto);
        favorito = (TextView) findViewById(R.id.tv_favorito);

        nome_produto.setText(produto.getNome());
        valor_produto.setText("" + produto.getValor());
        categoria_produto.setText("" + produto.getCategoria());
        favorito.setText("" + produto.isFavorito());
    }
}
