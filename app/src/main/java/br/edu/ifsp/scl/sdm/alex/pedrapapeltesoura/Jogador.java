package br.edu.ifsp.scl.sdm.alex.pedrapapeltesoura;

import java.util.Random;

public class Jogador {
    private String nome;
    private String jogada;
    private String imagemJogada;
    private String jogadaUsuario;

    public String getJogadaUsuario(String jogada) {

        switch (Integer.parseInt(jogada)){
            case R.id.pedraBt:
                jogadaUsuario = "pedra";
                break;
            case R.id.papelBt:
                jogadaUsuario = "papel";
                break;
            case R.id.tesouraBt:
                jogadaUsuario = "tesoura";
                break;
            default:
                break;
        }


        return jogadaUsuario;
    }

    public void setJogadaUsuario(String jogadaUsuario) {
        this.jogadaUsuario = jogadaUsuario;
    }

    public String getImagemJogada() {
        return imagemJogada;
    }

    public void setImagemJogada(String imagemJogada) {

        Integer imagemJogadaComputadorId = -1;
        switch (imagemJogada) {
            case "pedra":
                imagemJogadaComputadorId = R.mipmap.pedra;
                break;
            case "papel":
                imagemJogadaComputadorId = R.mipmap.papel;
                break;
            case "tesoura":
                imagemJogadaComputadorId = R.mipmap.tesoura;
                break;
        }
        imagemJogada = Integer.toString(imagemJogadaComputadorId);


        this.imagemJogada = imagemJogada;
    }

    public String getJogada() {

        int jogadaComputador = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        jogada = opcoes[jogadaComputador];

        return jogada;
    }

    public void setJogada(String jogada) {
        this.jogada = jogada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
