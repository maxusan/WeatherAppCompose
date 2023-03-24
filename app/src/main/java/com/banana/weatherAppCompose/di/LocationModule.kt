package com.banana.weatherAppCompose.di

import com.banana.weatherAppCompose.data.location.DefaultLocationTracker
import com.banana.weatherAppCompose.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LocationModule {

    @Binds
    @Singleton
     fun bindLocationTracker(defaultLocationTracker: DefaultLocationTracker): LocationTracker
}