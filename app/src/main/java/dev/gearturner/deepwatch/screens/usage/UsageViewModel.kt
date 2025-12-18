package dev.gearturner.deepwatch.screens.usage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsageViewModel(application: Application) : AndroidViewModel(application) {

    private val _usageList = MutableStateFlow<List<AppUsage>>(emptyList())
    val usageList: StateFlow<List<AppUsage>> = _usageList

    fun loadUsage() {
        viewModelScope.launch {
            _usageList.value = getUsageStats(getApplication())
        }
    }
}