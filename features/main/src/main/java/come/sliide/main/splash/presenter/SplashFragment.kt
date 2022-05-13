package come.sliide.main.splash.presenter

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sliie.components.base.BaseFragment
import com.sliie.components.extension.context.getVersionApplication
import come.sliide.main.R
import come.sliide.main.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import viewLifecycleLazy

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel>(R.layout.fragment_splash) {


    private val binding by viewLifecycleLazy { FragmentSplashBinding.bind(requireView()) }
    private val splashViewModel: SplashViewModel by viewModels()

    override fun setupViews() {
        // Show version number to user for support in the future
        binding.versionTextView.text = getString(R.string.version, context?.getVersionApplication())
    }

    override fun setupObserveData() {
        splashViewModel.navigationToMainFragment.observe(viewLifecycleOwner) {
            if (it) {
                navigateToMainFragment()
            }
        }
    }

    private fun navigateToMainFragment() {
        val action = SplashFragmentDirections.actionSplashFragmentToUsersFragment()
        findNavController().navigate(action)
    }

}