package android.bignerdranch.weatherpro.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.bignerdranch.weatherpro.R
import android.bignerdranch.weatherpro.adapter.WeatherAdapter
import android.bignerdranch.weatherpro.adapter.WeatherModel
import android.bignerdranch.weatherpro.databinding.FragmentHoursBinding
import androidx.recyclerview.widget.LinearLayoutManager


class HoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() =with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rcView.adapter = adapter
        val list = listOf<WeatherModel>(
            WeatherModel(
                "", "12:00", "Sunny",
                "25°C", "","", "", ""),
            WeatherModel(
                "", "13:00", "Windy",
                "27°C", "","", "", ""),
            WeatherModel(
                "", "14:00", "Rainy",
                "20°C", "","", "", ""),
        )
        adapter.submitList(list)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}