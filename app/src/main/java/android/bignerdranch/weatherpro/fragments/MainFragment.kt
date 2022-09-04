package android.bignerdranch.weatherpro.fragments

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.bignerdranch.weatherpro.R
import android.bignerdranch.weatherpro.adapter.VpAdapter
import android.bignerdranch.weatherpro.databinding.ActivityMainBinding
import android.bignerdranch.weatherpro.databinding.FragmentMainBinding
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {
    //список фрагментов
    private val list = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )
    //список с названием табов
    private  val tabList = listOf(
        "ЧАСЫ",
        "ДНИ"
    )
    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentMainBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMainBinding.inflate(inflater, container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()//иначе вылазит ошибка
        init()
    }
    //инициализация фрагментов
    private fun init() = with(binding){
        val adapter = VpAdapter(activity as FragmentActivity, list)
        vpager.adapter = adapter;
        TabLayoutMediator(tvTab, vpager){
            tab, pos -> tab.text = tabList[pos];
        }.attach()
    }

    private fun permissionListener(){//рассматривает разрешение
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()){
            Toast.makeText(activity, "Permission is $it", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkPermission(){
        if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            permissionListener()
            pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment();
    }
}