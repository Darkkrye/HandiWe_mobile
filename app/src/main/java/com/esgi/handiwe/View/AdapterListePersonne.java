package com.esgi.handiwe.View;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.esgi.handiwe.Model.Utilisateur;
import com.esgi.handiwe.Outils.VariableGlobal;
import com.esgi.handiwe.R;
import com.squareup.picasso.Picasso;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.internal.framed.Variant;

/**
 * Created by Pico on 07/10/2016.
 */

public class AdapterListePersonne extends BaseAdapter {

    Context context;
    Utilisateur[] data;
    private static LayoutInflater inflater = null;

    public AdapterListePersonne(Context context, Utilisateur[] data) {

        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.list_adapter_liste_personne, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.bind(data[i]);
        return view;
    }

    public class ViewHolder {
        @BindView(R.id.imageUtilisateur)
        ImageView imgRow;
        @BindView(R.id.adapter_prenom)
        TextView prenom;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void bind(Utilisateur u) {
            prenom.setText(u.get_prenom() + " "+ u.get_nom());

            Picasso.with(context)
                    .load(u.get_image())
                    .resize(100, 100)
                    .centerCrop()
                    .into(imgRow);

        }
    }
}
