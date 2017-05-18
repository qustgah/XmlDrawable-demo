package com.example.apple.xmldrawable;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by apple on 2017/5/18.
 */

public class DrawableExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    int[] stringResId = {R.string.bitmap_disable,R.string.bitmap_repeat,R.string.bitmap_clamp,R.string.bitmap_mirror,
    R.string.shape_line,R.string.shape_line_dash,R.string.shape_rect,R.string.shape_rect_dash,
            R.string.gradient_line,R.string.gradient_radial,R.string.gradient_sweep,
            R.string.layer_list,R.string.state_list,R.string.level_list,R.string.transition,
            R.string.inset,R.string.scale,R.string.clip

    };
    int[] drawableId = {R.drawable.drawable_bitmap_disable,R.drawable.drawable_bitmap_repeat,R.drawable.drawable_bitmap_clamp,R.drawable.drawable_bitmap_mirror,
    R.drawable.drawable_shape_line,R.drawable.drawable_shape_line_dash,R.drawable.drawable_shape_rect,R.drawable.drawable_shape_rect_dash,
    R.drawable.drawable_shape_gradient_line,R.drawable.drawable_shape_gradient_radial,R.drawable.drawable_shape_gradient_sweep,
    R.drawable.drawable_layerlist,R.drawable.drawable_statelist,R.drawable.drawable_levellist,R.drawable.drawable_transition,
    R.drawable.drawable_inset,R.drawable.drawable_scale,R.drawable.drawable_clip

    };

    boolean[] isBackGround = {
        true,true,true,true,
            true,true,true,true,
            true,true,true,
            true,true,false,true,
            true,false,false

    };


    public DrawableExampleAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_example, parent, false);
        DrawableViewHolder holder = new DrawableViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DrawableViewHolder viewHolder = (DrawableViewHolder) holder;
        viewHolder.name.setText(stringResId[position]);
        if (isBackGround[position]){
            viewHolder.imageView.setBackgroundResource(drawableId[position]);
            viewHolder.imageView.setImageDrawable(null);
        }else {
            viewHolder.imageView.setImageResource(drawableId[position]);
            viewHolder.imageView.setBackground(null);
        }
        viewHolder.imageView.setImageLevel(5);
        if (stringResId[position] == R.string.transition){
            TransitionDrawable transitionDrawable = (TransitionDrawable) viewHolder.imageView.getBackground();
            transitionDrawable.startTransition(2000);
        }else if (stringResId[position] == R.string.clip){
            viewHolder.imageView.setImageLevel(5000);
        }else if (stringResId[position] == R.string.shape_line_dash){
            viewHolder.imageView.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        }




    }

    @Override
    public int getItemCount() {
        return stringResId.length;
    }

    static class DrawableViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView imageView;

        public DrawableViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }
}
