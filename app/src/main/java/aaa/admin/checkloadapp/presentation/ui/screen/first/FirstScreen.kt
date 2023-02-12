package aaa.admin.checkloadapp.presentation.ui.screen.first

import aaa.admin.checkloadapp.presentation.navigation.Screen
import aaa.admin.checkloadapp.presentation.ui.theme.Typography
import aaa.admin.checkloadapp.presentation.ui.utils.*
import aaa.admin.checkloadapp.presentation.ui.utils.alert.CustomAlert
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: FirstViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {

    val downloadedPercentage by viewModel.downloadedPercentage.observeAsState(initial = 0f)

    val openDialog = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.startThreadGradient()
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.Transparent
    ) { paddingValues ->

        Column(
            modifier = modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            CustomBlockLinearProgressBar(
                textTitle = "Loading...",
                downloadedPercentage = downloadedPercentage,
                gradientColors = listOf(
                    Color(0xFF6ce0c4),
                    Color(0xFF40c7e7),
                    Color(0xFF6ce0c4),
                    Color(0xFF40c7e7)
                ),
                backgroundIndicatorColor = Color.LightGray.copy(alpha = 0.3f),
                radius = 16f,
                indicatorHeight = 24.dp,
                textStyle = Typography.titleMedium
            )
            Spacer(modifier = modifier.height(16.dp))
            BlockTwo()
            Spacer(modifier = modifier.height(16.dp))
            ButtonBig(
                onClick = {
                    openDialog.value = !openDialog.value
                },
                textButton = "Show custom alert"
            )
            Spacer(modifier = modifier.height(16.dp))
            ButtonBig(
                onClick = { navController.navigate(Screen.SecondScreenRoute.route) },
                textButton = "Go to second screen"
            )
        }

        if (openDialog.value) {
            CustomAlert(openDialog = openDialog)
        }


    }


}


@Composable
fun BlockTwo(
    modifier: Modifier = Modifier
) {

    var togglePlaying by remember { mutableStateOf(true) }
    var visible by remember { mutableStateOf(true) }
    val alpha: Float by animateFloatAsState(
        targetValue = if (visible) {
            1f
        } else {
            0f
        },
        animationSpec = tween(
            durationMillis = 1500,
            easing = LinearEasing,
        ),
    )

    Log.e(TAG, "BlockTwo: visible : $visible")
    Log.e(TAG, "BlockTwo: alpha : $alpha")

//    Surface(
//        modifier = modifier.fillMaxWidth(),
//
//    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
        ) {
            Text(text = "Lottie animation")
            Row() {
                Box(
                    modifier = modifier
                        .size(100.dp)
                        .alpha(alpha)
//                        .background(Color.Green)
                ) {
                    CustomLottieAnimation(togglePlaying = togglePlaying)
                }
                Column(
                    modifier = modifier
                ) {
                    ButtonSmall(
                        onClick = { togglePlaying = true },
                        textButton = "Start Animation"
                    )
                    ButtonSmall(
                        onClick = { togglePlaying = false },
                        textButton = "Stop Animation"
                    )
                    ButtonSmall(
                        onClick = { visible = !visible },
                        textButton = "Hide / Show Animation"
                    )
                }
            }
        }
//    }
}


//@Preview(showSystemUi = true)
//@Composable
//private fun PreviewFirstScreen() {
//    FirstScreen(navController = NavHostController(LocalContext.current))
//}