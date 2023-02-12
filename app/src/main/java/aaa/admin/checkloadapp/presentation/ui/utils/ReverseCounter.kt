package aaa.admin.checkloadapp.presentation.ui.utils

import aaa.admin.checkloadapp.presentation.ui.theme.Typography
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ReverseCounter(
    timer: Long,
    modifier: Modifier = Modifier,
) {

    val secMilSec: Long = 1000
    val minMilSec = 60 * secMilSec
    val hourMilSec = 60 * minMilSec
    val dayMilSec = 24 * hourMilSec
    val hours = (timer % dayMilSec / hourMilSec).toString()
    val minutes = (timer % dayMilSec % hourMilSec / minMilSec).toString()
    val seconds = (timer % dayMilSec % hourMilSec % minMilSec / secMilSec).toString()

//    Text(text = String.format("%02d:%02d:%02d", hours, minutes, seconds))

//    Surface(modifier = modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ItemReverseCounter(textTime = hours, textNameTime = "hours")
        ItemReverseCounter(textTime = minutes, textNameTime = "minutes")
        ItemReverseCounter(textTime = seconds, textNameTime = "seconds")
    }
//    }
}

@Composable
fun ItemReverseCounter(
    modifier: Modifier = Modifier,
    textTime: String,
    textNameTime: String
) {
    Column(
        modifier = modifier
            .width(100.dp)
            .padding(8.dp)
    ) {
        Box(
            modifier = modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = textTime,
                style = Typography.titleLarge
            )
        }
        Text(
            modifier = modifier.fillMaxWidth(),
            text = textNameTime,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(name = "ReverseСounter")
@Composable
private fun PreviewКeverseСounter() {
    ReverseCounter(16505 * 1000L)
}