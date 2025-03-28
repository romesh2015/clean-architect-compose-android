package com.romesh.loginsample2025.module

import com.romesh.loginsample2025.authrepo.AuthRepository
import com.romesh.loginsample2025.remotedatasource.AuthRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
        return AuthRepository(authRemoteDataSource)
    }
}