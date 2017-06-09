package barsseract.optum.com.weatherapp.domain.model


/**
 * Created by mmacpher on 6/8/17.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>){
    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int):
            Forecast = dailyForecast[position]
}//end class

data class Forecast(val date: String, val description: String, val high: Int, val low: Int)
