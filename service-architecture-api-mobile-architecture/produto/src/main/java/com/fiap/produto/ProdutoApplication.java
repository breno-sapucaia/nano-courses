package com.fiap.produto;

import com.fiap.produto.domain.Product;
import com.fiap.produto.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdutoApplication implements CommandLineRunner {
	@Autowired
	private CatalogService catalogService;
	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}

	@Override
	public void run (final String... args){
		line();
		System.out.println("ProdutoApplication.run");
		line();
		System.out.println("Criar produto");
		final Product add = catalogService.add("produto 1", "Descrição 1");
		System.out.println(add);
		line();
	}

	private void line(){
		System.out.println();
		System.out.println("=========================================");
		System.out.println();
	}

}
