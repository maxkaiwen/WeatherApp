package example.com.weatherapp.data.api

import android.util.Log
import com.rx2androidnetworking.Rx2AndroidNetworking
import example.com.weatherapp.data.model.JsonModel
import io.reactivex.Single

/*class ApiServiceImpl: ApiService {
    private val api:String="f0f2c5a52993cd6477bc6d78a348bd68"
    private val TAG = "INFO: "
    override suspend fun getCities(): Single<JsonModel> {



        Log.i(TAG, "Attempting connection" )
        return Rx2AndroidNetworking
            .get("https://api.openweathermap.org/data/2.5/group?id=524901,703448,2643743&appid=$api")
            .build().getObjectSingle(JsonModel::class.java)
        //Log.i(TAG, "Connected" )
            //.getObjectListSingle(JsonModel::class.java)
    }
}*/