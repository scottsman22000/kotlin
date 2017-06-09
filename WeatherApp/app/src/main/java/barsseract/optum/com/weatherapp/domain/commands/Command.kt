package barsseract.optum.com.weatherapp.domain.commands

/**
 * Created by mmacpher on 6/8/17.
 */
interface Command<out T> {
    fun execute(): T
}//end interface