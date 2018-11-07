package fauzi.hilmy.rm_characted;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fauzi.hilmy.rm_characted.model.ResultsItem;

import static fauzi.hilmy.rm_characted.DetailActivity.EXTRA_CHARACTER;

public class AdapterCharacter extends RecyclerView.Adapter<AdapterCharacter.MyViewHolder> {
    private Context context;
    private List<ResultsItem> item;

    public AdapterCharacter(Context context, List<ResultsItem> item) {
        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public AdapterCharacter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCharacter.MyViewHolder myViewHolder, final int i) {
        Picasso.get()
                .load(item.get(i).getImage())
                .fit()
                .into(myViewHolder.imgCharacter);
        myViewHolder.txtCharacter.setText(item.get(i).getName());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(context, DetailActivity.class);
                inte.putExtra(EXTRA_CHARACTER, item.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCharacter;
        private TextView txtCharacter;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCharacter = itemView.findViewById(R.id.imgCharacter);
            txtCharacter = itemView.findViewById(R.id.txtCharacter);
        }
    }
}
