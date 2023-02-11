package aaa.admin.checkloadapp.presentation.ui.screen.second

import aaa.admin.checkloadapp.R
import aaa.admin.checkloadapp.presentation.ui.utils.ButtonBig
import aaa.admin.checkloadapp.presentation.ui.utils.CardRating
import aaa.admin.checkloadapp.presentation.ui.utils.CustomBlockLinearProgressBar
import aaa.admin.checkloadapp.presentation.ui.utils.ReverseCounter
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        containerColor = Color.LightGray
    ) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            Image(
                painter = painterResource(id = R.drawable.arrow_back_24),
                contentDescription = "button back",
                modifier = modifier.size(24.dp).clickable {
                    navController.popBackStack()
                }
            )
//            CustomBlockLinearProgressBar(
//                textTitle = "Random value",
////                textPercent = "62%"
//            )
//            CustomBlockLinearProgressBar(
//                textTitle = "Random value 2",
////                textPercent = "30%"
//            )
            ButtonBig(onClick = { /*TODO*/ }, textButton = "Randomize values")
            ReverseCounter()
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

@Preview(showSystemUi = true)
@Composable
private fun PreviewSecondScreen() {
    SecondScreen(navController = NavHostController(LocalContext.current))
}