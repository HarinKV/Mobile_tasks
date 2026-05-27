package ci.nsu.mobile.main.ui.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import ci.nsu.mobile.main.data.database.DepositDatabase
import ci.nsu.mobile.main.data.database.DepositEntity
import ci.nsu.mobile.main.data.repository.DepositRepository

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DepositRepository
    val calculations: LiveData<List<DepositEntity>>

    init {
        val dao = DepositDatabase.getDatabase(application).depositDao()
        repository = DepositRepository(dao)
        calculations = repository.getAllCalculations().asLiveData()
    }
}