package aaa.admin.checkloadapp.presentation.ui.utils

import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomBlockLinearProgressBar(
    modifier: Modifier = Modifier,
    textTitle: String,
    textPercent: String
) {
    Surface(
        modifier = modifier.fillMaxWidth()
    ) {
        Column() {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = textTitle)
                Text(text = textPercent)
            }
            LinearProgressIndicator(
                modifier = modifier.height(25.dp),
                progress = 40f,
                color = Color.Magenta
            )
        }
    }
}

//@Preview(name = "CustomLinearProgressBar")
//@Composable
//private fun PreviewCustomLinearProgressBar() {
//    CustomBlockLinearProgressBar()
//}