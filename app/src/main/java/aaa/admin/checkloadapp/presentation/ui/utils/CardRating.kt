package aaa.admin.checkloadapp.presentation.ui.utils

import aaa.admin.checkloadapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun CardRating(
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .size(250.dp, 100.dp)
            .background(color = Color.Gray)
    ) {
        Column() {
            Row() {
                Image(painter = painterResource(id = R.drawable.star_24), contentDescription =null)
                Image(painter = painterResource(id = R.drawable.star_24), contentDescription =null)
                Image(painter = painterResource(id = R.drawable.star_24), contentDescription =null)
                Image(painter = painterResource(id = R.drawable.star_24), contentDescription =null)
                Image(painter = painterResource(id = R.drawable.star_24), contentDescription =null)
            }
            Row {


                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.dropbox.com/s/dijj8qsad8m8v4h/1.png?dl=1")
                            .crossfade(true)
                            .build(),
                    ),
                    contentDescription = null
                )
                Text(text = "text")

            }
        }

    }
}

@Preview(name = "CardRating")
@Composable
private fun PreviewCardRating() {
    CardRating()
}