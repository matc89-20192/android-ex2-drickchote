package matc89.exercicio2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by marcos on 08/09/2019.
 * Passou em todos os testes =D
 */

public class OutraActivity extends AppCompatActivity {

    EditText input;
    String usuarioAtual="";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outra_activity);
        this.input =  (EditText)findViewById(R.id.editText);
        Intent intent = getIntent();
        this.input.setText(intent.getStringExtra("usuarioAtual"));
    }

    public void onConfirmar(View v){

        Intent intent = new Intent();
        this.input =  (EditText)findViewById(R.id.editText);
        intent.putExtra("novo_usuario", input.getText().toString());
        setResult(1, intent);
        finish();
    }

    public void onCancelar(View v){
        Intent intent = new Intent();
        intent.putExtra("novo_usuario", "");
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("inputText", this.input.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        this.input.setText(savedInstanceState.getString("inputText"));
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("novo_usuario", "");
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }
}
