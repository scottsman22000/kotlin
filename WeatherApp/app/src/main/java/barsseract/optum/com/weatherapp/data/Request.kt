package barsseract.optum.com.weatherapp.data

import java.net.URL
import android.util.Log

/**
 * Created by mmacpher on 6/8/17.
 */
class Request(val url: String) {
    fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }//end run
}//end class