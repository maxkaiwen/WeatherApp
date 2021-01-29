package example.com.weatherapp.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import example.com.weatherapp.R
import example.com.weatherapp.data.api.ApiHelper

import example.com.weatherapp.data.api.RetrofitBuilder
import example.com.weatherapp.data.model.CityList
import example.com.weatherapp.data.model.JsonModel
import example.com.weatherapp.ui.base.ViewModelFactory
import example.com.weatherapp.ui.main.adapter.MainAdapter
import example.com.weatherapp.ui.main.viewmodel.MainViewModel
import example.com.weatherapp.utils.Status
import io.reactivex.Single
import kotlinx.android.synthetic.main.activity_main.*

class WeatherActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_activity)
        setupUI()
        setupViewModel()
        setupObserver()
    }
    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
    private fun setupObserver() {
        mainViewModel.getCities().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { cities -> renderList(cities)}

                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE

                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(cities: JsonModel) {

        adapter.addData(cities.list)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
                this,
                ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }
}