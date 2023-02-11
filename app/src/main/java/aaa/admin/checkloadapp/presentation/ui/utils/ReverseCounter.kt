package aaa.admin.checkloadapp.presentation.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ReverseCounter(
    modifier: Modifier = Modifier
) {

    Surface(modifier = modifier) {
        Row() {
            ItemReverseCounter(textTime = "14", textNameTime = "hours")
            ItemReverseCounter(textTime = "04", textNameTime = "minutes")
            ItemReverseCounter(textTime = "05", textNameTime = "seconds")
        }
    }
}

@Composable
fun ItemReverseCounter(
    modifier: Modifier = Modifier,
    textTime: String,
    textNameTime: String
) {
    Column(
        modifier = modifier.width(100.dp)
    ) {
        Box(
            modifier = modifier
                .size(100.dp)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = textTime)
        }
        Text(
            modifier = modifier.fillMaxWidth(),
            text = textNameTime,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(name = "КeverseСounter")
@Composable
private fun PreviewКeverseСounter() {
    ReverseCounter()
}