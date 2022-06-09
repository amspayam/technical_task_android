package com.sliide.adduser.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sliide.adduser.domain.usecase.AddUserUseCase
import com.sliide.adduser.testdataprovider.AddUserDataProvider
import com.sliide.remote.utils.FailureData
import com.sliide.remote.utils.Resource
import com.sliide.users.rules.MainCoroutineRule
import come.sliide.base.view.onViewData
import come.sliide.base.view.onViewError
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class AddUserViewModelAddUserTest {

    // Rules
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    // Mock
    private val addUserUseCase: AddUserUseCase = mockk()

    // Class for test
    private lateinit var addUserViewModel: AddUserViewModel

    @Before
    fun before() {

        // Mock for init
        coEvery {
            addUserUseCase(AddUserDataProvider.AddUserRequest())
        } returns flow { Resource.Success(AddUserDataProvider.AddUserResponse()) }

        // Initial viewModel
        addUserViewModel = AddUserViewModel(
            addUserUseCase = addUserUseCase
        )

    }

    @Test
    fun `call add user then useCase must execute`() = runBlocking {

        // Given
        coEvery {
            addUserUseCase(AddUserDataProvider.AddUserRequest())
        } returns flow { Resource.Success(AddUserDataProvider.AddUserResponse()) }

        // When
        addUserViewModel.addUser(
            username = "John Doe",
            email = "johndoe@gmail.com",
            gender = "male"
        )

        // Then
        coVerify {
            addUserUseCase(AddUserDataProvider.AddUserRequest())
        }

    }

    @Test
    fun `call add user then success response`() = runBlocking {

        // Given
        coEvery {
            addUserUseCase(AddUserDataProvider.AddUserRequest())
        } returns flow { Resource.Success(AddUserDataProvider.AddUserResponse()) }

        // When
        addUserViewModel.addUser(
            username = "John Doe",
            email = "johndoe@gmail.com",
            gender = "male"
        )

        // Then
        addUserViewModel.addUserStateViewLiveData.observeForever {
            it.onViewData { user ->
                assert(user.id == "2031")
            }
        }

    }

    @Test
    fun `call add user then error response`() = runBlocking {

        // Given
        coEvery {
            addUserUseCase(AddUserDataProvider.AddUserRequest())
        } returns flow {
            Resource.Failure(FailureData(code = 500, message = "Error"))
        }

        // When
        addUserViewModel.addUser(
            username = "John Doe",
            email = "johndoe@gmail.com",
            gender = "male"
        )

        // Then
        addUserViewModel.addUserStateViewLiveData.observeForever {
            it.onViewError { status, messages ->
                assert(messages == "Error")
            }
        }

    }

}