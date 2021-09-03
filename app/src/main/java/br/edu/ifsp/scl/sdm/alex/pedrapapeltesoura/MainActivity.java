package br.edu.ifsp.scl.sdm.alex.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import br.edu.ifsp.scl.sdm.alex.pedrapapeltesoura.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        activityMainBinding.pedraBt.setOnClickListener(this);
        activityMainBinding.papelBt.setOnClickListener(this);
        activityMainBinding.tesouraBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        jogarPaJoKenPo( view.getId());
    }

    public void jogarPaJoKenPo(int jogada){

        if(activityMainBinding.opcaoJogadoresRg.getCheckedRadioButtonId() == R.id.doisRb){

            activityMainBinding.jogadaComputador2Tv.setVisibility(View.INVISIBLE);
            activityMainBinding.jogadaComputador2Iv.setVisibility(View.INVISIBLE);

            Jogador maquina = new Jogador();
            Jogador usuario = new Jogador();
            String jMaquina = maquina.getJogada();
            maquina.setImagemJogada(jMaquina);

            String jogadaUsuario = usuario.getJogadaUsuario(Integer.toString(jogada));

            activityMainBinding.jogadaComputadorIv.setImageResource(Integer.parseInt(maquina.getImagemJogada()));

            if ((jMaquina == "pedra" && jogadaUsuario == "tesoura") ||
                    (jMaquina == "papel" && jogadaUsuario == "pedra") ||
                    (jMaquina == "tesoura" && jogadaUsuario =="papel")) {

                activityMainBinding.resultadoTV.setText("Você Perdeu :(");

            } else if (
                    (jogadaUsuario == "pedra" && jMaquina == "tesoura") ||
                            (jogadaUsuario == "papel" && jMaquina == "pedra") ||
                            (jogadaUsuario == "tesoura" && jMaquina == "papel")) {

                activityMainBinding.resultadoTV.setText("Você venceu :)");

            } else {

                activityMainBinding.resultadoTV.setText("Empatou :] ");

            }


        }else {

            activityMainBinding.jogadaComputador2Tv.setVisibility(View.VISIBLE);
            activityMainBinding.jogadaComputador2Iv.setVisibility(View.VISIBLE);

            Jogador usuario = new Jogador();
            Jogador maquina1 = new Jogador();
            Jogador maquina2 = new Jogador();

            String jogadaUsuario = usuario.getJogadaUsuario(Integer.toString(jogada));


            String jMaquina1 = maquina1.getJogada();
            String jMaquina2 = maquina2.getJogada();

            maquina1.setImagemJogada(jMaquina1);
            maquina2.setImagemJogada(jMaquina2);

            activityMainBinding.jogadaComputadorIv.setImageResource(Integer.parseInt(maquina1.getImagemJogada()));
            activityMainBinding.jogadaComputador2Iv.setImageResource(Integer.parseInt(maquina2.getImagemJogada()));

            //activityMainBinding.resultadoTV.setText("Usuario: "+ jogadaUsuario +" | Maquina 1: "+ jMaquina1 + " | Maquina 2: "+jMaquina2);


            if((jMaquina1 == "pedra" && jMaquina2 == "tesoura" && jogadaUsuario == "tesoura") ||
                    (jMaquina1 == "papel" && jMaquina2 == "pedra" && jogadaUsuario == "pedra") ||
                    (jMaquina1 == "tesoura" && jMaquina2 == "papel" && jogadaUsuario =="papel")) {

                activityMainBinding.resultadoTV.setText("Vencedor: Computador 1 ");

            }else if ((jMaquina2 == "pedra" && jMaquina1 == "tesoura" && jogadaUsuario == "tesoura") ||
                    (jMaquina2 == "papel" && jMaquina1 == "pedra" && jogadaUsuario == "pedra") ||
                    (jMaquina2 == "tesoura" && jMaquina1 == "papel" && jogadaUsuario =="papel")) {

                activityMainBinding.resultadoTV.setText("Vencedor: Computador 2 ");

            }else if ((jogadaUsuario == "pedra" && jMaquina1 == "tesoura" && jMaquina2 == "tesoura") ||
                    (jogadaUsuario == "papel" && jMaquina1 == "pedra" && jMaquina2 == "pedra") ||
                    (jogadaUsuario == "tesoura" && jMaquina1 == "papel" && jMaquina2 =="papel")) {

                activityMainBinding.resultadoTV.setText("Vencedor: Você Ganhou :)");


            }else{
                activityMainBinding.resultadoTV.setText("Empate :]");
            }

        }

    }
}