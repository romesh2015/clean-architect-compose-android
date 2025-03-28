package com.romesh.loginsample2025.module
import com.google.android.datatransport.runtime.dagger.Provides
import com.romesh.loginsample2025.authrepo.AuthRepository
import com.romesh.loginsample2025.usecase.LoginUseCase
import com.romesh.loginsample2025.usecase.SignupUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)  // Singleton scope
object UseCaseModule {

    @Provides
    @Singleton
    fun provideLoginUseCase(authRepository: AuthRepository): LoginUseCase {
        return LoginUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideSignupUseCase(authRepository: AuthRepository): SignupUseCase {
        return SignupUseCase(authRepository)
    }
}