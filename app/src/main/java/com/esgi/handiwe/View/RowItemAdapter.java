package com.esgi.handiwe.View;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.esgi.handiwe.BLL.VehiculeManager;
import com.esgi.handiwe.Model.Vehicule;
import com.esgi.handiwe.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.esgi.handiwe.R.id.imageView;
import static com.esgi.handiwe.R.id.reserve;

/**
 * Created by nico on 06/10/2016.
 */

public class RowItemAdapter extends BaseAdapter {

    Context context;
    Vehicule[] data;
    private static LayoutInflater inflater = null;
    VehiculeManager vm;

    public RowItemAdapter(Context context, Vehicule[] data, VehiculeManager vm) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        this.vm = vm;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d("TAG 2", "IN " + i);
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.row_adapter, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.bind(data[i]);
        return view;
    }



    public class ViewHolder {
        @BindView(R.id.marque)
        TextView modelCar;
        @BindView(R.id.dept)
        TextView dept;
        @BindView(R.id.places)
        TextView places;
        @BindView(R.id.imgRow)
        ImageView imgRow;
        @BindView(R.id.prix)
        TextView prix;
        @BindView(R.id.reserve)
        Button reserve;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void bind(final Vehicule v) {
            modelCar.setText(v.get_marque() + " " + v.get_modele() + " " + v.get_annee());
            dept.setText("Département : " + v.get_departement());
            places.setText("Places assises : " + v.get_place());
            prix.setText("Prix : " + v.get_prix() + " €");

            Picasso.with(context)
                    .load(v.get_photos())
                    .resize(100, 100)
                    .centerCrop()
                    .into(imgRow);

            reserve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("TEST", "RESERVE " + v.get_departement());
                    vm.apiSetVehiculeReserve(v.get_id());
                }
            });

            Log.d("TEST", modelCar.getText().toString() + dept.getText() + places.getText() + prix.getText());
        }
    }
}
