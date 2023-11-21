/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conexionbd;

import java.sql.*;
import java.util.Scanner;

public class ConexionBD {
    
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "andreu";
    static final String PASS = "1234";
    static final String QUERY = "SELECT * FROM videojuegos";
    
    
    public static void main(String[] args) {
        
        //METODO PARA BUSCAR JUEGO
        
        String nombreJuego="";
        Scanner teclado=new Scanner(System.in);
        try(
            Connection conn=DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt =conn.createStatement();
            ResultSet rs =stmt.executeQuery(QUERY);)
        {
            /*System.out.print("Introduce el nombre de juego: ");
            nombreJuego=teclado.nextLine();
            boolean retorno=buscaNombre(nombreJuego);
            if(retorno==true){
                System.out.println(nombreJuego+" existe en la BDD");
            }else{
                System.out.println("No se ha encontrado este juego");
            }*/
        
        //METODO PARA CONSULTA
            //lanzaConsulta();
        
        //METODO PARA NUEVO_REGISTRO_POR_PARAMETRO
            //nuevoRegistroParametro();
        
        //METODO PARA NUEVO_REGISTRO_POR_TECLADO
            nuevoRegistroTeclado();
                
            stmt.close();                
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static boolean buscaNombre(String nombreV){
        
        String nombre;
        boolean encuentra=false;
        
        try(
            Connection conn=DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt =conn.createStatement();
            ResultSet rs =stmt.executeQuery(QUERY);)
        {
            while(rs.next()){
                nombre=rs.getString("Nombre");  
                if(nombre.equals(nombreV)){
                    encuentra=true;
                    break;
                }else{
                    encuentra=false;
                }
            }            
            stmt.close();                
        }catch(SQLException e){
            e.printStackTrace();
        }       
        
        return encuentra;
    }
    
    public static void lanzaConsulta(){
        try(
            Connection conn=DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt =conn.createStatement();
            ResultSet rs =stmt.executeQuery(QUERY);)
        {  
            
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("Id"));
                System.out.println("Nombre: "+rs.getString("Nombre"));
                System.out.println("Gemero: "+rs.getString("Genero"));
                System.out.println("Fecha de lanzamiento: "+rs.getDate("FechaLanzamiento"));
                System.out.println("Compañia: "+rs.getString("Compañia"));
                System.out.println("Precio: "+rs.getFloat("Precio"));
                System.out.println("\n");
                              
            }                
            stmt.close();                
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void nuevoRegistroParametro(){
        
        try(
            Connection conn=DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt =conn.createStatement();
            ResultSet rs =stmt.executeQuery(QUERY);)
        {  
            String query="INSERT INTO `videojuegos` (`id`, `Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) VALUES (NULL, 'Call Of Duty Black Ops 2', 'Guerra', '2023-11-11', 'Activision', '70')";
            stmt.executeUpdate(query);
            System.out.println("Videjuego añadido");
                         
            stmt.close();                
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public static void nuevoRegistroTeclado(){
        String nombre="", genero="",fecha="", compañia="", precio="";
        Scanner teclado=new Scanner(System.in);
        try(
            Connection conn=DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt =conn.createStatement();
            ResultSet rs =stmt.executeQuery(QUERY);)
        {  
            System.out.println("Introduce los datos que te voy a pedir a continuacion:");
            
            System.out.print("Nombre: ");
            nombre=teclado.nextLine();
            System.out.println("\n");
            
            System.out.print("Genero: ");
            genero=teclado.nextLine();
            System.out.println("\n");
            
            System.out.print("Fecha de Lanzamiento(YYYY-MM-DD): ");
            fecha=teclado.nextLine();
            System.out.println("\n");
            
            System.out.print("Compañia: ");
            compañia=teclado.nextLine();
            System.out.println("\n");
            
            System.out.print("Precio: ");
            precio=teclado.nextLine();
            System.out.println("\n");
            
            String query="INSERT INTO `videojuegos` (`id`, `Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) VALUES (NULL, '"+nombre+"', '"+genero+"', '"+fecha+"', '"+compañia+"', '"+precio+"')";
            stmt.executeUpdate(query);
            System.out.println("Videjuego añadido");
                         
            stmt.close();                
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
            
}
