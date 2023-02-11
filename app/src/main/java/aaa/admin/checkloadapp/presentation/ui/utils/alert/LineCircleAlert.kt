package aaa.admin.checkloadapp.presentation.ui.utils.alert

import aaa.admin.checkloadapp.presentation.ui.theme.*
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun LineCircleAlert(
    modifier: Modifier = Modifier
) {

    val a = remember { mutableStateOf(0) }

    Log.e(TAG, "LineCircleAlert: a : $a")

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
//        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleAlert(
            backgroundColor = ColorCircleOne,
            borderColor = ColorCircleOne,
            textCircle = "First",
        )

        Log.e(TAG, "LineCircleAlert: a before : $a")
        LineAlert(
            modifier = modifier.weight(1f),
            start = 5f,
            end = 50f
        )
        CircleAlert(
            backgroundColor = ColorCircleTwo,
            borderColor = Color.White,
            textCircle = "Second",
        )
        LineAlert(
            modifier = modifier.weight(1f),
            start = 30f,
            end = 31f
        )
        CircleAlert(
            backgroundColor = Color.White,
            borderColor = ColorCircleThree,
            textCircle = "Third",
        )
        LineAlert(
            modifier = modifier.weight(1f),
            start = 13f,
            end = 43f
        )
        CircleAlert(
            backgroundColor = Color.White,
            borderColor = ColorCircleFour,
            textCircle = "Fourth",
        )
    }
}

@Composable
fun CircleAlert(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    borderColor: Color,
    textCircle: String,
//    width: MutableState<Int>
) {

    var a by remember { mutableStateOf(0) }
//    width.value = a

    Log.e(TAG, "CircleAlert: a : $a")

    Column(
        modifier = modifier
//            .onSizeChanged { size ->
//                a = size.width
//            }
            .offset {
                IntOffset(x = 0, y = 0)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .size(24.dp)
                .clip(CircleShape)
                .border(1.dp, borderColor, CircleShape)
                .background(backgroundColor),
        )
        Text(text = textCircle)
    }

}

@Composable
fun LineAlert(
    modifier: Modifier = Modifier,
    start: Float,
    end: Float
) {
    Canvas(modifier = modifier) {
        drawLine(
            color = ColorAlertLine,
            cap = StrokeCap.Butt,
            strokeWidth = 3.dp.value,
            start = Offset(x = 0f - start, y = 35f),
            end = Offset(x = size.width + end, y = 35f)
        )
    }
}

@Preview(name = "CircleAlert", backgroundColor = 0xFFFFEB3B)
@Composable
private fun PreviewCircleAlert() {
    LineCircleAlert()
}