package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leerTeclado=new Scanner(System.in);
        // Menu de opciones
        System.out.println("CINE COLOMBIS");
        System.out.println("****************");
        System.out.println("1. Agrgar Pelicula:");
        System.out.println("2. Buscar todas las peliculas disponibles:");
        System.out.println("3. buscar una pelicula por nombre:");
        System.out.println("4. modificar la clasificación de una pelicula:");
        System.out.println("0. Salir");
        System.out.println("****************");

        //creando un menu de opciones en JAVA
        int opcionElegida;
        ArrayList<HashMap<String,Object>> peliculas=new ArrayList<>();
        do {
            HashMap<String,Object>pelicula=new HashMap<>();
            System.out.print("Digita una opción: ");
            opcionElegida=leerTeclado.nextInt();
            // limpiando el buffer
            leerTeclado.nextLine();

            if (opcionElegida==1){
                System.out.println("ingresando pelicula");
                System.out.print("ingresa el nombre de la pelicula: ");
                String nombrePelicula=leerTeclado.nextLine();
                System.out.print("Ingresa la duracion la pelicula HH:MM : ");
                String duracionPelicula=leerTeclado.nextLine();
                System.out.print("Ingresa la clasificacion de la pelicula: ");
                String clasificacionPelicula=leerTeclado.nextLine();
                System.out.print("Ingresa la sinopsis de la pelicula: ");
                String sinopsisPelicula=leerTeclado.nextLine();
                System.out.print("Ingresa la defha de estreno pelicula en formato AAAA-MM-DD: ");
                String fechaTexto=leerTeclado.nextLine();
                LocalDate fecha= LocalDate.parse(fechaTexto);
                System.out.println("la fecha ingresada es"+fecha);

                int idPelicula=new Random().nextInt(100);

                //llenando el objeto
                pelicula.put("nombre",nombrePelicula);
                pelicula.put("duracion",duracionPelicula);
                pelicula.put("clasificacion",clasificacionPelicula);
                pelicula.put("fechaestreno",fecha);
                pelicula.put("id", idPelicula);

                //llenando el arreglo
                peliculas.add(pelicula);



            }else if (opcionElegida==2) {
                System.out.println("mostrar todas las peliculas");
                for (HashMap<String,Object>productoauxiliar:peliculas){
                    System.out.println(productoauxiliar);
                }

            }
            else if (opcionElegida==3) {
                //System.out.print("buscar producto");
                // limpiando el buffer
                //leerTeclado.nextLine();
                // para buscar en un arreglo necesito el indice que estoy buscando, no necesariamente
                // necesito recorrer el arreglo e ir comparando con lo que busco hasta encontrarlo
                System.out.println("Digita el nombre de la pelicula que quieres buscar: ");
                String nombrePeliculaABuscar=leerTeclado.nextLine();

                // recorriendo el arreglo para buscar
                for (HashMap<String,Object> productoAuxiliar:peliculas){
                    //System.out.println(productoAuxiliar);
                    // comparar si el nombre que encontro el auxiliar es el que digitó el usuario
                    if (nombrePeliculaABuscar.equals(productoAuxiliar.get("nombre"))){
                        System.out.println("pelicula encontrada");
                        // mostra la informacion del producto que se encontro
                        System.out.println(productoAuxiliar);

                    }

                }

            }
            else if (opcionElegida==4) {
                //System.out.println("modificar producto");
                // limpiando el buffer
                //leerTeclado.nextLine();
                // para buscar en un arreglo necesito el indice que estoy buscando, no necesariamente
                // necesito recorrer el arreglo e ir comparando con lo que busco hasta encontrarlo
                System.out.println("Digita el nombre de la pelicula que quiere modificar la sinopsis: ");
                String nombrePeliculaAModificar = leerTeclado.nextLine();

                // recorriendo el arreglo para buscar
                for (HashMap<String, Object> productoAuxiliar : peliculas) {
                    System.out.println(productoAuxiliar.get("nombre"));
                    // comparar si el nombre que encontro el auxiliar es el que digitó el usuario
                    if (nombrePeliculaAModificar.equals(productoAuxiliar.get("nombre"))) {
                        System.out.println("pelicula encontrada");
                        // mostra la informacion del producto que se encontro
                        System.out.println(productoAuxiliar);
                        //como encontrar el indice del producto auxiliar
                        // si es necesario encontrar el indice
                        System.out.print("ingresa la nueva sinopsis de la pelicula");
                        String nuevoSinopsisPelicula = leerTeclado.nextLine();


                        productoAuxiliar.put("sinopsis", nuevoSinopsisPelicula);

                    }
                }
            }
            else if (opcionElegida==0){
                System.out.println("saliendo");
            }
            else {
                System.out.println("opcion invalida");
            }



        }while (opcionElegida!=0);
        for (HashMap<String,Object>productoauxiliar:peliculas){
            System.out.println(productoauxiliar);
        }


    }
}