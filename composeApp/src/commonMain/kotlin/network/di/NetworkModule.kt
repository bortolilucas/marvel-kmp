package network.di

import network.service.apiService
import org.koin.dsl.module

val networkModule = module {
    single { apiService }
}