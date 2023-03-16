package com.applaunch.jcui.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applaunch.jcui.network.Resources
import com.applaunch.jcui.repository.BGMRepository
import com.applaunch.jcui.ui.model.HomeModel.HomeDataModel
import com.applaunch.jcui.ui.model.MeetModel.MeetDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: BGMRepository
) : ViewModel() {

    private val _home = MutableStateFlow<Resources<List<HomeDataModel>>?>(null)
    val home: StateFlow<Resources<List<HomeDataModel>>?> = _home

    private val _meet = MutableStateFlow<Resources<List<MeetDataModel>>?>(null)
    val meet: StateFlow<Resources<List<MeetDataModel>>?> = _meet

    init {
        viewModelScope.launch {
            //home
            _home.value = Resources.Loading
            _home.value = repository.getHome()

            //meet
            _meet.value = Resources.Loading
            _meet.value = repository.getMeet()

        }
    }
}