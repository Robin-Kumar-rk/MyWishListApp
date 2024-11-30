package com.example.mywishlistapp


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
): ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChange(newTitle: String) {
        wishTitleState = newTitle
    }

    fun onWishDescriptionChange(newDescription: String) {
        wishDescriptionState = newDescription
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWish()
        }
    }

    fun addAWish(wish: Wish) {
        viewModelScope.launch(
            Dispatchers.IO
        ) {
            wishRepository.addAWish(wish)
        }
    }

    fun getAWishById(id: Long): Flow<Wish> {
        return wishRepository.getAWishById(id)
    }

    fun updateAWish(wish: Wish) {
        viewModelScope.launch(
            Dispatchers.IO
        ) {
            wishRepository.updateAWish(wish)
        }
    }

    fun deleteAWish(wish: Wish) {
        viewModelScope.launch(
            Dispatchers.IO
        ) {
            wishRepository.deleteAWish(wish)
        }
    }

}