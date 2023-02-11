package aaa.admin.checkloadapp.presentation.ui.utils

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GradientProgressBar(
    downloadedPercentage: Float,
    gradientColors: List<Color>,
    backgroundIndicatorColor: Color,
    radius:Float,
    indicatorHeight: Dp,
//    indicatorPadding: Dp = 0.dp,
//    textStyle: TextStyle = TextStyle(
////        fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
//        fontSize = 32.sp
//    ),
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {

    val animateNumber = animateFloatAsState(
        targetValue = downloadedPercentage,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(indicatorHeight)
//            .padding(start = indicatorPadding, end = indicatorPadding)
    ) {

        // Convert the downloaded percentage into progress (width of foreground indicator)
        val progress =
            (animateNumber.value / 100) * size.width // size.width returns the width of the canvas

        // Background indicator
//        drawLine(
//            color = backgroundIndicatorColor,
//            cap = StrokeCap.Round,
//            strokeWidth = size.height,
//            start = Offset(x = 0f, y = 0f),
//            end = Offset(x = size.width, y = 0f)
//        )

        drawRoundRect(
            color = backgroundIndicatorColor,
            topLeft = Offset.Zero,
            size = Size(size.width,size.height),
            cornerRadius = CornerRadius(radius,radius)
        )


//        // Foreground indicator
//        drawLine(
//            brush = Brush.linearGradient(
//                colors = gradientColors
//            ),
//            cap = StrokeCap.Round,
//            strokeWidth = size.height,
//            start = Offset(x = 0f, y = 0f),
//            end = Offset(x = progress, y = 0f)
//        )

        drawRoundRect(
            brush = Brush.linearGradient(
                colors = gradientColors
            ),
            topLeft = Offset.Zero,
            size = Size(progress,size.height),
            cornerRadius = CornerRadius(radius,radius)
        )
    }
}