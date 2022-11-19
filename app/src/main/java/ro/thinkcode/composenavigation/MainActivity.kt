package ro.thinkcode.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // The NavController is the starting point for the Navigation component.
            // The NavController keeps track of the back stack of composables that make up the screens in your app and the state of each screen.
            // The NavController is stateful, meaning that NavController holds and modifies its objects state internally.
            // This is useful to us because we don't need to control the state of the NavController and we can use it without having to manage its state ourselves.

            // You can create a NavController by using the rememberNavController() method in your composable:
            val navController = rememberNavController()

            // We pass the navController parameter to the main screen of our app.
            // MyNavigationScreen composable function is the single source of truth for the NavController instance.
            MyNavigationScreen(navController = navController)
        }
    }
}

@Composable
fun MyNavigationScreen(
    // MyNavigationScreen composable function is the single source of truth for the NavController instance.
    navController: NavHostController,
) {

    // The NavController manages app navigation within a NavHost.
    // Each NavController must be associated with a single NavHost composable.
    // Navigation flows and destinations are determined by the navigation graph owned by the controller.
    // The NavHost links the NavController with a navigation graph that specifies the composable destinations that you should be able to navigate between.

    NavHost(
        // Creating the NavHost requires the NavController previously created via rememberNavController() and the route of the starting destination of your graph.
        navController = navController,
        startDestination = "firstScreenRoute"
    ) {
        // As you navigate between composables, the content of the NavHost is automatically recomposed.
        // Each composable destination in your navigation graph is associated with a route.

        // You can add to your navigation structure by using the composable() method.
        // This method requires that you provide a route and the composable that should be linked to the destination
        composable("firstScreenRoute") {
            //The first destination composable is FirstAppScreen
            FirstAppScreen(
                // FirstAppScreen passes a callback function that is called when the user taps on a button.
                onNavigateToSecondAppScreen = {
                    // Only call navigate() as part of a callback and not as part of your composable itself, to avoid calling navigate() on every recomposition.
                    navController.navigate("secondScreenRoute")
                },
            )
        }

        //The second destination composable is SecondAppScreen
        composable("secondScreenRoute") {
            SecondAppScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNavigationScreen(navController = rememberNavController())
}