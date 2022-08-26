package maven.demo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static Scanner sc = new Scanner(System.in);
	
	public static void inserir(DAO dao) {
		System.out.println("codigo: ");
		int codigo = sc.nextInt();
		
		System.out.println("login: ");
		String login = sc.next();
		
		System.out.println("senha: ");
		String senha = sc.next();
		
		System.out.println("sexo: ");
		char sexo = sc.next().charAt(0); 
		
		Usuario user = new Usuario(codigo, login, senha, sexo);
		
		if(dao.insert(user)) {
			System.out.println("Usuario inserido com sucesso");
		} else {
			System.out.println("Ocorreu um erro ao inserir");
		}
	}
	
	public static void atualizar(DAO dao) {
		System.out.println("codigo: ");
		int codigo = sc.nextInt();
		
		System.out.println("login: ");
		String login = sc.next();
		
		System.out.println("senha: ");
		String senha = sc.next();
		
		System.out.println("sexo: ");
		char sexo = sc.next().charAt(0); 
		
		Usuario user = new Usuario(codigo, login, senha, sexo);
		
		if(dao.update(user)) {
			System.out.println("Usuario atualizado com sucesso");
		} else {
			System.out.println("Ocorreu um erro ao atualizar");
		}
	}
	
	public static void deletar(DAO dao) {
		System.out.print("codigo: ");
		int codigo = sc.nextInt();
		if(dao.delete(codigo)) {
			System.out.println("Usuario deletado com sucesso");
		} else {
			System.out.println("Ocorreu um erro ao deletar");
		}
	}
	
	public static void listar(DAO dao) {
		List<Usuario> users = dao.get();
		
		System.out.println("Usuarios: ");
		
		for(int i = 0; i < users.size(); i++) {
			Usuario currentUser = users.get(i);
			System.out.println("codigo: " + currentUser.getCodigo() + ", login: " +
			                   currentUser.getLogin() + ", senha: " + currentUser.getSenha() +
			                   " sexo: " + currentUser.getSexo());
		}
		
		System.out.println("");
	}
	
	public static void menu(DAO dao) {
		int n;
		
		do {			
			System.out.println("1) Listar");
			System.out.println("2) Inserir");
			System.out.println("3) Excluir");
			System.out.println("4) Atualizar");
			System.out.println("5) Sair");
			
			n = sc.nextInt();
			
			switch(n) {
				case 1: listar(dao); break;
				case 2: inserir(dao); break;
				case 3: deletar(dao); break;
				case 4: atualizar(dao); break;
				case 5: break;
				default: break;
			}
		}while(n != 5);
	}
	
	public static void main(String[] args) throws Exception {
		DAO dao = new DAO();
		dao.conectar();
		
		menu(dao);
		
		dao.close();
		
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		
//		System.out.println("\n\n==== Inserir usuário === ");
//		Usuario usuario = new Usuario(11, "pablo", "pablo",'M');
//		if(usuarioDAO.insert(usuario) == true) {
//			System.out.println("Inserção com sucesso -> " + usuario.toString());
//		}
//		
//		System.out.println("\n\n==== Testando autenticação ===");
//		System.out.println("Usuário (" + usuario.getLogin() + "): " + usuarioDAO.autenticar("pablo", "pablo"));
//			
//		System.out.println("\n\n==== Mostrar usuários do sexo masculino === ");
//		List<Usuario> usuarios = usuarioDAO.getSexoMasculino();
//		for (Usuario u: usuarios) {
//			System.out.println(u.toString());
//		}
//
//		System.out.println("\n\n==== Atualizar senha (código (" + usuario.getCodigo() + ") === ");
//		usuario.setSenha(DAO.toMD5("pablo"));
//		usuarioDAO.update(usuario);
//		
//		System.out.println("\n\n==== Testando autenticação ===");
//		System.out.println("Usuário (" + usuario.getLogin() + "): " + usuarioDAO.autenticar("pablo", DAO.toMD5("pablo")));		
//		
//		System.out.println("\n\n==== Invadir usando SQL Injection ===");
//		System.out.println("Usuário (" + usuario.getLogin() + "): " + usuarioDAO.autenticar("pablo", "x' OR 'x' LIKE 'x"));
//
//		System.out.println("\n\n==== Mostrar usuários ordenados por código === ");
//		usuarios = usuarioDAO.getOrderByCodigo();
//		for (Usuario u: usuarios) {
//			System.out.println(u.toString());
//		}
//		
//		System.out.println("\n\n==== Excluir usuário (código " + usuario.getCodigo() + ") === ");
//		usuarioDAO.delete(usuario.getCodigo());
//		
//		System.out.println("\n\n==== Mostrar usuários ordenados por login === ");
//		usuarios = usuarioDAO.getOrderByLogin();
//		for (Usuario u: usuarios) {
//			System.out.println(u.toString());
//		}
	}
}
