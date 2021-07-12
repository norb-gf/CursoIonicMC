package com.ngf.cursoionic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ngf.cursoionic.domain.Categoria;
import com.ngf.cursoionic.domain.Cidade;
import com.ngf.cursoionic.domain.Cliente;
import com.ngf.cursoionic.domain.Endereco;
import com.ngf.cursoionic.domain.Estado;
import com.ngf.cursoionic.domain.Produto;
import com.ngf.cursoionic.domain.enums.TipoCliente;
import com.ngf.cursoionic.repositories.CategoriaRepository;
import com.ngf.cursoionic.repositories.CidadeRepository;
import com.ngf.cursoionic.repositories.ClienteRepository;
import com.ngf.cursoionic.repositories.EnderecoRepository;
import com.ngf.cursoionic.repositories.EstadoRepository;
import com.ngf.cursoionic.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoIonicApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;	
	@Autowired
	private CidadeRepository cidadeRepository;	
	@Autowired
	private EstadoRepository estadoRepository;	
	@Autowired
	private ClienteRepository clienteRepository;	
	@Autowired
	private EnderecoRepository enderecoRepository;	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoIonicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");

		Cidade c1 = new Cidade(null,"UBerlândia",est1);
		Cidade c2 = new Cidade(null,"Santos",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSSOA_FíSICA);
		
		cli1.getTelefones().addAll(Arrays.asList("12345654","987654321"));
		
		Endereco e1 = new Endereco(null, "Rua Flores","300","apto 123","Jardim","38220834",cli1,c1);
		Endereco e2 = new Endereco(null, "Avenida Matos","105","Sala 800","Centro","38777012",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	
	}
}