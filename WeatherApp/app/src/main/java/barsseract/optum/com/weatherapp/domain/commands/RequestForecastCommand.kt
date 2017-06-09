package barsseract.optum.com.weatherapp.domain.commands

import barsseract.optum.com.weatherapp.data.ForecastRequest
import barsseract.optum.com.weatherapp.domain.mappers.ForeCastDataMapper
import barsseract.optum.com.weatherapp.domain.model.ForecastList

/**
 * Created by mmacpher on 6/9/17.
 */
class RequestForecastCommand(val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForeCastDataMapper().convertFromDataModel(
                forecastRequest.execute()
        )
    }//end execute
}//end class