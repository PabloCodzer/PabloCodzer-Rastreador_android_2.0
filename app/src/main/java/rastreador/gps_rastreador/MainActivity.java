package rastreador.gps_rastreador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view)
    {
        TextView usuario = findViewById(R.id.usuario);
        TextView senha   = findViewById(R.id.senha);
        String nomeUsuario = usuario.getText().toString();
        String senhaUsuario = senha.getText().toString();

        Usuario validaUsuario = new Usuario();

        if( validaUsuario.valida_usuario( nomeUsuario, senhaUsuario ) == 1)
        {
            Toast.makeText(this,"Operador Logado com sucesso!!", Toast.LENGTH_SHORT).show();
            Intent intencao = new Intent(getApplicationContext(),gps_usuario.class);
            startActivity(intencao);
        }
    }
}