package com.ifs21046.lostfounds.data.remote.retrofit

import com.ifs21046.lostfounds.data.repository.UserData

class IApiService {
    fun getMe(): UserData {
        TODO("Not yet implemented")
    }


    fun postLostFound(title: String, description: String, status: String) {

    }

    fun getAll(completed: Int?, me: Int?, status: String?): Any {
        TODO("Not yet implemented")
    }

    fun getDetail(lostFoundId: Int): Any {
        TODO("Not yet implemented")
    }

    fun delete(lostFoundId: Int): Any {
        TODO("Not yet implemented")
    }

    fun putLostFound(
        lostFoundId: Int,
        title: String,
        description: String,
        status: String,
        any: Any,
    ): Any {
        TODO("Not yet implemented")
    }

    fun register(name: String, email: String, password: String): String {
        TODO("Not yet implemented")
    }

    fun login(email: String, password: String): Any {
        TODO("Not yet implemented")
    }

}
