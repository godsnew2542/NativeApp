package com.watcharapon1.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        testFireStore();

    }

    private void testFireStore(){
        final String TAG = "testFireStore";
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("img_Chicken_rice")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void signInClick(View view){
        final String TAG = "signInClick";
        String email = ((TextView)findViewById(R.id.editText)).getText().toString();
        String password = ((TextView)findViewById(R.id.editText2)).getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            openpage();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

//    public void sigoutClick(View view){
//        final String TAG = "sigoutClick";
//        Log.w(TAG, "sign out");
//        mAuth.signOut();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        openpage(currentUser);
//    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
//            openpage();
            Toast.makeText(this,"Hello " + currentUser, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Hello ", Toast.LENGTH_SHORT).show();
        }
    }

    public void openpage(){
        final String TAG = "open page";
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);

//        if(currentUser != null){
//            Log.d(TAG, currentUser.getEmail());
//            Intent intent = new Intent(this, ListActivity.class);
//            startActivity(intent);
//
//        }
//        else{
//        Toast.makeText(this,"Hello World", Toast.LENGTH_SHORT).show();
//
//        }
    }

}
