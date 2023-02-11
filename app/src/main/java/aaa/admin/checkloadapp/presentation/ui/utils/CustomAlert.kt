package aaa.admin.checkloadapp.presentation.ui.alert

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAlert(
    modifier: Modifier = Modifier
) {
    val openDialog = remember { mutableStateOf(true) }
    var text by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        content = {
//            title = {
//                Text(text = "Title")
//            },
//            text = {
//                Column() {
//                    TextField(
//                        value = text,
//                        onValueChange = { text = it }
//                    )
//                    Text("Custom Text")
//                    Checkbox(checked = false, onCheckedChange = {})
//                }
//            },
//            buttons = {
//                Row(
//                    modifier = Modifier.padding(all = 8.dp),
//                    horizontalArrangement = Arrangement.Center
//                ) {
//                    Button(
//                        modifier = Modifier.fillMaxWidth(),
//                        onClick = { openDialog.value = false }
//                    ) {
//                        Text("Dismiss")
//                    }
//                }
//            }
        },
    )
}

@Preview(name = "CustomAlert")
@Composable
private fun PreviewCustomAlert() {
    CustomAlert()
}