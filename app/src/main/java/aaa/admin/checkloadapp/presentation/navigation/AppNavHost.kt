package aaa.admin.checkloadapp.presentation.navigation

import aaa.admin.checkloadapp.presentation.ui.screen.first.FirstScreen
import aaa.admin.checkloadapp.presentation.ui.screen.second.SecondScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object FirstScreenRoute : Screen("first_screen")
    object SecondScreenRoute : Screen("second_screen")
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.FirstScreenRoute.route
) {
//    val gamlimact = LocalContext.current as Activity

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(startDestination) { backStackEntry ->
            FirstScreen(navController = navController)
        }
        composable(Screen.SecondScreenRoute.route) {
            SecondScreen(navController = navController)
//            BackHandler() {
//                gamlimact.finish()
//            }
        }
    }
}
