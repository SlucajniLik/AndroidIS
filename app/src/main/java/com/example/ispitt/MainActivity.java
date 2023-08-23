package com.example.ispitt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

        import android.text.TextUtils;
        import android.util.Patterns;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button register;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        setupListeners();
    }

    private void setupUI() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
    }


    private void setupListeners() {
        login.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // checkUsername();
                Call<Hero> call=RetrofitClient.getInstance().getMyApi().loginHero(username.getText().toString(),password.getText().toString());

                call.enqueue(new Callback<Hero>() {
                    @Override
                    public void onResponse(Call<Hero> call, Response<Hero> response) {
                         if(response.body()!=null) {
                              /*Hero herr=response.body();
                             Toast.makeText(MainActivity.this,
                                     herr.getType(),
                                     Toast.LENGTH_SHORT).show();*/




                             Intent i = new Intent(MainActivity.this, ListS.class);
                             String str = username.getText().toString();
                             i.putExtra("message_key", str);
                             startActivity(i);
                         }
                         else
                         {
                             Toast.makeText(MainActivity.this,
                                     "Uneli ste pogresne podatke",
                                     Toast.LENGTH_SHORT).show();
                         }




                    }

                    @Override
                    public void onFailure(Call<Hero> call, Throwable t) {

                    }
                });











            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Registracija.class);
                startActivity(i);
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


    void checkUsername() {
        boolean isValid = true;
        if (isEmpty(username)) {
            username.setError("You must enter username to login!");
            isValid = false;
        } else {
            if (!isEmail(username)) {
                username.setError("Enter valid email!");
                isValid = false;
            }
        }

        if (isEmpty(password)) {
            password.setError("You must enter password to login!");
            isValid = false;
        } else {
            if (password.getText().toString().length() < 4) {
                password.setError("Password must be at least 4 chars long!");
                isValid = false;
            }
        }

        //check email and password
        //IMPORTANT: here should be call to backend or safer function for local check; For example simple check is cool
        //For example simple check is cool
        if (isValid) {
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();
            if (usernameValue.equals("ami@gmail.com") && passwordValue.equals("1234")) {
                //everything checked we open new activity
                    Intent i = new Intent(MainActivity.this, ListS.class);
                String str = username.getText().toString();
                i.putExtra("message_key", str);
                startActivity(i);
                //we close this activity
                this.finish();
            } else {
                Toast t = Toast.makeText(this, "Wrong email or password!", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }



}
