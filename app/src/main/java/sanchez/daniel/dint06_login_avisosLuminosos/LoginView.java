package sanchez.daniel.dint06_login_avisosLuminosos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by daniel.rodriguez on 11/01/2017.
 */
public class LoginView extends LinearLayout {
    private EditText txtUsuario, txtPassword;
    private Button btnValidar;
    private OnLoginListener onLoginListener;
    private MiPropioView miPropioWiew;

    public LoginView(Context context) {
        super(context);
        inicializar();
    }
    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializar();
    }
    public LoginView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inicializar();
    }
    private void inicializar() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.login, this, true);
        txtUsuario = (EditText)findViewById(R.id.usuario);
        txtPassword = (EditText)findViewById(R.id.contrasena);
        btnValidar = (Button)findViewById(R.id.validar);
        asignarEventos();
    }
    public void setOnLoginListener(OnLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }
    public interface OnLoginListener {
        void onLogin(String usuario, String contrasena);
    }
    public void asignarEventos() {
        btnValidar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginListener.onLogin(txtUsuario.getText().toString(), txtPassword.getText().toString());
            }
        });
    }
}
