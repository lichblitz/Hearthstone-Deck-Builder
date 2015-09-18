package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Hero;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.holder.HeroViewHolder;

import java.util.ArrayList;

/**
 * Created by lichblitz on 20/08/15.
 */
public class SelectHeroAdapter extends  RecyclerView.Adapter<HeroViewHolder>{

    ArrayList<Hero> classes;

    Context context;


    public SelectHeroAdapter(Context context) {
        this.context = context;
        this.classes = new ArrayList<>();
    }

    /**
     * Adds all items to the adapter
     * @param classes
     */
    public void addAll(@NonNull ArrayList<Hero> classes){
        if(classes == null)
            throw  new NullPointerException("The item cannot be null.");

        this.classes.addAll(classes);
        notifyItemRangeInserted(getItemCount() - 1, classes.size());

    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false);
        return new HeroViewHolder(itemView, context);
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }


    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {
        Hero currentHero = classes.get(position);
        holder.setHeroPortrait(currentHero.getHeroPortrait());
        holder.setHeroClass(currentHero.getHeroClass());
        holder.setHeroId(currentHero.getHeroId());


    }


}
