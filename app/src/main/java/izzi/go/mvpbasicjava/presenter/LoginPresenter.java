package izzi.go.mvpbasicjava.presenter;

import izzi.go.mvpbasicjava.model.User;
import izzi.go.mvpbasicjava.view.LoginViewInterface;

public class LoginPresenter implements LoginPresenterInterface{

    LoginViewInterface loginView;

    public LoginPresenter(LoginViewInterface loginView) {
        this.loginView = loginView;
    }


    @Override
    public void onLogin(String email, String password) {

        User user = new User(email, password);
        int loginCode = user.isValidData();

        if(loginCode == 0) {
            loginView.onLoginError("You must enter your email");
        } else if(loginCode == 1) {
            loginView.onLoginError("You must enter valid email");
        } else if(loginCode == 2) {
            loginView.onLoginError("Password length must be greater than 6");
        } else {
            loginView.onLoginSuccess("Login success");
        }

    }
}
