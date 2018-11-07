package fauzi.hilmy.rm_characted.api;

import fauzi.hilmy.rm_characted.model.ResponseCharacter;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("character")
    Call<ResponseCharacter> getCharacter();
}