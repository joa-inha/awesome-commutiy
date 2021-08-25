package com.example.tutorial3;


import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

public class replyAdapter extends RecyclerView.Adapter<replyAdapter.ViewHolder> {

    private List<replyData> mDataset;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView TextView_writer_name;
        public TextView TextView_reply;
        public ImageView ImageView_writer_image;
        public TextView TextView_reply_time;
//        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            TextView_writer_name= view.findViewById(R.id.TextView_writer_name);
            TextView_reply= view.findViewById(R.id.TextView_reply);
            ImageView_writer_image= view.findViewById(R.id.ImageView_writer_image);
            TextView_reply_time = view.findViewById(R.id.TextView_reply_time);
        }


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public replyAdapter(List<replyData> dataSet, Context context) {
        mDataset = dataSet;
        Fresco.initialize(context);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        LinearLayout view = (LinearLayout)LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_reply, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        replyData replydata = mDataset.get(position);
        viewHolder.TextView_reply.setText(replydata.getTextView_reply());
        viewHolder.TextView_writer_name.setText(replydata.getTextView_writer_name());
        viewHolder.TextView_reply_time.setText(replydata.getTextView_reply_time());
        Uri uri = Uri.parse(replydata.getImageView_writer_image());

        viewHolder.ImageView_writer_image.setImageURI(uri);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }
}
