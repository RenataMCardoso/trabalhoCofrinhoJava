package uninter;

import java.util.Scanner;

public class Menu {
	
	private Scanner sc;
	private Cofrinho cofrinho;	
	
	public Menu() {
		sc = new Scanner(System.in);
		cofrinho = new Cofrinho();
		
	}
	
	public void exibirMenuPrincipal() {
		System.out.println("Bem vindo ao Cofrinho da Renata Moraes Cardoso RU 4362789 ^^)");
		System.out.println("MENU DO COFRINHO:");
		System.out.println("1-Adicionar moeda");
		System.out.println("2-Remover moeda");
		System.out.println("3-Listar moedas");
		System.out.println("4-Calcular valor total convertido para real");
		System.out.println("0-Encerrar");
		
		String opcaoSelecionada = sc.next();
		
		switch(opcaoSelecionada) {
			
			case "0":
				System.out.println("Obrigada por utilizar o Cofrinho da Renata, até mais!");
				System.out.println("Programa encerrado!");
				break;
			
			case "1":
				
				System.out.println("Escolha Moeda:");
				System.out.println("1 - Real:");
				System.out.println("2 - Dolar:");
				System.out.println("3 - Euro:");
				
				int opcaoMoeda = sc.nextInt();
				
				System.out.println("Digite o valor");
				String valorTextoMoeda = sc.next();
				
				//Caso seja digitado uma virgula no valor digitado pela pessoa, será modificado para ponto
				valorTextoMoeda =valorTextoMoeda.replace(",",".");	
				
				//Aqui modificamos a string com ponto para double pois o meu valor la na classe moeda está em double
				double valorMoeda = Double.valueOf(valorTextoMoeda);
				
				
				if (opcaoMoeda == 1) {
					Real moeda = new Real(valorMoeda);
					cofrinho.adicionar(moeda);
				}
				else if (opcaoMoeda == 2) {
					Dolar moeda = new Dolar(valorMoeda);
					cofrinho.adicionar(moeda);
				}
				else if (opcaoMoeda == 3) {
					Euro moeda = new Euro(valorMoeda);
					cofrinho.adicionar(moeda);
				}
				else {
					System.out.println("Não existe essa moeda!");
					exibirMenuPrincipal();
				}									
											
				exibirMenuPrincipal();
				break;
				
			case "2":
				//Coloquei como sub menu mais a baixo, pois estava ficando com muita informação e poluido visualmente.
				exibirSubMenuRemoverMoedas();
				exibirMenuPrincipal();
				
				break;
				
			case "3":
				cofrinho.listagemMoedas();
				exibirMenuPrincipal();
				break;
				
							
			case "4":
				double valorTotalConvertido = cofrinho.totalConvertido();
				System.out.println("O valor total convertido para real é: " + valorTotalConvertido);
				exibirMenuPrincipal();
				break;
				
				
			default:
				System.out.println("Opção Inválida!");
				exibirMenuPrincipal();
				break;
		
		}
	}
			private void exibirSubMenuRemoverMoedas() {
				System.out.println("Escolha Moeda:");
				System.out.println("1 - Real:");
				System.out.println("2 - Dolar:");
				System.out.println("3 - Euro:");
				
				int opcaoMoeda = sc.nextInt();
				//salvando em string só para trocar virgulas por pontos
				System.out.println("Digite o valor");
				String valorTextoMoeda = sc.next();
				
				//Opção apenas para trocar virgula por ponto, caso a pessoa digitasse com virgula o valor da moeda.
				valorTextoMoeda =valorTextoMoeda.replace(",",".");	
				
				//Colocando como double a string digitada pela pessoa.
				double valorMoeda = Double.valueOf(valorTextoMoeda);
				
				
				if (opcaoMoeda == 1) {
					Moeda moeda = new Real(valorMoeda);
					cofrinho.remover(moeda);
					
				}
				else if (opcaoMoeda == 2) {
					Moeda moeda = new Dolar(valorMoeda);
					cofrinho.remover(moeda);
					
				}
				else if (opcaoMoeda == 3) {
					Moeda moeda = new Euro(valorMoeda);
					cofrinho.remover(moeda);
					
				}
				else {
					System.out.println("Moeda não encontrada!");
					exibirMenuPrincipal();
				}	
				
												
				exibirMenuPrincipal();
				
			}
				

}
