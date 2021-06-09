package apiResultados;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResultService {
    @GET("/jokecamp/FootballData/master/EPL%201992%20-%202015/2015-results.json")
    Call<List<Result>> listResult();
}
