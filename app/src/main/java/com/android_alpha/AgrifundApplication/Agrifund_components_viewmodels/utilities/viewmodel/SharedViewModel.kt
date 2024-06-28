package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.utilities.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.cruddroid.util.UserData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class SharedViewModel(

) : ViewModel(){

    /*
    * the functions below use firebase resources to save and update and delete in data in the database
    * */

    fun saveData(userData: UserData, context: Context) = CoroutineScope(Dispatchers.IO). launch{

        val fireStoreRef = Firebase.firestore
            .collection("items")
            .document(userData.itemID)

        try {
            fireStoreRef.set(userData).addOnSuccessListener {
                Toast.makeText(context,"Successfully saved data", Toast.LENGTH_LONG).show()

            }

        }catch (e: Exception){
            Toast.makeText(context,e.message, Toast.LENGTH_LONG).show()
        }

    }

    fun retrieveData(itemID:String,
                     context: Context,
                     data: (UserData) -> Unit

    ) = CoroutineScope(Dispatchers.IO). launch{
/*
* lol you be wondering why i used Dispatchers.IO ? ow yes remember we want to have real time data base
* that handles or heavy IO work (e.g. long-running database queries)

* */
        val fireStoreRef = Firebase.firestore
            .collection("items")
            .document(itemID)

        try {
            fireStoreRef.get().addOnSuccessListener {
                if (it.exists()){
                    val userData = it.toObject<UserData>()!!
                    data(userData)
                }else{
                    Toast.makeText(context,"No Data Found" ,Toast.LENGTH_SHORT).show()
                }

            }

        }catch (e: Exception){
            Toast.makeText(context,e.message, Toast.LENGTH_LONG).show()
        }

    }

    fun deleteData(
        itemID:String,
        context: Context,
        navController: NavController

    ) = CoroutineScope(Dispatchers.IO). launch{

        val fireStoreRef = Firebase.firestore
            .collection("user")
            .document(itemID)

        try {
            fireStoreRef.delete().addOnSuccessListener {
                Toast.makeText(context,"Successfully saved data", Toast.LENGTH_LONG).show()
                navController.popBackStack()
            }

        }catch (e: Exception){
            Toast.makeText(context,e.message, Toast.LENGTH_LONG).show()
        }

    }
}
