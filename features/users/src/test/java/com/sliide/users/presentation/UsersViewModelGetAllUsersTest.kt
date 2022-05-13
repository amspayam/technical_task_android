package com.sliide.users.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sliide.remote.network.Resource
import com.sliide.remote.network.RestErrorResponse
import com.sliide.users.domain.usecase.UsersUseCase
import com.sliide.users.rules.MainCoroutineRule
import com.sliide.users.testdataprovider.AllUserDataProvider
import come.sliide.base.view.onViewData
import come.sliide.base.view.onViewError
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class UsersViewModelGetAllUsersTest {

    // Rules
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    // Mock
    private val usersUseCase: UsersUseCase = mockk()

    // Class for test
    private lateinit var usersViewModel: UsersViewModel

    @Before
    fun before() {

        // Mock for init
        coEvery {
            usersUseCase.executeAsync(Unit)
        } returns Resource.Success(AllUserDataProvider.getAllUsers())

        // Initial viewModel
        usersViewModel = UsersViewModel(
            usersUseCase = usersUseCase
        )

    }

    @Test
    fun `get all users in init then useCase must execute`() = runBlocking {

        // Given
        coEvery {
            usersUseCase.executeAsync(Unit)
        } returns Resource.Success(AllUserDataProvider.getAllUsers())

        // When
        usersViewModel.getUsers()

        // Then
        coVerify {
            usersUseCase.executeAsync(Unit)
        }

    }

    @Test
    fun `get all users in init then success response`() = runBlocking {

        // Given
        coEvery {
            usersUseCase.executeAsync(Unit)
        } returns Resource.Success(AllUserDataProvider.getAllUsers())

        // When
        usersViewModel.getUsers()

        // Then
        usersViewModel.usersStateViewLiveData.observeForever {
            it.onViewData { users ->
                assert(users.size == 4)
            }
        }

    }

    @Test
    fun `get all users in init then error response`() = runBlocking {

        // Given
        coEvery {
            usersUseCase.executeAsync(Unit)
        } returns Resource.Error(RestErrorResponse(500, "Error"))

        // When
        usersViewModel.getUsers()

        // Then
        usersViewModel.usersStateViewLiveData.observeForever {
            it.onViewError { status, messages ->
                assert(messages == "Error")
            }
        }

    }

}