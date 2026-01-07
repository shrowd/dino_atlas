package shrowd.dino_atlas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import shrowd.dino_atlas.data.model.Dino
import shrowd.dino_atlas.data.repository.DinoRepository
import shrowd.dino_atlas.navigation.NavGraph
import shrowd.dino_atlas.ui.screen.LoadingScreen
import shrowd.dino_atlas.ui.theme.DinoAtlasTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var dinos by remember { mutableStateOf<List<Dino>>(emptyList()) }

            var isLoading by remember { mutableStateOf(true) }

            LaunchedEffect(Unit) {
                val repository = DinoRepository(this@MainActivity)
                dinos = repository.loadDinos()
                isLoading = false
            }

            DinoAtlasTheme {
                if (isLoading) {
                    LoadingScreen()
                } else {
                    NavGraph(dinos)
                }
            }

        }
    }
}
