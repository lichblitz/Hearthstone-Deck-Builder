package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsdeckbuilder.lichblitz.hsdeckbuilder.R;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.app.BuilderApp;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.AppConstants;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.activity.DeckBuilderActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by lichblitz on 4/09/15.
 */
public  class HeroViewHolder extends RecyclerView.ViewHolder{
    ImageView classPortrait;
    ImageView classSpell;
    TextView heroClass;
    String heroId;
    Context context;


    public HeroViewHolder(View itemView, final Context context) {
        super(itemView);
        this.context = context;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString(AppConstants.BUNDLE_KEY_HEROCLASS, heroClass.getText().toString());

                Intent intent = new Intent(context, DeckBuilderActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        classPortrait = (ImageView) itemView.findViewById(R.id.hero_portrait);
        heroClass = (TextView) itemView.findViewById(R.id.txt_hero_name);


    }

    public void setHeroPortrait(@IntegerRes int portrait){
        Picasso.with(context)
                .load(portrait)
                .into(classPortrait);

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