package com.cafe.cafeteria

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cafe.cafeteria.Models.Item

class SharedViewModel : ViewModel() {

    private val _menjars = MutableLiveData<List<Item>>(emptyList())
    val plats: LiveData<List<Item>> get() = _menjars

    private val _begudes = MutableLiveData<List<Item>>(emptyList())
    val begudes: LiveData<List<Item>> get() = _begudes

    private val _postres = MutableLiveData<List<Item>>(emptyList())
    val postres: LiveData<List<Item>> get() = _postres

    fun addItemToMenjars(name: String, quantity: Int, price: Number) {
        val updatedList = _menjars.value?.toMutableList() ?: mutableListOf()
        updatedList.add(Item(name, quantity, price))
        _menjars.value = updatedList
    }

    fun addItemToBegudes(name: String, quantity: Int, price: Number) {
        val updatedList = _begudes.value?.toMutableList() ?: mutableListOf()
        updatedList.add(Item(name, quantity, price))
        _begudes.value = updatedList
    }

    fun addItemToPostres(name: String, quantity: Int, price: Number) {
        val updatedList = _postres.value?.toMutableList() ?: mutableListOf()
        updatedList.add(Item(name, quantity, price))
        _postres.value = updatedList
    }

    fun removeItemFromPlats(name: String) {
        val updatedList = _menjars.value?.toMutableList() ?: mutableListOf()
        updatedList.removeIf { it.name == name }
        _menjars.value = updatedList
    }

    fun removeItemFromBegudes(name: String) {
        val updatedList = _begudes.value?.toMutableList() ?: mutableListOf()
        updatedList.removeIf { it.name == name }
        _begudes.value = updatedList
    }

    fun removeItemFromPostres(name: String) {
        val updatedList = _postres.value?.toMutableList() ?: mutableListOf()
        updatedList.removeIf { it.name == name }
        _postres.value = updatedList
    }



}