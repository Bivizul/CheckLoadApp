package aaa.admin.checkloadapp.presentation.ui

import aaa.admin.checkloadapp.presentation.navigation.AppNavHost
import aaa.admin.checkloadapp.presentation.ui.theme.CheckLoadAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var factory: SecondViewModelFactory.Factory
//    private val secondViewModel: SecondViewModel by viewModels { factory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        appComponent.inject(this)

        setContent {
            CheckLoadAppTheme {
//                val secondViewModel = hiltViewModel<SecondViewModel>()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                    color = Color.LightGray
                ) {
                    AppNavHost(
//                        secondViewModel = secondViewModel
                    )
                }
            }
        }
    }
}
