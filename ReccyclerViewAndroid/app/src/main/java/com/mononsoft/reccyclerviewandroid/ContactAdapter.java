package com.mononsoft.reccyclerviewandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    Context context;

    ArrayList<Contact> contactList;

    ClickListener listener;

    public ContactAdapter(Context context, ArrayList<Contact> contactList,ClickListener listener) {
        this.context = context;
        this.contactList = contactList;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.row_layout,parent,
                false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Contact contact = contactList.get(position);
        holder.nameTV.setText(contact.getName());
        holder.phoneNoTV.setText(contact.getPhoneNo());



    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV;
        TextView phoneNoTV;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV=itemView.findViewById(R.id.nameTV);
            phoneNoTV=itemView.findViewById(R.id.phoneNoTV);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                listener.onClick(contactList.get(getAdapterPosition()));
                }
            });

        }
    }

    public void updateData(ArrayList<Contact> contactList){
        this.contactList=contactList;
        notifyDataSetChanged();
    }

    public interface ClickListener{
        public void onClick(Contact contact);
    }
}
