package br.com.brener.TabelaFipe.principal;

import br.com.brener.TabelaFipe.model.Dados;
import br.com.brener.TabelaFipe.service.ConsumoApi;
import br.com.brener.TabelaFipe.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";


    public void exibeMenu() {
        var menu = """
                ****** OPÇÕES ******
                Carro
                Moto
                Caminhão
                
                Digite uma das opções para consultar:
                """;
        System.out.println(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if (opcao.toLowerCase().contains("carr") | opcao.toLowerCase().contains("car")) {
            endereco = URL_BASE + "carros/marcas";
        } else if ((opcao.toLowerCase().contains("mot")) | opcao.toUpperCase().contains("mo")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);
        var marcas = conversor.obterLista(json, Dados.class);

    }
}
