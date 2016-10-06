package com.esgi.handiwe.BLL;

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

public class LieuxManager {

    private ArrayList<Conversation> listConversation;

    //region API
    public void apiSetAllconversation() {
        ArrayList<Conversation> listConversation = new ArrayList<Conversation>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<Conversation>> call = apiService.listConversation();
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
        listConversation = list;
    }

    public ArrayList<Conversation> getListConversation() {
        return listConversation;
    }

}
