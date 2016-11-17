package com.cognitioco.drunkster.com.cognitioco.drunkster.view;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cognitioco.drunkster.R;
import com.cognitioco.drunkster.com.cognitioco.drunkster.model.Contact;

import java.util.Collections;
import java.util.List;

/**
 * Created by jfinlay on 11/1/2016.
 *
 * Adapter for RecyclerView used in fragment_contact_display.xml, layout and views defined in contact_layout.xml
 */

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.ContactViewHolder>
{
    List<Contact> mList = Collections.emptyList();
    Context mContext;

    public ContactRecyclerViewAdapter(List<Contact> _list, Context _context)
    {
        mList = _list;
        mContext = _context;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup _parent, int _viewType)
    {

        View view = LayoutInflater.from(_parent.getContext()).inflate(R.layout.contact_layout, _parent, false);
        ContactViewHolder holder = new ContactViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position)
    {
        // Check if list exists
        // TODO: check if List Exists/has 5 entries

        // Fill out contactLayouts

        /*

        holder.contactIndex.setText(position + 1); //Set contact index number to position in list +1.
        String cName = mList.get(position).getName();

        // If no name has been set, contact slot is presumed empty
        if ( cName != "" || cName != "No Contact"  )
        {
            // Contact Exists
            holder.contactName.setText(cName);
            holder.phoneNumber.setText(mList.get(position).getPhoneNumber());
            holder.btnDelete.setVisibility(View.VISIBLE);
            holder.btnAdd.setVisibility(View.INVISIBLE);
        }
        else // Contact is empty
        {
            holder.contactName.setText("No Contact");
            holder.phoneNumber.setText("");
            holder.btnAdd.setVisibility(View.VISIBLE);
            holder.btnDelete.setVisibility(View.INVISIBLE);
        }
        */
    }

    public int getItemCount() { return mList.size();}


    //////////////////////
    //View Holder
    /////////////////////


    public class ContactViewHolder extends RecyclerView.ViewHolder
    {
        View itemView;
        TextView contactIndex;
        TextView contactName;
        TextView phoneNumber;
        //TextView drinkSizeLabel;
        FloatingActionButton btnDelete;
        FloatingActionButton btnAdd;

        public ContactViewHolder(View _itemView)
        {
            super(_itemView);

            itemView = _itemView;
            contactIndex = (TextView) itemView.findViewById(R.id.lbl_contactIndex);
            contactName = (TextView) itemView.findViewById(R.id.lbl_contactName);
            phoneNumber = (TextView) itemView.findViewById(R.id.lbl_phoneNumber);
            btnDelete = (FloatingActionButton) itemView.findViewById(R.id.btn_contactDelete);
            btnAdd = (FloatingActionButton) itemView.findViewById(R.id.btn_contactAdd);
        }
    }

}
