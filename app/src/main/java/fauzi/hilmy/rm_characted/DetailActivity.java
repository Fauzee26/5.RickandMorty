package fauzi.hilmy.rm_characted;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import fauzi.hilmy.rm_characted.model.ResultsItem;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.imgDetail)
    ImageView imgDetail;
    @BindView(R.id.txtWins)
    TextView txtWins;
    @BindView(R.id.txtDraw)
    TextView txtDraw;
    ResultsItem item;
    public static String EXTRA_CHARACTER = "character";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        item = getIntent().getParcelableExtra(EXTRA_CHARACTER);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(item.getName());
        Picasso.get()
                .load(item.getImage())
                .fit()
                .into(imgDetail);
        txtWins.setText(item.getStatus());
        txtDraw.setText(item.getSpecies());
    }
}
