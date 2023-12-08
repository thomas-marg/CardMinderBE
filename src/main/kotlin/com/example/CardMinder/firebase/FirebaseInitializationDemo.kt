package com.example.CardMinder.firebase

import org.springframework.stereotype.Service
import java.io.FileInputStream

@Service
class FirebaseInitializationDemo {

    public void initialization(){
        FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();

        FirebaseApp.initializeApp(options);

    }
}