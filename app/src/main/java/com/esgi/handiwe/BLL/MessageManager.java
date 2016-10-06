package com.esgi.handiwe.BLL;

import com.esgi.handiwe.DAL.ApiService;
import com.esgi.handiwe.Model.Conversation;
import com.esgi.handiwe.Model.Message;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pico on 05/10/2016.
 */

public class MessageManager {

    private ArrayList<Message> listMessage=new ArrayList<Message>();

    public MessageManager(Conversation conversation){
        apiSetAllMessage(conversation.get_idUtilisateur1(), conversation.get_idUtilisateur2());
    }

    //region API
    public void apiSetAllMessage(int idA,int idB){
        ArrayList<Message> listMessage = new ArrayList<Message>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ArrayList<Message>> call = apiService.getMessageByBothUser(Integer.toString(idA),Integer.toString(idB));
        call.enqueue(new Callback<ArrayList<Message>>(){
            @Override
            public void onResponse(Call<ArrayList<Message>> call, Response<ArrayList<Message>> response) {
                int statusCode = response.code();
                ArrayList<Message> messages = response.body();
                setAllMessage(messages, statusCode);
            }

            @Override
            public void onFailure(Call<ArrayList<Message>> call, Throwable throwable) {
                setAllMessage(new ArrayList<Message>(), 0);
            }


        });
    }

    //endregion

    public void setAllMessage(ArrayList<Message> list, int statusCode){
        listMessage = list;
    }

    public ArrayList<Message> getListMessage() {
        return listMessage;
    }

}
