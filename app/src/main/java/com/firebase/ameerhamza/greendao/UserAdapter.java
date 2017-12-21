package com.firebase.ameerhamza.greendao;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ameer Hamza on 12/18/2017.
 */

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> users;
    Context context;

    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final User user = users.get(position);
        holder.first_name.setText(users.get(position).getFirst_name());
        holder.last_name.setText(users.get(position).getLast_name());
        holder.email.setText(users.get(position).getEmail());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase.getAppDatabase(context).userDao().delete(user);
                removeItem(position);
            }
        });
    }

    public void removeItem(int position) {
        users.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, users.size());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView first_name;
        public TextView last_name;
        public TextView email;
        Button delete;

        public ViewHolder(View itemView) {
            super(itemView);
            first_name = itemView.findViewById(R.id.first_name);
            last_name = itemView.findViewById(R.id.last_name);
            email = itemView.findViewById(R.id.email);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
