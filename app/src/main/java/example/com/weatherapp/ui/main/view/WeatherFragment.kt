package example.com.weatherapp.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import example.com.weatherapp.R

class WeatherFragment:Fragment() {

    companion object{
        fun newInstance():WeatherFragment{
            return WeatherFragment()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.weather_framgent,container,false)
    }
}