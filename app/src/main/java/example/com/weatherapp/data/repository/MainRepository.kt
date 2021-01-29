package example.com.weatherapp.data.repository

import example.com.weatherapp.data.api.ApiHelper
import example.com.weatherapp.data.model.CityList
import example.com.weatherapp.data.model.JsonModel
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {
suspend fun getCities()=apiHelper.getCities()


}