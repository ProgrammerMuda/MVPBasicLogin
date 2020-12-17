 package izzi.go.mvpbasicjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import izzi.go.mvpbasicjava.presenter.LoginPresenter;
import izzi.go.mvpbasicjava.presenter.LoginPresenterInterface;
import izzi.go.mvpbasicjava.view.LoginViewInterface;

 public class MainActivity extends AppCompatActivity implements LoginViewInterface {

    EditText edtEmail, edtPassword;
    Button btnLogin;

    LoginPresenterInterface loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                loginPresenter.onLogin(email, password);
            }
        });
    }

     @Override
     public void onLoginSuccess(String message) {
         Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


     }

     @Override
     public void onLoginError(String message) {
         Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

     }
 }