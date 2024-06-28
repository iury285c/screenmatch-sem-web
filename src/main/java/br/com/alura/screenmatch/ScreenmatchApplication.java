package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSeries;
import br.com.alura.screenmatch.service.ConsumiApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);

	}

	public void run(String... args) throws Exception {
		var consumiApi = new ConsumiApi();
		var json = consumiApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		//json = consumiApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		//System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSeries dados = conversor.obterDados(json, DadosSeries.class);
		System.out.println(dados);
	}
}
