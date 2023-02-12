package aaa.admin.checkloadapp.presentation.ui.screen.second

import aaa.admin.checkloadapp.R
import aaa.admin.checkloadapp.domain.Constants.SECONDS_TIMER
import aaa.admin.checkloadapp.presentation.ui.theme.Typography
import aaa.admin.checkloadapp.presentation.ui.utils.ButtonBig
import aaa.admin.checkloadapp.presentation.ui.utils.CardRating
import aaa.admin.checkloadapp.presentation.ui.utils.CustomBlockLinearProgressBar
import aaa.admin.checkloadapp.presentation.ui.utils.ReverseCounter
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    secondViewModel: SecondViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier,
//    secondViewModel: SecondViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {

    val randomDownloadedPercentage1 by secondViewModel.randomDownloadedPercentage1.observeAsState(
        initial = 0f
    )
    val randomDownloadedPercentage2 by secondViewModel.randomDownloadedPercentage2.observeAsState(
        initial = 0f
    )
    val timer by secondViewModel.reverseCounter.observeAsState(0L)
//    val raitings by secondViewModel.listRate.observeAsState()

//    Log.e(TAG, "SecondScreen: randomDownloadedPercentage1 : $randomDownloadedPercentage1")
//    Log.e(TAG, "SecondScreen: randomDownloadedPercentage2 : $randomDownloadedPercentage2")

//    Log.e(TAG, "SecondScreen: raitings : $raitings")

    LaunchedEffect(Unit) {
        secondViewModel.startThreadGradient1()
        secondViewModel.startThreadGradient2()
        secondViewModel.startReverseCounter(SECONDS_TIMER * 1000L)
//        secondViewModel.getListRate()
    }

    Scaffold(
        modifier = modifier.padding(16.dp),
        containerColor = Color.Transparent
    ) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            Image(
                painter = painterResource(id = R.drawable.arrow_back_24),
                contentDescription = "button back",
                modifier = modifier
                    .size(24.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            CustomBlockLinearProgressBar(
                textTitle = "Random value",
                downloadedPercentage = randomDownloadedPercentage1,
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
            CustomBlockLinearProgressBar(
                textTitle = "Random value 2",
                downloadedPercentage = randomDownloadedPercentage2,
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
            ButtonBig(
                onClick = {
                    secondViewModel.clearAndRestartProgressBars()
                },
                textButton = "Randomize values"
            )
            ReverseCounter(
                timer = timer
            )
//            CustomBlockLinearProgressBar(
//                textTitle = "Load Data from server",
////                textPercent = "60%"
//            )
            CardRating()
            LazyRow {
//                CardRating()
            }
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//private fun PreviewSecondScreen() {
//    SecondScreen(navController = NavHostController(LocalContext.current))
//}