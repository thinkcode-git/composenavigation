package ro.thinkcode.composenavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FirstAppScreen(
    //the onNavigateToSecondAppScreen function does not take any parameters and does not return any values.
    onNavigateToSecondAppScreen: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //on the first screen we show a button
        //the button has an onClick parameter that calls the composable onNavigateToSecondAppScreen function.
        Button(onClick = onNavigateToSecondAppScreen) {
            Text(text = "Go to second screen") //This is the text that will be shown on the Button.
        }
    }

}

//To show a preview of our composable we use the @Preview annotation
//The showBackground property will show a white background color for our screen instead of a transparent background
//The preview composable must have a different name to avoid conflicts
@Preview(showBackground = true)
@Composable
fun FirstAppScreenPreview() {
    //Inside the preview composable we call our composable, passing all the parameters it requires.
    //The composable parameters must be initialised with test values.
    FirstAppScreen(onNavigateToSecondAppScreen = { })
}