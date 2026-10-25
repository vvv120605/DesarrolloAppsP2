package com.example.appsemestral.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val EsquemaPremium = darkColorScheme(
    primary = Lavanda,
    onPrimary = SobreLavanda,
    primaryContainer = LavandaContenedor,
    onPrimaryContainer = SobreLavandaContenedor,
    secondary = LavandaGris,
    onSecondary = SobreLavandaGris,
    secondaryContainer = LavandaGrisContenedor,
    onSecondaryContainer = SobreLavandaGrisContenedor,
    tertiary = LilaRosado,
    onTertiary = SobreLilaRosado,
    tertiaryContainer = LilaRosadoContenedor,
    onTertiaryContainer = SobreLilaRosadoContenedor,
    background = FondoPremium,
    onBackground = TextoPrincipal,
    surface = Superficie,
    onSurface = TextoPrincipal,
    surfaceVariant = SuperficieAlta,
    onSurfaceVariant = TextoSecundario,
    surfaceContainerLowest = SuperficieMuyBaja,
    surfaceContainerLow = SuperficieBaja,
    surfaceContainer = SuperficieMedia,
    surfaceContainerHigh = SuperficieAlta,
    surfaceContainerHighest = SuperficieMuyAlta,
    outline = Borde,
    outlineVariant = BordeSuave
)

@Composable
fun AppSemestralTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = EsquemaPremium,
        typography = Tipografia,
        content = content
    )
}