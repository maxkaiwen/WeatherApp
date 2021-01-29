package example.com.weatherapp.data.api
import example.com.weatherapp.data.model.CityList
import example.com.weatherapp.data.model.JsonModel
import io.reactivex.Single
import retrofit2.http.GET
private const val appid:String="f0f2c5a52993cd6477bc6d78a348bd68"
private const val apiWe:String="group?id=524901,703448,2643743&appid="
interface ApiService {
    @GET("$apiWe$appid")
   suspend fun getCities(): JsonModel
}