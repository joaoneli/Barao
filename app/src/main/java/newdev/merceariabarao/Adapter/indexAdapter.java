package newdev.merceariabarao.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import newdev.merceariabarao.DatabaseRom.view_entity.produtocategoriaEntity;
import newdev.merceariabarao.R;

public class indexAdapter extends ArrayAdapter<produtocategoriaEntity>
{
    private LayoutInflater inflater;

    public indexAdapter(@NonNull Context context, @NonNull List<produtocategoriaEntity> objects)
    {
        super(context, R.layout.item_lista_produtos, objects);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Holder holder;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.item_lista_produtos, null);
            holder = new Holder();
            convertView.setTag(holder);
            holder.tvCodigo = convertView.findViewById(R.id.tvCodigo);
            holder.tvNome_produto = convertView.findViewById(R.id.tvNome_produto);
            holder.tvDesc_produto = convertView.findViewById(R.id.tvDesc_produto);
            holder.tvDesc_cat = convertView.findViewById(R.id.tvDesc_cat);
            holder.tvUm = convertView.findViewById(R.id.tvUm);
            holder.tvQntd = convertView.findViewById(R.id.tvQntd);
            holder.tvQntdall = convertView.findViewById(R.id.tvQntdall);
            holder.tvValcat = convertView.findViewById(R.id.tvValcat);
            holder.tvValtot = convertView.findViewById(R.id.tvValtot);
            holder.tvValallcat = convertView.findViewById(R.id.tvValallcat);
            holder.tvValuni = convertView.findViewById(R.id.tvValuni);

        }
        else
            holder = (Holder) convertView.getTag();
        //
        produtocategoriaEntity item = getItem(position);
        holder.tvCodigo.setText(item.getCodigo().toString());
        holder.tvNome_produto.setText(item.getNome_produto());
        holder.tvDesc_produto.setText(item.getDesc_produto_final());
        holder.tvDesc_cat.setText(item.getDesc_cat());
        holder.tvUm.setText(item.getUm());
        holder.tvQntd.setText(item.getQntd().toString());
        holder.tvQntdall.setText(item.getValtotall()/*!= null ?item.getValtotall().toString():"Teste"*/);
        holder.tvValcat.setText(item.getValcat()!= null? item.getValcat().toString():"Teste");
        holder.tvValtot.setText(item.getValtot().toString());
        holder.tvValallcat.setText(item.getValallcat()!= null?item.getValallcat().toString():"Teste");
        holder.tvValuni.setText(item.getValuni().toString());

        //
        return convertView;
    }

    private class Holder
    {
        public TextView tvCodigo;
        public TextView tvNome_produto;
        public TextView tvDesc_produto;
        public TextView tvDesc_cat;
        public TextView tvUm;
        public TextView tvQntd;
        public TextView tvQntdall;
        public TextView tvValcat;
        public TextView tvValtot;
        public TextView tvValallcat;
        public TextView tvValuni;

    }
}
