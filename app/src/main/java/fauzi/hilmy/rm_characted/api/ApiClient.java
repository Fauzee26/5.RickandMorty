package fauzi.hilmy.rm_characted.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static String BASE_URL = "https://rickandmortyapi.com/api/";

    public static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiInterface getInstance() {
        return setInit().create(ApiInterface.class);
    }
}
