package shrowd.dino_atlas.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shrowd.dino_atlas.data.model.Dino
import shrowd.dino_atlas.ui.components.DinoListItem

@Composable
fun DinoListScreen(
    dinos: List<Dino>,
    onDinoClick: (Dino) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Text(
                text = "Dinosaurs",
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )

            LazyColumn {
                items(dinos) { dino ->
                    DinoListItem(dino) {
                        onDinoClick(dino)
                    }
                }
            }
        }
    }
}
