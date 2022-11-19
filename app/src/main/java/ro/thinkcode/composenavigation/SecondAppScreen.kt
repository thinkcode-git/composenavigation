package ro.thinkcode.composenavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SecondAppScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //on the second screen we show a text
        Text(text = "Second App Screen")
    }

}

//To show a preview of our composable we use the @Preview annotation
//The showBackground property will show a white background color for our screen instead of a transparent background
//The preview composable must have a different name to avoid conflicts
@Preview(showBackground = true)
@Composable
fun SecondAppScreenPreview() {
    //Inside the preview composable we call our composable
    SecondAppScreen()
}