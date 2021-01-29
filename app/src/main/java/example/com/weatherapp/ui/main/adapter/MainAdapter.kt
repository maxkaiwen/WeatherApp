package example.com.weatherapp.ui.main.adapter
import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import example.com.weatherapp.R
import example.com.weatherapp.data.model.CityList
import example.com.weatherapp.ui.main.view.MainActivity
import example.com.weatherapp.ui.main.view.WeatherActivity
import kotlinx.android.synthetic.main.item_layout.view.*


class MainAdapter(private val cityList:ArrayList<CityList>):
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    /*fun showWeather(view: View){
        val intent= Intent(, WeatherActivity::class.java)
        startActivity(intent)
    }*/
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(cityList: CityList){

            itemView.textViewCityName.text= cityList.name
                itemView.setOnClickListener() { view ->
                    val intent = Intent(itemView.context, WeatherActivity::class.java)
                    itemView.context.startActivity( intent)

                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = cityList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int){
       holder.bind(cityList[position])
        
    }





    fun addData(list: List<CityList>) {
        cityList.addAll(list)
    }
}