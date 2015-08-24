package com.hsdeckbuilder.lichblitz.hsdeckbuilder.ui.fragment;

import android.content.Context;
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
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Card;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.domain.Hero;
import com.hsdeckbuilder.lichblitz.hsdeckbuilder.io.HearthstoneApiAdapter;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by lichblitz on 20/08/15.
 */
public class SelectHeroAdapter extends  RecyclerView.Adapter<SelectHeroAdapter.ClassViewHolder>{

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
        notifyItemRangeInserted(getItemCount() -1, classes.size());

    }

    @Override
    public ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_class, parent, false);
        return new ClassViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }


    @Override
    public void onBindViewHolder(ClassViewHolder holder, int position) {
        Hero currentHero = classes.get(position);
        holder.setHeroPortrait(currentHero.getHeroPortrait());
        holder.setHeroPower(currentHero.getPowerImage());
        holder.setHeroClass(currentHero.getHeroClass());
        holder.setHeroId(currentHero.getHeroId());


    }

    public  class ClassViewHolder extends RecyclerView.ViewHolder{
        ImageView classPortrait;
        ImageView classSpell;
        TextView heroClass;
        String heroId;

        public ClassViewHolder(View itemView) {
            super(itemView);

            classSpell = (ImageView) itemView.findViewById(R.id.class_spell);
            classPortrait = (ImageView) itemView.findViewById(R.id.class_portrait);
            heroClass = (TextView) itemView.findViewById(R.id.txt_hero_name);
            classSpell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    HearthstoneApiAdapter.getApiService().getSigleCard(heroId, new Callback<List<Card>>() {
                        @Override
                        public void success(List<Card> cards, Response response) {
                            Log.d(SelectHeroAdapter.class.getName(), cards.get(0).getImg());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Log.d(SelectHeroAdapter.class.getName(), "FAIL");
                        }
                    });

                }
            });

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
