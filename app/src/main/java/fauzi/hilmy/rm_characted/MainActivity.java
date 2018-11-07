package fauzi.hilmy.rm_characted;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fauzi.hilmy.rm_characted.api.ApiClient;
import fauzi.hilmy.rm_characted.api.ApiInterface;
import fauzi.hilmy.rm_characted.model.ResponseCharacter;
import fauzi.hilmy.rm_characted.model.ResultsItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerCharacter)
    RecyclerView recyclerCharacter;
    private List<ResultsItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerCharacter.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        getCharacter();
    }

    private void getCharacter() {
        ApiInterface apiInterface = ApiClient.getInstance();
        Call<ResponseCharacter> characterCall = apiInterface.getCharacter();
        characterCall.enqueue(new Callback<ResponseCharacter>() {
            @Override
            public void onResponse(Call<ResponseCharacter> call, Response<ResponseCharacter> response) {
                if (response.isSuccessful()) {
                    items = response.body().getResults();
                    recyclerCharacter.setAdapter(new AdapterCharacter(MainActivity.this, items));
                }
            }

            @Override
            public void onFailure(Call<ResponseCharacter> call, Throwable t) {

            }
        });

    }
}
