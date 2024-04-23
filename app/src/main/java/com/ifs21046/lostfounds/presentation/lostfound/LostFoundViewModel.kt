package com.ifs21046.lostfounds.presentation.lostfound

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ifs21046.lostfounds.data.repository.LostFoundRepository
import com.ifs21046.lostfounds.data.remote.MyResult
import com.ifs21046.lostfounds.data.remote.response.DataAddTodoResponse
import com.ifs21046.lostfounds.data.remote.response.DelcomResponse
import com.ifs21046.lostfounds.data.remote.response.DelcomTodoResponse
import com.ifs21046.lostfounds.presentation.ViewModelFactory

class LostFoundViewModel (
    private val lostFoundRepository : LostFoundRepository
) : ViewModel() {

    fun getLostFound(lostfoundId: Int) : LiveData<MyResult<Any>> {
        return lostFoundRepository.getDetail(lostfoundId).asLiveData()
    }

    fun postLostFound(
        title: String,
        description : String,
        status: String,
    ) : LiveData<MyResult<Any>> {
        return lostFoundRepository.postLostFound(
            title,
            description,
            status
        ).asLiveData()
    }

    fun putLostFound(
        lostfoundId: Int,
        title: String,
        description: String,
        status: String,
        isCompleted: Boolean,
    ) : LiveData<MyResult<Any>> {
        return lostFoundRepository.putLostFound(
            lostfoundId,
            title,
            description,
            status,
            isCompleted
        ).asLiveData()
    }

    fun delete(lostfoundId: Int) : LiveData<MyResult<Any>> {
        return lostFoundRepository.delete(lostfoundId).asLiveData()
    }

    companion object {
        @Volatile
        private var INSTANCE: LostFoundViewModel? = null
        fun getInstance (
            lostFoundRepository: LostFoundRepository
        ) : LostFoundViewModel {
            synchronized(ViewModelFactory::class.java) {
                INSTANCE = LostFoundViewModel(
                    lostFoundRepository
                )
            }
            return INSTANCE as LostFoundViewModel
        }
    }
}