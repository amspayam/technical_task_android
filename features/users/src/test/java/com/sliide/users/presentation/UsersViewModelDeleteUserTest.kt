package com.sliide.users.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sliide.remote.network.Resource
import com.sliide.remote.network.RestErrorResponse
import com.sliide.users.domain.usecase.DeleteUserUseCase
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
class UsersViewModelDeleteUserTest {

    // Rules
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    // Mock
    private val usersUseCase: UsersUseCase = mockk()
    private val deleteUserUseCase: DeleteUserUseCase = mockk()

    // Class for test
    private lateinit var usersViewModel: UsersViewModel

    @Before
    fun before() {

        // Mock for init
        coEvery {
            deleteUserUseCase.executeAsync("3064")
        } returns Resource.Success(Unit)

        // Initial viewModel
        usersViewModel = UsersViewModel(
            usersUseCase = usersUseCase,
            deleteUserUseCase = deleteUserUseCase
        )

    }

    @Test
    fun `call delete user then useCase must execute`() = runBlocking {

        // Given
        coEvery {
            deleteUserUseCase.executeAsync("3064")
        } returns Resource.Success(Unit)

        // When
        usersViewModel.deleteUser("3064", "Johne Doe")

        // Then
        coVerify {
            deleteUserUseCase.executeAsync("3064")
        }

    }

    @Test
    fun `call delete user then success response`() = runBlocking {

        // Given
        coEvery {
            deleteUserUseCase.executeAsync("3064")
        } returns Resource.Success(Unit)

        // When
        usersViewModel.deleteUser("3064", "Johne Doe")

        // Then
        usersViewModel.deleteUserStateViewLiveData.observeForever {
            it.onViewData { username ->
                assert(username == "Johne Doe")
            }
        }

    }

    @Test
    fun `call delete user then error response`() = runBlocking {

        // Given
        coEvery {
            deleteUserUseCase.executeAsync("3064")
        } returns Resource.Error(RestErrorResponse(500, "Error"))

        // When
        usersViewModel.deleteUser("3064", "Johne Doe")

        // Then
        usersViewModel.usersStateViewLiveData.observeForever {
            it.onViewError { status, messages ->
                assert(messages == "Error")
            }
        }

    }

}