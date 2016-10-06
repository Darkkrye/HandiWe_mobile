package com.esgi.handiwe.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.esgi.handiwe.BLL.VehiculeManager;
import com.esgi.handiwe.Model.Vehicule;
import com.esgi.handiwe.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceActivity extends AppCompatActivity {

    @BindView(R.id.listCars) ListView listCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);

        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("foo");
        your_array_list.add("bar");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
        //        this,
        //        android.R.layout.simple_list_item_1,
        //        your_array_list );

        //listCars.setAdapter(arrayAdapter);

        /*VehiculeManager vh = new VehiculeManager(){
            @Override
            public void onFinish() {
                Log.d("TEST", "TEST TEST TEST");
                Vehicule[] vehi = new Vehicule[getListVehicule().size()];
                for(int i = 0; i < getListVehicule().size(); i++)
                    vehi[i] = getListVehicule().get(i);
                listCars.setAdapter(new RowItemAdapter(getApplication(), vehi));
                Log.d("TEST", getListVehicule().size()+"");
            }
        };*/

//        Vehicule[] vehi = new Vehicule[vh.getListVehicule().size()];
//        for(int i = 0; i < vh.getListVehicule().size(); i++)
//            vehi[i] = vh.getListVehicule().get(i);
//        listCars.setAdapter(new RowItemAdapter(this, vehi));
//        listCars.setAdapter(new RowItemAdapter(this, new Vehicule[] {
//                new Vehicule("Marque 1", "Modele 1", 1111, 1, 2, "dept 1", 10),
//                new Vehicule("Marque 2", "Modele 2", 2222, 2, 3, "dept 2", 20),
//                new Vehicule("Marque 3", "Modele 3", 3333, 3, 4, "dept 3", 30),
//                new Vehicule("Marque 4", "Modele 4", 4444, 4, 5, "dept 4", 40),
//                new Vehicule("Marque 5", "Modele 5", 5555, 5, 6, "dept 5", 50),
//                new Vehicule("Marque 6", "Modele 6", 6666, 6, 7, "dept 6", 60)
//        }));
    }
}
