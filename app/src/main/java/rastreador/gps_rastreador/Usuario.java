package rastreador.gps_rastreador;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Usuario extends  AppCompatActivity{

    String nome_usuario ="";

    int valida_usuario( String nomeUsuario, String senhaUsuario)
    {
        if( nomeUsuario.equals("operador") && senhaUsuario.equals("123456"))
        {
            System.out.println("Logado como operador !!");
            return 1;
        }
        else
        {
            return 0;
        }
    }

}


