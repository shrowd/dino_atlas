package shrowd.dino_atlas.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import shrowd.dino_atlas.data.model.Dino
import shrowd.dino_atlas.ui.screen.DinoDetailScreen
import shrowd.dino_atlas.ui.screen.DinoListScreen

@Composable
fun NavGraph(dinos: List<Dino>) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {

        composable("list") {
            DinoListScreen(dinos) { dino ->
                navController.navigate("detail/${dino.id}")
            }
        }

        composable(
            "detail/{dinoId}",
            arguments = listOf(navArgument("dinoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val dinoId = backStackEntry.arguments?.getInt("dinoId")
            val dino = dinos.find { it.id == dinoId }

            if (dino != null) {
                DinoDetailScreen(dino = dino)
            } else {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Dino not found")
                }
            }
        }



    }
}
