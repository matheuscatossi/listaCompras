package com.project.aplicacoesmoveis.impacta.listacompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.project.aplicacoesmoveis.impacta.listacompras.handler.DatabaseHandlerProduto;
import com.project.aplicacoesmoveis.impacta.listacompras.model.Produto;

public class CadastroProdutoActivity extends AppCompatActivity {

    private EditText nomeProduto, valorProduto, categoriaProduto;
    private CheckBox favorito;
    private Button cadastrar;
    private DatabaseHandlerProduto db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        nomeProduto = (EditText) findViewById(R.id.et_nome_produto);
        valorProduto = (EditText) findViewById(R.id.et_valor_produto);
        categoriaProduto = (EditText) findViewById(R.id.et_categoria_produto);
        favorito = (CheckBox) findViewById(R.id.cb_favorito);
        cadastrar = (Button) findViewById(R.id.btn_cadastrar);

        db = new DatabaseHandlerProduto(this);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addProduto(new Produto(nomeProduto.getText().toString(),Double.parseDouble(valorProduto.getText().toString()), categoriaProduto.getText().toString(), favorito.isChecked()));
                finish();
            }
        });

    }

}
