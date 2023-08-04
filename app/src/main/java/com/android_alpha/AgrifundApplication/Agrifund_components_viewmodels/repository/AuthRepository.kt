package com.android_alpha.AgrifundApplication.Agrifund_components_viewmodels.repository

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
//02 / 07 / 2023
class AuthRepository {
    val currentUser: FirebaseUser? = Firebase.auth.currentUser


    //even though is a security threat to have your app save your log ins this function helps with remembering if youve registered already
    fun hasUser():Boolean = Firebase.auth.currentUser != null

    //this function returns logged user
    fun getUserId(): String = Firebase.auth.currentUser?.uid.orEmpty()

    /*02 / 07 / 2023
    * ow this is the main man , this funcion helps the user create an account*/
    suspend fun createUser(
        email:String,
        password: String,
        onComplete: (Boolean) -> Unit
    ) = withContext(Dispatchers.IO){
        Firebase.auth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    onComplete.invoke(true)
                }else{
                    onComplete.invoke(false)
                }
            }.await()  //we cant forget old uncle sam Await function if we are working with posting and retrieving data
    }

//this one helps you to log in
    suspend fun login(
        email:String,
        password: String,
        onComplete: (Boolean) -> Unit
    ) = withContext(Dispatchers.IO){
        Firebase.auth
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    onComplete.invoke(true)
                }else{
                    onComplete.invoke(false)
                }
            }.await()
    }



}