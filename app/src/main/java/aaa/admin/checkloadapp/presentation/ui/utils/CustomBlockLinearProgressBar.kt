package aaa.admin.checkloadapp.presentation.ui.utils

import aaa.admin.checkloadapp.presentation.ui.theme.Typography
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomBlockLinearProgressBar(
    modifier: Modifier = Modifier,
    textTitle: String,
    downloadedPercentage: Float,
    gradientColors: List<Color>,
    backgroundIndicatorColor: Color,
    radius: Float,
    indicatorHeight: Dp,
    textStyle: TextStyle,
) {

    Surface(
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = textTitle,
                    style = textStyle
                )
                Text(
                    text = downloadedPercentage.toInt().toString() + "%",
                    style = textStyle
                )
            }
            Spacer(modifier = modifier.height(16.dp))
            GradientProgressBar(
                downloadedPercentage = downloadedPercentage,
                gradientColors = gradientColors,
                backgroundIndicatorColor = backgroundIndicatorColor,
                radius = radius,
                indicatorHeight = indicatorHeight
            )
        }
    }
}


//@Preview(name = "CustomLinearProgressBar")
//@Composable
//private fun PreviewCustomLinearProgressBar() {
//    CustomBlockLinearProgressBar()
//}