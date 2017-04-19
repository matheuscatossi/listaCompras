package com.project.aplicacoesmoveis.impacta.listacompras.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.project.aplicacoesmoveis.impacta.listacompras.model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus on 18/04/2017.
 */

public class DatabaseHandlerProduto extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "gerenciadorProdutos";

    private static final String TABELA_CONSULTA = "produto";

    int id;
    String nome;
    double valor;
    String categoria;
    boolean favorito;

    private static final String KEY_ID = "id";
    private static final String KEY_NOME = "nome";
    private static final String KEY_VALOR = "valor";
    private static final String KEY_CATEGORIA = "categoria";
    private static final String KEY_FAVORITO = "favorito";

    public DatabaseHandlerProduto(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABELA_CONSULTA + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NOME + " TEXT,"
                + KEY_VALOR + " REAL,"
                + KEY_CATEGORIA + " TEXT,"
                + KEY_FAVORITO + " BOOLEAN )";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CONSULTA);
        onCreate(db);
    }

    public void addProduto(Produto produto) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        //values.put(KEY_ID , produto.getId());
        values.put(KEY_NOME , produto.getNome());
        values.put(KEY_VALOR , produto.getValor());
        values.put(KEY_CATEGORIA , produto.getCategoria());
        values.put(KEY_FAVORITO , produto.isFavorito());

        db.insert(TABELA_CONSULTA, null, values);
        db.close();
    }


    // Getting All Produtos
    public List<Produto> getAllProdutos() {
        List<Produto> produtoList = new ArrayList<Produto>();

        String selectQuery = "SELECT  * FROM " + TABELA_CONSULTA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Produto produto = new Produto();
                produto.setId(Integer.parseInt(cursor.getString(0)));
                produto.setNome(cursor.getString(1));
                produto.setValor(Double.parseDouble(cursor.getString(2)));
                produto.setCategoria(cursor.getString(3));
                produto.setFavorito(Boolean.parseBoolean(cursor.getString(4)));

                produtoList.add(produto);
            } while (cursor.moveToNext());
        }

        return produtoList;
    }
}