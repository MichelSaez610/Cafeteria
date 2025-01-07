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

    private val _totalPrice = MutableLiveData<Double>(0.0)
    val totalPrice: LiveData<Double> get() = _totalPrice

    fun addItemToMenjars(name: String, quantity: Int, price: Number, image: Int) {
        val updatedList = _menjars.value?.toMutableList() ?: mutableListOf()
        updatedList.add(Item(name, quantity, price, image))
        _menjars.value = updatedList
    }

    fun addItemToBegudes(name: String, quantity: Int, price: Number, image: Int) {
        val updatedList = _begudes.value?.toMutableList() ?: mutableListOf()
        updatedList.add(Item(name, quantity, price, image))
        _begudes.value = updatedList
    }

    fun addItemToPostres(name: String, quantity: Int, price: Number, image: Int) {
        val updatedList = _postres.value?.toMutableList() ?: mutableListOf()
        updatedList.add(Item(name, quantity, price, image))
        _postres.value = updatedList
    }

    fun removeItemFromPlats(name: String) {
        val updatedList = _menjars.value?.toMutableList() ?: mutableListOf()
        val index = updatedList.indexOfFirst { it.name == name }
        if (index != -1) updatedList.removeAt(index)
        _menjars.value = updatedList
    }

    fun removeItemFromBegudes(name: String) {
        val updatedList = _begudes.value?.toMutableList() ?: mutableListOf()
        val index = updatedList.indexOfFirst { it.name == name }
        if (index != -1) updatedList.removeAt(index)
        _begudes.value = updatedList
    }

    fun removeItemFromPostres(name: String) {
        val updatedList = _postres.value?.toMutableList() ?: mutableListOf()
        val index = updatedList.indexOfFirst { it.name == name }
        if (index != -1) updatedList.removeAt(index)
        _postres.value = updatedList
    }

    fun removeAllItems() {
        _menjars.value = emptyList()
        _begudes.value = emptyList()
        _postres.value = emptyList()
        _totalPrice.value = 0.0
    }

    fun updateTotal(price: Double) {
        _totalPrice.value = _totalPrice.value?.plus(price)
    }




}