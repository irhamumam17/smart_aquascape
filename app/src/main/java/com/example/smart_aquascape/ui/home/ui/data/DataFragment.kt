package com.example.smart_aquascape.ui.home.ui.data

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smart_aquascape.adapter.DataAdapter
import com.example.smart_aquascape.data.model.MonitoringData
import com.example.smart_aquascape.databinding.FragmentDataBinding
import com.example.smart_aquascape.utils.Helper

class DataFragment : Fragment() {

    private var _binding: FragmentDataBinding? = null
    private val monitoringDataList =  ArrayList<MonitoringData>()
    private lateinit var dataAdapter: DataAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(DataViewModel::class.java)

        _binding = FragmentDataBinding.inflate(inflater, container, false)
        dataAdapter = DataAdapter(monitoringDataList)
        val root: View = binding.root
        if(_binding != null){
            _binding!!.listView.layoutManager = LinearLayoutManager(activity)
            _binding!!.listView.adapter = dataAdapter
            prepareData()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun prepareData(){
        monitoringDataList.add(MonitoringData(1, "Data 11-17 Feburari", "https://google.co.id"))
        monitoringDataList.add(MonitoringData(2, "Data 19-24 Feburari", "https://google.co.id"))
        monitoringDataList.add(MonitoringData(3, "Data 25-28 Feburari", "https://google.co.id"))
    }
}