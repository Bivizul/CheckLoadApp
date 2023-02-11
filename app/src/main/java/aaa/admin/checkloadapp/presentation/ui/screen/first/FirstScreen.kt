package aaa.admin.checkloadapp.presentation.ui.screen.first

import aaa.admin.checkloadapp.presentation.navigation.Screen
import aaa.admin.checkloadapp.presentation.ui.utils.ButtonBig
import aaa.admin.checkloadapp.presentation.ui.utils.ButtonSmall
import aaa.admin.checkloadapp.presentation.ui.utils.CustomBlockLinearProgressBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->

        Column(
            modifier = modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            CustomBlockLinearProgressBar(
                textTitle = "Loading",
                textPercent = "48%"
            )
            Spacer(modifier = modifier.height(16.dp))
            BlockTwo()
            Spacer(modifier = modifier.height(16.dp))
            ButtonBig(
                onClick = { /*TODO*/ },
                textButton = "Show custom alert"
            )
            Spacer(modifier = modifier.height(16.dp))
            ButtonBig(
                onClick = { navController.navigate(Screen.SecondScreenRoute.route) },
                textButton = "Go to second screen"
            )
        }
    }


}

@Composable
fun BlockOne(
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier.fillMaxWidth()
    ) {
        Column() {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Loading ...")
                Text(text = "48%")
            }
            LinearProgressIndicator(
                modifier = modifier.height(25.dp),
                progress = 40f,
                color = Color.Magenta
            )
        }
    }

}

@Composable
fun BlockTwo(
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier.fillMaxWidth()
    ) {
        Column() {
            Text(text = "Lottie animation")
            Row() {
                Box(
                    modifier = modifier
                        .size(100.dp)
                        .background(Color.Green)
                )
                Column(
                    modifier = modifier
                ) {
                    ButtonSmall(
                        onClick = { /*TODO*/ },
                        textButton = "Start Animation"
                    )
                    ButtonSmall(
                        onClick = { /*TODO*/ },
                        textButton = "Stop Animation"
                    )
                    ButtonSmall(
                        onClick = { /*TODO*/ },
                        textButton = "Hide / Show Animation"
                    )
                }
            }
        }
    }

}


@Preview(showSystemUi = true)
@Composable
private fun PreviewFirstScreen() {
    FirstScreen(navController = NavHostController(LocalContext.current))
}