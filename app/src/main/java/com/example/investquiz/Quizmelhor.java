package com.example.investquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quizmelhor extends AppCompatActivity {
  private question aquestion = new question();
    private String resposta;
    private int scores = 0,contador = 0;
    private int questionlength = aquestion.iPerguntas.length;
private ImageView imagens;

    Random r;

    private Button botao01,botao02,botao03,botao04;
    private TextView pergunta, pontos, quantquestao;
    final List<Integer> lista = Arrays.asList(0,1, 2, 3, 4,5,6,7,8);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizmelhor);
r = new Random();




imagens = (ImageView) findViewById(R.id.imagemid);
        botao01 = (Button) findViewById(R.id.altenativa1id);
        botao02 = (Button) findViewById(R.id.altenativa2id);
        botao03 = (Button) findViewById(R.id.altenativa3id);
        botao04 = (Button) findViewById(R.id.altenativa4id);
        pergunta = (TextView) findViewById(R.id.pergunta1);
        pontos = (TextView) findViewById(R.id.Pontosid);
        quantquestao = (TextView) findViewById(R.id.quantquestoesid);

        pontos.setText("Pontos: " + scores);
        quantquestao.setText("9/" + contador);

        Collections.shuffle(lista);






        updatepergunta(lista.get(0));



    botao01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (botao01.getText() == resposta) {
                    scores++;
                    contador++;
                    pontos.setText("Pontos: " + scores);
                    quantquestao.setText("9/" + contador);
                    game_acerto();


                } else {
                    contador++;
                    quantquestao.setText("9/" + contador);
                    game_erro();
                }
            }
        });

        botao02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botao02.getText() == resposta){
                    scores ++;
                    contador++;
                    pontos.setText("Pontos: " + scores);
                    quantquestao.setText("9/" + contador);
                    game_acerto();


                } else {
                    contador++;
                    quantquestao.setText("9/" + contador);
                    game_erro();
                }
            }
        });
        botao03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botao03.getText() == resposta){
                    scores ++;
                    contador++;
                    pontos.setText("Pontos: " + scores);
                    quantquestao.setText("9/" + contador);
                    game_acerto();


                } else {
                    contador++;
                    quantquestao.setText("9/" + contador);
                    game_erro();
                }
            }
        });
        botao04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(botao04.getText() == resposta){
                    scores ++;
                    contador++;
                    pontos.setText("Pontos: " + scores);
                    quantquestao.setText("9/" + contador);
                    game_acerto();


                } else {
                    contador++;
                    quantquestao.setText("9/" + contador);
                    game_erro();
                }
            }
        });}



    private void updatepergunta(int num){

imagem(num);
     pergunta.setText(aquestion.getpergunta(num));
     botao01.setText(aquestion.escolha1(num));
        botao02.setText(aquestion.escolha2(num));
        botao03.setText(aquestion.escolha3(num));
        botao04.setText(aquestion.escolha4(num));

        resposta = aquestion.getcorreta(num);

    }

    public void imagem(int a) {
        switch (a) {

            case 0:
                imagens.setImageDrawable(getResources().getDrawable(R.drawable.debenture));
                break;
            case 1:
                imagens.setImageDrawable(getResources().getDrawable(R.drawable.rendafixa));
                break;
            case 2:
                imagens.setImageDrawable(getResources().getDrawable(R.drawable.acoes));
                break;
            case 3:
                imagens.setImageDrawable(getResources().getDrawable(R.drawable.corretora));
                break;
            case 4:
                imagens.setImageDrawable(getResources().getDrawable(R.drawable.rendavariavel));
                break;
            case 5:
                imagens.setImageDrawable(getResources().getDrawable(R.drawable.selic));
                break;
            case 6:
                imagens.setImageDrawable(getResources().getDrawable(R.drawable.cdb));
                break;
            case 7:
            imagens.setImageDrawable(getResources().getDrawable(R.drawable.tesouro));
            break;
            case 8:
                imagens.setImageDrawable(getResources().getDrawable(R.drawable.lcilca));
                break;

            default:
                imagens.setImageDrawable(getResources().getDrawable(R.drawable.desta));

        }
    }

    public void game_over(){
        AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Quizmelhor.this);
        alertdialogbuilder
                .setMessage("Sua pontuação "+ scores + " Pontos")
        .setCancelable(false)
        .setPositiveButton("Novo jogo",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(),Quizmelhor.class));
                    }
                })
                .setNegativeButton("Voltar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });
AlertDialog alertDialog = alertdialogbuilder.create();
        alertDialog.show();



    }
    public void game_acerto(){
AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Quizmelhor.this);
        alertdialogbuilder.setMessage("Certa resposta -" + resposta);
        alertdialogbuilder.setTitle("Correto");
        alertdialogbuilder.setCancelable(false);
        alertdialogbuilder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(contador == 9){game_over();}
                else{
                updatepergunta(lista.get(contador));
            }
            }
        });
AlertDialog alertdialog = alertdialogbuilder.create();
        alertdialog.show();
    }
    public void game_erro(){
        AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Quizmelhor.this);
        alertdialogbuilder.setMessage("((resposta errada))\n A Correta é: "+resposta);
        alertdialogbuilder.setCancelable(false);
        alertdialogbuilder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(contador == 9){game_over();}
                else{
                    updatepergunta(lista.get(contador));
                }
            }
        });
        AlertDialog alertdialog = alertdialogbuilder.create();
        alertdialog.show();
    }

    public int selecionado(){
       /* int cont = 0;
        List<Integer> lista = new ArrayList();
        List<Integer> lis = new ArrayList();
        int tam = r.nextInt(aquestion.iPerguntas.length);
        while( cont < 5) {
             tam = r.nextInt(aquestion.iPerguntas.length);
            lis.add(tam);
            if(!lista.contains(tam)) {
                cont ++;
                lista.add(tam);
                }
            else{
                continue;
            }
        }*/
        /*List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Collections.shuffle(lista);
        System.out.println(lista.get(2));
        return lista.get();*/
        return 4;
    }

    public class question{

        String iPerguntas[] ={
           "O que é debêntures?","O que é Renda Fixa?","O que são ações?","O que é uma corretora de investimentos? ","O que é Renda variável?",
        "O que é Taxa Selic? ","O que é CDB?","O que é Tesouro Direto?","O que é LCI e LCA?"};

    private String iescolhas[][]={
       {"Título que a rentabilidade e através da inflação","É um tipo de Título emitido por bancos","Titulo emitido por Financeiras","É um tipo de Título de dívida emitido por empresas privadas"},
            {"é a modalidade mais segura para quem não quer perde o dinheiro investido e ganha rentabilidade em cima do valor",
                    "Modalidade onde o investidor aplica o dinheiro e tem possibilidade de ganha ou perde muito dinheiro","Rendimento atrelado ao CDI ","Rendimento atrelado a Selic"},
            {"Um tipo de renda fixa","Investimento que está ligado ao governo","Tipo de investimento que está ligado ao Agronegócio","Uma forma de Captação financeira para as empresas"},
            {"É uma intermediária que liga o investidor ao investimento", "Banco" ,"Uma financeira que empresta dinheiro" ,"Uma casa de câmbio"},
            {"É um tipo de investimento ligado ao Governo" ,"Investimento ligado ao Banco","Investimento ligado ao índice do IPCA","Esses ativos recebem essa denominação devido à rentabilidade que não pode ser pré-definida"},
            {"Taxa ligada ao CDI","Taxa básica de juro da economia do Brasil","Taxa Ligada ao IGP-M(Índice Geral De preço ao Consumidor)","Taxa da inflação"},
            {"Investimento em Renda Variável", "Titulo do Governo","Título emitido por securitizadoras" ,"Certificado de Depósito Bancário emitido por bancos"},
            {"Investimento de Renda Variável","Investimento ligado a commodities","Tesouro Direto é um título emitido pelo Governo Federal","Título emitido por corretoras de valores"},
    	        {"Investimento nas áreas Imobiliárias e do Agronegócio","Letra de crédito ao investidor amplo","Letra de Financeira", "Certicado de Operações estruturada"},

    };
  private String acerto[] = {"É um tipo de Título de dívida emitido por empresas privadas","é a modalidade mais segura para quem não quer perde o dinheiro investido e ganha rentabilidade em cima do valor",
"Uma forma de Captação financeira para as empresas","É uma intermediária que liga o investidor ao investimento","Esses ativos recebem essa denominação devido à rentabilidade que não pode ser pré-definida",
"Taxa básica de juro da economia do Brasil","Certificado de Depósito Bancário emitido por bancos","Tesouro Direto é um título emitido pelo Governo Federal","Investimento nas áreas Imobiliárias e do Agronegócio"};


     String getpergunta(int a){

       String pergunta = iPerguntas[a];

     return pergunta;
     }
 String escolha1(int a){
     String escolha = iescolhas[a][0];
     return escolha;
 }
        String escolha2(int a){
            String escolha = iescolhas[a][1];
            return escolha;
        }
        String escolha3(int a){
            String escolha = iescolhas[a][2];
            return escolha;
        }
        String escolha4(int a){
            String escolha = iescolhas[a][3];
            return escolha;
        }
        String getcorreta(int a){
            String correta = acerto[a];
            return correta;
        }

    }
}
