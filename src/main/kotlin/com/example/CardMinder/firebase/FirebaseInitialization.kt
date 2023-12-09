package com.example.CardMinder.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.stereotype.Service
import java.io.FileInputStream
import javax.annotation.PostConstruct


//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;


@Service
class FirebaseInitialization {

    @PostConstruct
    fun initialize() {
        try {
            val serviceAccount = FileInputStream("./serviceaccount.json")
            val options: FirebaseOptions = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://chatapp-e6e15.firebaseio.com")
                .build()
            FirebaseApp.initializeApp(options)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}