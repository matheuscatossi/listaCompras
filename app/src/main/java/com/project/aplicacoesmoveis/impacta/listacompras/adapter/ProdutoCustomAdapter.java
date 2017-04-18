package com.project.aplicacoesmoveis.impacta.listacompras.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.project.aplicacoesmoveis.impacta.listacompras.R;
import com.project.aplicacoesmoveis.impacta.listacompras.model.Produto;

import java.util.ArrayList;

/**
 * Created by Matheus on 18/04/2017.
 */

public class ProdutoCustomAdapter extends ArrayAdapter<Produto> implements View.OnClickListener {

    private ArrayList<Produto> dataSet;
    private Context mContext;

    private static class ViewHolder {
        TextView tv_nome_produto;
        LinearLayout ll_linha;
    }

    public ProdutoCustomAdapter(ArrayList<Produto> data, Context context) {
        super(context, R.layout.row_item_produto, data);

        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Produto produto = (Produto) object;

    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {


        final Produto produto = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_produto, parent, false);

            viewHolder.tv_nome_produto = (TextView) convertView.findViewById(R.id.tv_nome_produto);
            viewHolder.ll_linha = (LinearLayout) convertView.findViewById(R.id.ll_linha);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.tv_nome_produto.setText("" + produto.getNome());

        viewHolder.ll_linha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                    Intent i = new Intent(mContext, InfoReuniaoActivity.class);
//
//                    i.putExtra("Id", String.valueOf(produto.getId()));
//
//                    mContext.startActivity(i);
            }
        });

        return convertView;
    }
}

