package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Hero;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.activity.DeckBuilderActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lichblitz on 20/08/15.
 */
public class SelectHeroAdapter extends  RecyclerView.Adapter<SelectHeroAdapter.HeroViewHolder>{

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
        return new HeroViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }


    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {
        Hero currentHero = classes.get(position);
        holder.setHeroPortrait(currentHero.getHeroPortrait());
        //holder.setHeroPower(currentHero.getPowerImage());
        holder.setHeroClass(currentHero.getHeroClass());
        holder.setHeroId(currentHero.getHeroId());


    }

    public  class HeroViewHolder extends RecyclerView.ViewHolder{
        ImageView classPortrait;
        ImageView classSpell;
        TextView heroClass;
        String heroId;

        public HeroViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("HERO", heroClass.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putString(AppConstants.BUNDLE_KEY_HEROCLASS, heroClass.getText().toString());

                    Intent intent = new Intent(context, DeckBuilderActivity.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
            //classSpell = (ImageView) itemView.findViewById(R.id.hero_spell);
            classPortrait = (ImageView) itemView.findViewById(R.id.hero_portrait);
            heroClass = (TextView) itemView.findViewById(R.id.txt_hero_name);


        }

        public void setHeroPortrait(@IntegerRes int portrait){
            Picasso.with(context)
                    .load(portrait)
                    .into(classPortrait);

        }

        public void setHeroPower(@IntegerRes int power){
            Picasso.with(context)
                    .load(power)
                    .into(classSpell);

        }

        public void setHeroClass(String heroClass){
            this.heroClass.setText(heroClass);
        }

        public void setHeroId(String heroId){
            this.heroId=heroId;
        }

        public void setDefaulClassPortrait(){
            Picasso.with(context)
                    .load(R.drawable.default_portrait);
        }






    }
}
