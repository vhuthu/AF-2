package com.example.af2.farm.repository

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepository {
    val currentUser: FirebaseUser? = Firebase.auth.currentUser

    //heyi function i sedza uri user o log in naa
    fun hasUser():Boolean = Firebase.auth.currentUser != null

    //heyi function is vhuisa uid ya user o logaho in
    fun getUserId(): String = Firebase.auth.currentUser?.uid.orEmpty()

    //heyi function i vha itela account sa user
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
            }.await()  //hafha hukho shuma mulindelo athi kho toda heyi function itshithivhela mutevhewe wa eppe
    }

//heyi function i ita ury vhakone u jena ca account yavho
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
            }.await()  //hafha hukho shuma mulindelo athi kho toda heyi function itshithivhela mutevhewe wa eppe
    }








}