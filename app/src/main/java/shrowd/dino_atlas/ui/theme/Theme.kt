package shrowd.dino_atlas.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    primary = Color(0xFF32AD38),
    onPrimary = Color.Black,
    secondary = Color(0xFFE01616),
    background = Color(0xFF333030),
    surface = Color(0xFF1E1E1E),
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun DinoAtlasTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorPalette,
        typography = Typography,
        content = content
    )
}
