package example.com.weatherapp.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import example.com.weatherapp.data.model.CityList
import example.com.weatherapp.data.model.JsonModel
import example.com.weatherapp.data.repository.MainRepository
import example.com.weatherapp.utils.Resource

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import java.lang.Exception

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {


    fun getCities()= liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try{
            emit(Resource.success(data=mainRepository.getCities()))
        }catch (exception:Exception){
            emit(Resource.error(data = null, msg = exception.message?: "error Occured" ))

        }


    }







    /*private val cities=MutableLiveData<Resource<JsonModel>>()
        //MutableLiveData<Resource<List<CityList>>>()
    private val compositeDisposable=CompositeDisposable()

    init{
        fetchCities()

    }

    private fun fetchCities() {
        cities.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getCities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({cityList-> cities.postValue(
                    Resource.success(cityList)
                )},{throwable->
                    cities.postValue(Resource.error("Error fetchCities ", null))
                })

        )
    }
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getCities(): LiveData<Resource<JsonModel>> {
        return cities
    }
*/
}