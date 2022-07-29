package com.play1xbet.sports.betting.sports.mvvmart.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.play1xbet.sports.betting.sports.mvvmart.local.response.DataDemo

import com.play1xbet.sports.betting.sports.mvvmart.local.response.ResponseModel_Consigner_Consignee
import com.play1xbet.sports.betting.sports.mvvmart.utils.Events
import com.play1xbet.sports.betting.sports.mvvmart.utils.Result
import com.play1xbet.sports.betting.sports.mvvmart.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumberViewModel @Inject constructor(private val repo: NumberRepo) : ViewModel() {

    private val _fact = MutableLiveData<Events<Result<DataDemo>>>()
    val fact: LiveData<Events<Result<DataDemo>>> = _fact


    fun getNumberFacts() = viewModelScope.launch {
        _fact.postValue(Events(Result(Status.LOADING, null, null)))
        _fact.postValue(Events(repo.getNumberFact()))
    }

}