package com.esgi.handiwe.BLL;


import android.database.sqlite.SQLiteDatabase;

import com.esgi.handiwe.DAL.ApiService;
import com.esgi.handiwe.Model.Conversation;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pico on 05/10/2016.
 */

public class ConversationManager {

    private ArrayList<Conversation> listConversation = new ArrayList<Conversation>();

    public ConversationManager(int id) {
        apiGetAllconversation(id);
    }

    //region API
    public void apiGetAllconversation(int id) {
        ArrayList<Conversation> listConversation = new ArrayList<Conversation>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<Conversation>> call = apiService.getConversationById(id);
        call.enqueue(new Callback<ArrayList<Conversation>>(){
            @Override
            public void onResponse(Call<ArrayList<Conversation>> call, Response<ArrayList<Conversation>> response) {
                int statusCode = response.code();
                ArrayList<Conversation> conversations = response.body();
                setAllConversation(conversations, statusCode);
            }

            @Override
            public void onFailure(Call<ArrayList<Conversation>> call, Throwable throwable) {
                setAllConversation(new ArrayList<Conversation>(), 0);
            }


        });
    }

    //endregion

    public void setAllConversation(ArrayList<Conversation> list, int statusCode){
        boolean exist=false;
        for (Conversation newConversation:list) {
            for (Conversation item : listConversation) {
                if (item.get_id() == newConversation.get_id()) {
                    exist = true;
                }
            }
            if (!exist) {
                listConversation.add(newConversation);
            }
            exist = false;
        }
    }

    public ArrayList<Conversation> getListConversation() {
        return listConversation;
    }

    public Conversation getConversationById(int id){
        Conversation conversation = new Conversation();
        for (Conversation item:listConversation) {
            if (item.get_id() == id) {
                conversation = item;
            }
        }
        return conversation;
    }


}
