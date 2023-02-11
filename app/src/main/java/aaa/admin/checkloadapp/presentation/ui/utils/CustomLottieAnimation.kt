package aaa.admin.checkloadapp.presentation.ui.utils

import aaa.admin.checkloadapp.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.*

@Composable
fun CustomLottieAnimation(
    togglePlaying : Boolean
) {

//    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.android_logo) }
//    val animationState = rememberLottieAnimationState(autoPlay = true, repeatCount = Integer.MAX_VALUE)

//    val tooglePlaing = true

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.android_logo))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = togglePlaying,
        restartOnPlay = false,
        iterations = LottieConstants.IterateForever
    )

    LottieAnimation(composition = composition, progress = { progress })


}