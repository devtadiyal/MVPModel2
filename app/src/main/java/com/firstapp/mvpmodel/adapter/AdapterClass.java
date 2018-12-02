package com.firstapp.mvpmodel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.firstapp.mvpmodel.R;
import com.firstapp.mvpmodel.responsemodel.TyreListResponse2;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    List<TyreListResponse2> list;
    Context context;

    public AdapterClass(List<TyreListResponse2> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TyreListResponse2 tyreList = list.get(position);
        Glide.with(context)
                .load(tyreList.getImagePath())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_launcher_background)
                        .centerCrop()
                        .override(200, 200)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontTransform())
                .into(holder.civ);

        holder.t11.setText(tyreList.getProductName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder

    {
        private TextView t11;
        ImageView civ;

        public ViewHolder(View itemView) {
            super(itemView);

            t11 = itemView.findViewById(R.id.t1);
            civ = itemView.findViewById(R.id.icon);

        }
    }
}
