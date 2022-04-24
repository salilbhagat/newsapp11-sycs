package com.example.newsapp11;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
public class contact extends AppCompatActivity {
    private Firebase Ref;
    private TextView emailTV;
    private EditText feedback;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        emailTV = (TextView) findViewById(R.id.email);
        feedback=(EditText) findViewById(R.id.feedback);
        Firebase.setAndroidContext(this);
        Ref=new Firebase("https://newsapp11-1583994573079.firebaseio.com/");
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(contact.this);
        if (acct != null) {
            String personEmail = acct.getEmail();
            emailTV.setText("Email: " + personEmail); } }
    public void feedbacksent(View view) {
        String usernameinput;
        usernameinput = emailTV.getText().toString();
        String feedbackinput=feedback.getText().toString();
        Firebase Reusername=Ref.child("email");
        Reusername.setValue(usernameinput);
        Firebase Reffeedback=Ref.child("Feedback");
        Reffeedback.setValue(feedbackinput);
        Toast.makeText(contact.this, "Feedback has being sent", Toast.LENGTH_LONG).show(); }}