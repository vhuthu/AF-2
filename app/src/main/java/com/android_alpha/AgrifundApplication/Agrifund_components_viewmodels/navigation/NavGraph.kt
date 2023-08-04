import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
//import com.example.af2.farm.navigation.Screen
import com.example.af2.Agrifund_components_viewmodels.navigation.Screens
import com.example.af2.Agrifund_components_viewmodels.screens_component.AddDataScreen
import com.example.af2.Agrifund_components_viewmodels.screens_component.GetDataScreen
import com.example.af2.Agrifund_components_viewmodels.screens_component.MainScreen
import com.example.af2.Agrifund_components_viewmodels.utilities.viewmodel.SharedViewModel

@Composable
fun NavGraph(
    navController : NavHostController, sharedViewModel: SharedViewModel
) {
    NavHost(navController = navController, startDestination = Screens.MainScreen.route){


        //main_screen
        composable(route = Screens.MainScreen.route){
            MainScreen(navController = navController)
        }

        //get_data
        composable(route = Screens.GetDataScreen.route){
            GetDataScreen(navController = navController, sharedViewModel = sharedViewModel)
        }

        //add_data
        composable(route = Screens.AddDataScreen.route){
            AddDataScreen(navController = navController, sharedViewModel = sharedViewModel)
        }

    }

}
