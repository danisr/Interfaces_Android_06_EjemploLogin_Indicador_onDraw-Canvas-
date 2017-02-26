package sanchez.daniel.dint06_login_avisosLuminosos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LoginView loginView;
    Boolean loginCorrecto;
    MiPropioView miPropioView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.login);

        loginView = (LoginView) findViewById(R.id.CtlLogin);
        miPropioView = (MiPropioView) findViewById(R.id.log);

        loginView.setOnLoginListener(new LoginView.OnLoginListener() {
             @Override
             public void onLogin(String usuario, String contrasena) {
                 if (usuario.equals("demo") && contrasena.equals("demo")) {
                     Toast.makeText(getApplicationContext(), "Login Correcto", Toast.LENGTH_LONG).show();
                     loginCorrecto = true;
                     miPropioView.eliminarCirculo(loginCorrecto);

                 } else {
                     Toast.makeText(getApplicationContext(), "Usuario/password incorrecto", Toast.LENGTH_LONG).show();
                     loginCorrecto = false;
                     miPropioView.eliminarCirculo(loginCorrecto);
                 }
             }
        });
    }
}