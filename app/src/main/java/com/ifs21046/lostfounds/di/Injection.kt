package com.ifs21046.lostfounds.di

import android.content.Context
import com.ifs21046.lostfounds.data.pref.dataStore
import com.ifs21046.lostfounds.data.remote.retrofit.ApiConfig
import com.ifs21046.lostfounds.data.repository.AuthRepository
import com.ifs21046.lostfounds.data.repository.LostFoundRepository
import com.ifs21046.lostfounds.data.repository.UserRepository
import com.ifs21046.lostfounds.data.pref.UserPreference
import com.ifs21046.lostfounds.data.remote.retrofit.IApiService // Import the correct IApiService
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {

    fun provideAuthRepository(context: Context): AuthRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService: IApiService = ApiConfig.getApiService(user.token) // Correct the import
        return AuthRepository.getInstance(pref, apiService)
    }

    fun provideUserRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService: IApiService = ApiConfig.getApiService(user.token) // Correct the import
        return UserRepository.getInstance(apiService)
    }

    fun provideLostFoundRepository(context: Context): LostFoundRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService: IApiService = ApiConfig.getApiService(user.token) // Correct the import
        return LostFoundRepository.getInstance(apiService)
    }

}

private fun ApiConfig.Companion.getApiService(token: String): IApiService {
    TODO("Not yet implemented")
}
