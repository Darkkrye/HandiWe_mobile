package com.esgi.handiwe.BLL;


import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

public abstract class ConversationMessageManager {

    private ArrayList<Conversation> listConversation = new ArrayList<Conversation>();
    private ArrayList<Message> listMessage=new ArrayList<Message>();

    public ConversationMessageManager(int idUser) {
        Log.d("Test", "USER : " + idUser);
        apiGetAllconversation(idUser);
        for (Conversation item : listConversation) {
            apiGetAllMessage(item.get_idUtilisateur1(), item.get_idUtilisateur2());
        }
    }

    //region API
    public void apiGetAllconversation(int id) {
        Log.d("Test", "Start Get All Conv");
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
                Log.d("TEST", "AAAAAAAHHHHHHHHH");
                int statusCode = response.code();
                ArrayList<Conversation> conversations = response.body();
                setAllConversation(conversations, statusCode);

                onFinish();
            }

            @Override
            public void onFailure(Call<ArrayList<Conversation>> call, Throwable throwable) {
                Log.d("TEST", "BEEEEEEEEEE");
                setAllConversation(new ArrayList<Conversation>(), 0);
            }


        });
        Log.d("Test", "End Get All Conv");
    }

    public void apiGetAllMessage(int idA,int idB){
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

    public void setAllConversation(ArrayList<Conversation> list, int statusCode){
        listConversation = list;
        /*
        boolean exist=false;
        for (Conversation newConversation : list) {
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
        */
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

    public void setAllMessage(ArrayList<Message> list, int statusCode){
        for (Message item: list) {
            listMessage.add(item);
        }
    }

    public ArrayList<Message> getListMessage() {
        return listMessage;
    }

    public Conversation getConversationByMessage(Message mes){
        return getConversationById(mes.get_idConversation());
    }

    public abstract void onFinish();
}
