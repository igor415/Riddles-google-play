package com.varivoda.igor.zagonetke.ui.levels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varivoda.igor.domain.interactors.GetAllRiddles
import com.varivoda.igor.domain.interactors.GetPoints
import com.varivoda.igor.domain.interactors.GetRiddlesForCategory
import com.varivoda.igor.domain.model.PointsEntry
import com.varivoda.igor.domain.model.RiddleEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LevelsViewModel (private val getPoints: GetPoints,
                       private val getRiddlesForCategory: GetRiddlesForCategory): ViewModel(){

    var data = MutableLiveData<Pair<List<RiddleEntry>,PointsEntry>>()

    fun getPoints(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            val all = getRiddlesForCategory.invoke(id)
            val points = getPoints.invoke()
            data.postValue(Pair(all, points))
        }
    }
}