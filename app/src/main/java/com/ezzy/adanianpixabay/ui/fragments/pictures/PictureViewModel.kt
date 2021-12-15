package com.ezzy.adanianpixabay.ui.fragments.pictures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezzy.adanianpixabay.common.Resource
import com.ezzy.adanianpixabay.data.remote.dto.ImageDto
import com.ezzy.adanianpixabay.domain.model.Image
import com.ezzy.adanianpixabay.domain.usecase.get_images.GetImagesUseCase
import com.ezzy.adanianpixabay.domain.usecase.search_images.SearchImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PictureViewModel @Inject constructor(
    private val getImagesUseCase: GetImagesUseCase,
    private val searchImagesUseCase: SearchImagesUseCase
): ViewModel() {

    private var _imagesState = MutableStateFlow<Resource<List<Image>>>(Resource.Empty)
    private var _searchImageState = MutableStateFlow<Resource<ImageDto>>(Resource.Empty)
    val imagesState get() = _imagesState
    val searchImagesState get() = _searchImageState

    init {
        searchImages("dog")
    }

    fun getImages() = viewModelScope.launch {
        getImagesUseCase().collect { state->
            when(state) {
                is Resource.Loading -> {
                    _imagesState.value = Resource.loading()
                }
                is Resource.Success -> {
                    _imagesState.value = Resource.success(state.data)
                }
                is Resource.Failure -> {
                    _imagesState.value = Resource.failed(state.errorMessage!!)
                }
            }
        }
    }

    fun searchImages(keyword: String) = viewModelScope.launch {
        searchImagesUseCase(keyword).collect { state->
            when(state) {
                is Resource.Loading -> {
                    _imagesState.value = Resource.loading()
                }
                is Resource.Success -> {
                    _imagesState.value = Resource.success(state.data)
                }
                is Resource.Failure -> {
                    _imagesState.value = Resource.failed(state.errorMessage!!)
                }
            }
        }
    }

}