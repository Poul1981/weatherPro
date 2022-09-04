package android.bignerdranch.weatherpro

import android.bignerdranch.weatherpro.adapter.WeatherModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>();
    val liveDataList = MutableLiveData<List<WeatherModel>>();
}