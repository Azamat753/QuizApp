package com.lawlett.quizapp.data.remote;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class QuizApiClient implements IQuizApiClient {
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private QuizApi client = retrofit.create(QuizApi.class);

    @Override
    public void getQuestion(int amount, Integer category, String difficulty,final QuestionCallback callback) {
        Call<QuestionResponse> call = client.getQuestion(10,
                2,"multiple",
                "easy");

        call.enqueue(new Callback<QuestionResponse>() {
            @Override
            public void onResponse(Call<QuestionResponse> call, Response<QuestionResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body().getResults());
                    } else {
                        callback.onFailure(new Exception("Body is empty"));
                    }
                } else {
                    callback.onFailure(new Exception("Response error" + response.code()));
                }
            }
            @Override
            public void onFailure(Call<QuestionResponse> call, Throwable t) {
                callback.onFailure(new Exception(t));

            }
        });
    }

    private interface QuizApi {
        @GET("/api.php")
        Call<QuestionResponse> getQuestion(
                @Query("amount") int amount,
                @Query("category") Integer category,
                @Query("type") String type,
                @Query("difficulty") String difficulty
        );
    }
}
