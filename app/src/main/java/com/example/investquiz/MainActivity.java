package com.example.investquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button butao;
    private Button botaoservico;
    private TextView  credito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
botaoservico = (Button) findViewById(R.id.servicoid);
credito = (TextView) findViewById(R.id.creditoid);

botaoservico.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
   Intent intent = new Intent(MainActivity.this, Quizmelhor.class);
        startActivity(intent);
        
    }
});
credito.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, credito.class);
        startActivity(intent);
    }
});
    }
}
