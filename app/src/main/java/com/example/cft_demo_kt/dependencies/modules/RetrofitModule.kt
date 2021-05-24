package com.example.cft_demo_kt.dependencies.modules

import com.example.cft_demo_kt.data.remote.ApiService
import com.example.cft_demo_kt.dependencies.ApiConstants.BASE_URL
import com.example.cft_demo_kt.dependencies.ApiConstants.READ_TIMEOUT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return okHttpClient
            .addInterceptor(interceptor)
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
}