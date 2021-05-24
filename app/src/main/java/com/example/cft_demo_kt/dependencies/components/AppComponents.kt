package com.example.cft_demo_kt.dependencies.components

import android.app.Application
import com.example.cft_demo_kt.dependencies.modules.DatabaseModule
import com.example.cft_demo_kt.dependencies.modules.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RetrofitModule::class,
        DatabaseModule::class
    ]
)
interface AppComponents {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?
        fun build(): AppComponents?
    }
}