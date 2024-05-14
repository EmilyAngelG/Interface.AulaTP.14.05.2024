/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.model.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Persistencia {
    
    //Main para teste:
    public static void main (String[] args) throws IOException{
    
        //lista.add(new Usuario("Emily", "LoginEmily", "senhaEmily"));
        //exibirUsuarios(lista);      
        //gravarArquivo(lista, "C:\\Users\\FATEC ZONA LESTE\\Documents\\NetBeansProjects\\InterfaceGrafica\\src\\br\\com\\fatec\\controller\\arquivoUsuarios.txt");
        
        lerArquivo("C:\\Users\\FATEC ZONA LESTE\\Documents\\NetBeansProjects\\InterfaceGrafica\\src\\br\\com\\fatec\\controller\\arquivoUsuarios.txt",lista);        
        exibirUsuarios(lista);
        
    }
    
    //Vamos usar uma lista para simular a persistencia
    public static ArrayList<Usuario> lista = new ArrayList<>();
    
    public static void exibirUsuarios(ArrayList<Usuario> lista){
        System.out.println(lista);
    }
            
            
    //O ideal é criar métodos para manipular as classes
    public static boolean cadastrar(Usuario user){
        if(user != null){ 
            lista.add(user);
            return true;
        }else{ 
            return false; 
        }     
    }
    
    //Para configurar os eventos de Gravar e Importar em arquivo
    //vamos adicionar os métodos apropriados de manipulação de arquivo
    
    public static void gravarArquivo (ArrayList<Usuario> listaUsuarios, String arquivoUsuarios) throws IOException{       
        FileWriter arquivo = new FileWriter(arquivoUsuarios); //cria objetivo do tipo arquivo
        PrintWriter gravarArquivo = new PrintWriter(arquivo); //habilita arquivo para ser gravado
        
        //percorre a lista e grava no arquivo
        for(Usuario usuario: listaUsuarios) {
            gravarArquivo.println(usuario);
        }
        
        gravarArquivo.close();//fecha o arquivo
    }
    
    public static void lerArquivo (String arquivoUsuarios, ArrayList<Usuario> listaUsuarios) {
        try{
            FileReader arquivo = new FileReader(arquivoUsuarios); // objeto do tipo arquivo para leitura
            BufferedReader lerArquivo = new BufferedReader(arquivo); //buffer para leitura
            String nome = lerArquivo.readLine(); // lê a primeira linha           
            String login;
            String senha;
            
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
            while (nome != null) {
                login = lerArquivo.readLine(); // lê da segunda até a última linha  
                senha = lerArquivo.readLine();
                listaUsuarios.add(new Usuario(nome, login, senha));
                nome = lerArquivo.readLine();
                
            }
            arquivo.close();
            
        }catch (IOException e){
            System.err.printf("Erro na abertura do arquivo: %s.", e.getMessage());
        }
    }
    
}
