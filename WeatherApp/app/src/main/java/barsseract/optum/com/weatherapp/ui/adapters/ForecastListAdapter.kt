package barsseract.optum.com.weatherapp.ui.adapters

import android.support.v7.widget.AppCompatAutoCompleteTextView
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import barsseract.optum.com.weatherapp.domain.model.ForecastList
import java.text.FieldPosition

/**
 * Created by mmacpher on 6/8/17.
 */

class ForecastListAdapter(val weekForecast: ForecastList):
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }//end onCreateViewHolder

    override fun getItemCount(): Int = weekForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]){
            holder.textView.text = "$date - $description - $high/$low"
        }
    }//end onBindViewHolder

    class  ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}//end class
