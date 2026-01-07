package shrowd.dino_atlas.data.model

data class Dino(
    val id: Int,
    val name: String,
    val scientificName: String,
    val era: String,
    val periodMillionYearsAgo: String,
    val diet: String,
    val weightTons: Double,
    val lengthMeters: Double,
    val heightMeters: Double,
    val speedKmh: Int,
    val classification: Classification,
    val characteristics: Characteristics,
    val habitat: Habitat,
    val description: String,
    val imageUrl: String
)
