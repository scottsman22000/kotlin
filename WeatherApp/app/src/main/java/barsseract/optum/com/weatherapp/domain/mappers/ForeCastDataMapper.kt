package barsseract.optum.com.weatherapp.domain.mappers

import barsseract.optum.com.weatherapp.data.ForecastResult
import barsseract.optum.com.weatherapp.data.Forecast
import barsseract.optum.com.weatherapp.domain.model.Forecast as ModelForecast
import barsseract.optum.com.weatherapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by mmacpher on 6/8/17.
 */
class ForeCastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList{
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }//end convertFromDataModel

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
                return list.mapIndexed{i, forecast ->
                    val dt = Calendar.getInstance().timeInMillis +
                            TimeUnit.DAYS.toMillis(
                                    i.toLong()
                            )
                    convertForecastItemToDomain(forecast.copy(dt = dt))
                }
            }//end List

    private fun convertForecastItemToDomain(forecast: Forecast):
            ModelForecast{
                return ModelForecast(convertDate(forecast.dt),
                        forecast.weather[0].description,
                        forecast.temp.max.toInt(), forecast.temp.min.toInt())
            }

    private fun convertDate(date: Long): String{
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                Locale.getDefault())
        return df.format(date)
    }//end convertDate
}//end class