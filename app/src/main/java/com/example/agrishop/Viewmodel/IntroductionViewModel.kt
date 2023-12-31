package com.example.agrishop.Viewmodel

import android.content.SharedPreferences
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agrishop.R
import com.example.agrishop.Util.Constants.INTRODUCTION_KEY
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class IntroductionViewModel @Inject constructor(
    private val sp:SharedPreferences ,
    private val firebaseAuth: FirebaseAuth
):ViewModel(){
        private val _navigate= MutableStateFlow(0)
    val navigate:StateFlow<Int> = _navigate

companion object{
    const val SHOPPING_ACTIVITY=23
    const val ACCOUNT_OPTION= R.layout.fragment_register_page
}


    init {
        val isButtonClicked=sp.getBoolean(INTRODUCTION_KEY,false)
        val user=firebaseAuth.currentUser

        if(user!==null){
            viewModelScope.launch {
                _navigate.emit(SHOPPING_ACTIVITY)
            }
        }  else if(isButtonClicked){
            viewModelScope.launch {
                _navigate.emit(ACCOUNT_OPTION)
            }

        } else {
Unit
        }
    }

    fun startButtonClick(){
        sp.edit().putBoolean(INTRODUCTION_KEY,true).apply()
    }

}