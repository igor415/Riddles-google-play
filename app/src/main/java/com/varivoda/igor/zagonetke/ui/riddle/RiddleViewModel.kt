package com.varivoda.igor.zagonetke.ui.riddle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varivoda.igor.domain.interactors.*
import com.varivoda.igor.domain.model.RiddleEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RiddleViewModel(private val getAllRiddles: GetAllRiddles,
                      private val getPoints: GetPoints,
                      private val insertPoints: InsertPoints,
                      private val resetPoints: ResetPoints,
                      private val subtractFromScore: SubtractFromScore) : ViewModel(){

    var allRiddles = MutableLiveData<List<RiddleEntry>>()
    var scoreValue = MutableLiveData<Int>()

    fun getAllRiddles(){
        viewModelScope.launch(Dispatchers.IO) {
            allRiddles.postValue(getAllRiddles.invoke())
        }
    }

    fun getScore() {
        viewModelScope.launch(Dispatchers.IO) {
            scoreValue.postValue(getPoints.invoke().value)
        }
    }

    fun subtractFromScore(){
        viewModelScope.launch(Dispatchers.IO) {
            subtractFromScore.invoke()
            getScore()
        }
    }

    fun updateScoreForUser(questionId: Int, numberOfPointsForCorrectAnswer: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            insertPoints.invoke(questionId, numberOfPointsForCorrectAnswer)
            getScore()
        }
    }

    fun resetStats() {
        viewModelScope.launch(Dispatchers.IO) {
            resetPoints.invoke()
            getScore()
        }
    }
}