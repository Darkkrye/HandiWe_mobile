package com.esgi.handiwe.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.esgi.handiwe.BLL.ConversationMessageManager;
import com.esgi.handiwe.Model.Conversation;
import com.esgi.handiwe.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nico on 07/10/2016.
 */

public class RowConvItemAdapter extends BaseAdapter {

    Context context;
    Conversation[] data;
    private static LayoutInflater inflater = null;
    ConversationMessageManager cmm;

    public RowConvItemAdapter(Context context, Conversation[] data, ConversationMessageManager cmm) {
        this.context = context;
        this.data = data;
        this.cmm = cmm;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        ViewHolder holder;
        if(view == null) {
            view = inflater.inflate(R.layout.row_conv_adapter, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.bind(data[i]);
        return view;
    }

    public class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.textMess)
        TextView textMess;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void bind(final Conversation c) {
            name.setText("UNKNOW USER");
            textMess.setText("YOUR LAST MESSAGE");
        }
    }
}
