package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Utils.Conexao;
import org.example.Utils.GeradorJson;
import org.example.Utils.Verificacao;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Entrada do cep
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o Cep que deseja buscar");
        String cep = scanner.nextLine();

        //Verificação de possiveis erros na entrada do usuário
        if (cep.length() == 8 && cep.matches("[0-9]+")) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            Conexao conexao = new Conexao();
            conexao.conectar(cep);

            //Verifica se o cep foi encontrado na base dados da api
            Verificacao verificacao = gson.fromJson(conexao.getBody(), Verificacao.class);

            if (verificacao.erro() == false) {
                GeradorJson gerador = new GeradorJson();
                gerador.geradorTxt(conexao.getBody(), verificacao.cep());
                System.out.println("CEP encontrado com sucesso e arquivo gerado! Verifique o arquivo .txt gerado.");
            } else {
                System.out.println("CEP não encontrado, verifique se o CEP foi digitado corretamente");
            }


        } else {
            System.out.println("Cep inválido, digite apenas os 8 numeros" +
                    " do Cep sem caracteres especiais e tente novamente");
        }


    }
}