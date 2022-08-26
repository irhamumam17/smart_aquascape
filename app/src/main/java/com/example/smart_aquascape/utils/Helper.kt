package com.example.smart_aquascape.utils

import com.example.smart_aquascape.data.model.MonitoringData

class Helper {
    companion object {
        fun <ArrayList> getDataArrayList(): ArrayList {
            var listViewModelArrayList = ArrayList<MonitoringData>()
            listViewModelArrayList.add(MonitoringData(1, "Data 11-17 Februrari", "https://google.co.id"))
            listViewModelArrayList.add(MonitoringData(2, "Data 19-24 Feburari", "https://google.co.id"))
            listViewModelArrayList.add(MonitoringData(3, "Data 25-28 Feburari", "https://google.co.id"))
            return listViewModelArrayList as ArrayList
        }
    }
}