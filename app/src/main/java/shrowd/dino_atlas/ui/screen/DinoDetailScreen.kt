package shrowd.dino_atlas.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import shrowd.dino_atlas.data.model.Dino

@Composable
fun DinoDetailScreen(dino: Dino) {

    var showModal by remember { mutableStateOf<String?>(null) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = dino.name,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = dino.scientificName,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            AsyncImage(
                model = dino.imageUrl,
                contentDescription = dino.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )


            Spacer(modifier = Modifier.height(16.dp))

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text("Era: ${dino.era}")
                Text("Period: ${dino.periodMillionYearsAgo}")
                Text("Diet: ${dino.diet}")
                Text("Weight (tons): ${dino.weightTons}")
                Text("Length (m): ${dino.lengthMeters}")
                Text("Height (m): ${dino.heightMeters}")
                Text("Speed (km/h): ${dino.speedKmh}")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(onClick = { showModal = "classification" }) {
                    Text("Classification")
                }
                Button(onClick = { showModal = "characteristics" }) {
                    Text("Characteristics")
                }
                Button(onClick = { showModal = "habitat" }) {
                    Text("Habitat")
                }
            }
        }
    }

    showModal?.let { key ->
        AlertDialog(
            onDismissRequest = { showModal = null },
            title = { Text(text = key.replaceFirstChar { it.uppercase() }) },
            text = {
                when (key) {
                    "classification" -> {
                        val c = dino.classification
                        Column {
                            Text("Order: ${c.order}")
                            Text("Suborder: ${c.suborder}")
                            Text("Family: ${c.family}")
                            Text("Genus: ${c.genus}")
                            Text("Species: ${c.species}")
                        }
                    }

                    "characteristics" -> {
                        val ch = dino.characteristics
                        Column {
                            Text("Strengths: ${ch.strengths}")
                            Text("Weaknesses: ${ch.weaknesses}")
                            Text("Physical Traits: ${ch.physicalTraits}")
                        }
                    }

                    "habitat" -> {
                        val h = dino.habitat
                        Column {
                            Text("Primary Location: ${h.primaryLocation}")
                            Text("Preferred Terrain: ${h.preferredTerrain}")
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showModal = null }) {
                    Text("Close")
                }
            }
        )
    }
}



