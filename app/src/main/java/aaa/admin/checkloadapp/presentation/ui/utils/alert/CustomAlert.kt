package aaa.admin.checkloadapp.presentation.ui.utils.alert

import aaa.admin.checkloadapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAlert(
    modifier: Modifier = Modifier,
    openDialog: MutableState<Boolean>
) {

    var text by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        title = {
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.vector), contentDescription = null)
                Text(text = "Custom Alert")
            }
        },
        text = {
            LineCircleAlert()
        },
        confirmButton = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { openDialog.value = false }
                ) {
                    Text("Close")
                }
            }
        }
    )
}


//@Preview(name = "CustomAlert")
//@Composable
//private fun PreviewCustomAlert() {
//    CustomAlert()
//}