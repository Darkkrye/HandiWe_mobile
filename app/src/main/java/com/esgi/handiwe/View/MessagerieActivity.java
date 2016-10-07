package com.esgi.handiwe.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.esgi.handiwe.BLL.ConversationMessageManager;
import com.esgi.handiwe.Model.Conversation;
import com.esgi.handiwe.Outils.VariableGlobal;
import com.esgi.handiwe.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessagerieActivity extends AppCompatActivity {

    @BindView(R.id.listConv)
    ListView listConv;

    VariableGlobal vg;
    int idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagerie);
        ButterKnife.bind(this);

        vg  = (VariableGlobal) getApplicationContext();

        idUser = vg.getIdUser();
        Log.d("Test", "BEFORE INSTANCE CMM");
        ConversationMessageManager cmm = new ConversationMessageManager(idUser) {
            @Override
            public void onFinish() {
                Conversation[] conv = new Conversation[getListConversation().size()];
                Log.d("Test", "STP MARCHE !");
                for(int i = 0; i < getListConversation().size(); i++) {
                    conv[i] = getListConversation().get(i);
                    Log.d("TEST", "CONVERSATION : " + i);
                }
                listConv.setAdapter(new RowConvItemAdapter(getApplication(), conv, this));
            }
        };
    }
}
