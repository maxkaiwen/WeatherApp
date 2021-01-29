package example.com.weatherapp.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getCities() = apiService.getCities()
}