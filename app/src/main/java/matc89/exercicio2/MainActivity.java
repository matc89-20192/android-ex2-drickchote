package matc89.exercicio2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView label;
    String usuarioAtual="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.label = (TextView) findViewById(R.id.textView);
    }

    public void trocarUsuario(View v){
        Intent i = new Intent(MainActivity.this, OutraActivity.class);
        i.putExtra("usuarioAtual", this.usuarioAtual);
        this.startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);

        this.usuarioAtual = dataIntent.getStringExtra("novo_usuario");
        if(this.usuarioAtual.intern() == "" && resultCode != Activity.RESULT_CANCELED){
            this.label.setText("Oi!");
        } else if(resultCode != Activity.RESULT_CANCELED){
            this.label.setText("Oi, "+usuarioAtual+"!");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("labelText", (String) this.label.getText().toString());
        outState.putString("usuarioAtual", this.usuarioAtual);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        this.label.setText(savedInstanceState.getString("labelText"));
        this.usuarioAtual = savedInstanceState.getString("usuarioAtual");
    }
}
