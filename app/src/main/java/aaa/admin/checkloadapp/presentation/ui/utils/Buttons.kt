package aaa.admin.checkloadapp.presentation.ui.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtonSmall(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    textButton: String
) {
    Button(
        onClick = onClick
    ) {
        Text(text = textButton)
    }
}

@Composable
fun ButtonMedium(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    textButton: String
) {
    Button(onClick = onClick) {
        Text(text = textButton)
    }
}

//@Preview(name = "ButtonMedium")
//@Composable
//private fun PreviewButtonMedium() {
//    ButtonMedium()
//}

@Composable
fun ButtonBig(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    textButton: String
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Text(text = textButton)
    }
}

//@Preview(name = "ButtonBig")
//@Composable
//private fun PreviewButtonBig() {
//    ButtonBig()
//}