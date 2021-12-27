package com.test.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.errorProvider.ErrorProvider
import com.test.home.model.ResponseMostViewed
import com.test.network.HomeData
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeVM @Inject constructor(
    private val data: HomeData,
    private val errorProvider: ErrorProvider
) :  ViewModel() {

    private var _responseGetData = MutableLiveData<com.test.network.Result<ResponseMostViewed>>()

    val responseGetData: LiveData<com.test.network.Result<ResponseMostViewed>>
        get() = _responseGetData



    fun getMostPopular(key: String)
    {
        viewModelScope.launch {
            try {
                _responseGetData.postValue(com.test.network.Result.loading())
                val response = data.GetMostPopularProcess(key)
                _responseGetData.postValue(com.test.network.Result.success(response))
            } catch (exception: Exception) {
                _responseGetData.postValue(
                    com.test.network.Result.error(
                        errorProvider.getErrorMessage(
                            exception
                        )
                    )
                )
            }
        }
    }


}
