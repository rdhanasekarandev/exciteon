package service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

public class FirebaseService {

    @PostConstruct
    private void initialize() {
        try {
            FileInputStream serviceAccount = new FileInputStream("./serviceAccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://exciteon-eb912-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
