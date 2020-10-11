package com.example.payoassignment;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class AllUsersAdapter extends RecyclerView.Adapter<AllUsersAdapter.Holder> {
    Context context;
    ArrayList<DataModel> data;

    public AllUsersAdapter() {
    }

    public AllUsersAdapter(Context context, ArrayList<DataModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AllUsersAdapter.Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_model, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {
        Picasso.get().load(data.get(position).getAvatar()).into(holder.CoverImage);

        final DataModel userid = data.get(position);
        holder.name.setText(data.get(position).getFirst_name() + " " + data.get(position).getLast_name());
        holder.message.setText(data.get(position).getEmail());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" + holder.name.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView name, message;
        RelativeLayout card;
        ImageView CoverImage;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.chat_profile_name);
            message = itemView.findViewById(R.id.chat_profile_message);
            CoverImage = itemView.findViewById(R.id.chat_profile_pic);
            card = itemView.findViewById(R.id.chat_card);
        }
    }
}