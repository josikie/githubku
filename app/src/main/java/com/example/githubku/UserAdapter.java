package com.example.githubku;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public void setUsers(ArrayList<User> users){
        this.users = users;
    }
    public UserAdapter(Context context, ArrayList<User> users1) {
        this.context = context;
        this.users = users1;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        User user = (User) getItem(i);
        viewHolder.bind(user);

        return itemView;
    }


    private class ViewHolder{
        private TextView tvUsername, tvName;
        private TextView tvFollowers, tvFollowing;
        private ImageView avatar;

        ViewHolder(View view){
            tvUsername = view.findViewById(R.id.username);
            tvName = view.findViewById(R.id.name);
            tvFollowers = view.findViewById(R.id.follower);
            tvFollowing = view.findViewById(R.id.following);
            avatar = view.findViewById(R.id.images_1_2);
        }

        void bind(User user){
            tvUsername.setText(user.getUsername());
            tvName.setText(user.getName());
            tvFollowers.setText(user.getFollowers());
            tvFollowing.setText(user.getFollowing());
            avatar.setImageResource(user.getImage());
        }
    }
}
