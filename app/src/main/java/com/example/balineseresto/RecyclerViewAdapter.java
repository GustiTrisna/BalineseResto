package com.example.balineseresto;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecycleViewAdapter";

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mHarga = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> mImageNames, ArrayList<String> mImages, ArrayList<String> mHarga) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mHarga = mHarga;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imagesname.setText(mImageNames.get(position));
        holder.harga.setText(mHarga.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on.");
                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, MainActivityPesanan.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mImageNames.get(position));
                intent.putExtra("harga", mHarga.get(position));
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView imagesname;
        TextView harga;
        RelativeLayout parentLayout;
        Button order;
        Button print;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            harga = itemView.findViewById(R.id.image_harga);
            image = itemView.findViewById(R.id.image);
            imagesname = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            print = itemView.findViewById(R.id.print);
            order = itemView.findViewById(R.id.order_pesanan);
        }
    }
}