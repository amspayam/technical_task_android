package come.sliide.main.mainactivity

import android.os.Bundle
import com.sliie.components.base.BaseActivity
import com.sliie.components.base.viewmodel.BaseViewModel
import come.sliide.main.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<BaseViewModel>() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

    }

}