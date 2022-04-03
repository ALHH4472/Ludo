
package ludo;

import java.util.Scanner;

public class Ludo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Dado dado = new Dado();
        int jugadores = 0;
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        Jugador ganador;
        ganador = null;
        
        System.out.println("----------Bienvenido----------");
        System.out.println("");
        System.out.println("¿Cuantos jugadores van a jugar? (2-4)");
        jugadores = entrada.nextInt();
        System.out.println("");
        
        switch(jugadores){
            
            case 2:
                jugador1.play = true;
                jugador2.play = true;
                System.out.println("¡Preparados los dos jugadores!");
                System.out.println("");
                break;
           
            case 3: 
                jugador1.play = true;
                jugador2.play = true;
                jugador3.play = true;
                System.out.println("¡Preparados los tres jugadores!");
                System.out.println("");
                break;
            
            case 4:
                jugador1.play = true;
                jugador2.play = true;
                jugador3.play = true;
                jugador4.play = true;
                System.out.println("¡Preparados los cuatro jugadores!");
                System.out.println("");
                break;
           
            default:
                System.out.println("Opción no válida");
                System.out.println("");
                break;
            
        }
        
        if (!jugador1.play && !jugador2.play){
            System.out.println("Ingrese nuevamente la cantidad de jugadores");
            System.out.println("");
        }else{
            while(ganador == null){
                if (jugador1.play){

                    System.out.println("Es el turno del \033[33m Jugador 1\u001B[0m");
                    System.out.println("");
                    System.out.println("Tienes "+jugador1.fichaenCasa+" Fichas en la meta");
                    
                    
                    
                    int J1O = 0;
                  do{
                      System.out.println("1<----------Lanzar el dado");
                      System.out.println("2<----------Abandonar partida");
                      System.out.println("");
                      J1O = entrada.nextInt();
                      
                      switch(J1O){
                          case 1:
                              dado.lanzar();
                              System.out.println("El dado cae y muestra el numero "+dado.numero);
                              break;
                          case 2:
                              jugador1.play = false;
                              break;
                          default:
                              System.out.println("Opcion invalida");
                      }
                      if(jugador1.ficha1.casilla==0 && jugador1.ficha2.casilla==0 && jugador1.ficha3.casilla==0 && jugador1.ficha4.casilla==0){
                            System.out.println("Todas tus Fichas están en la base.");
                            System.out.println("");
                        if (dado.numero == 6 || dado.numero == 1){
                            jugador1.ficha1.move = true;
                            jugador1.ficha2.move = true;
                            jugador1.ficha3.move = true;
                            jugador1.ficha4.move = true;
                        }else{
                            jugador1.ficha1.move = false;
                            jugador1.ficha2.move = false;
                            jugador1.ficha3.move = false;
                            jugador1.ficha4.move = false; 
                        }
                    }else{
                  
                  if (jugador1.ficha1.home){
                      if(jugador1.ficha1.casilla==76 && jugador1.ficha1.home){
                          
                            System.out.println("La \033[33mFicha 1\u001B[0m ya llegó a la meta");
                            System.out.println("");
                            jugador1.ficha1.move = false;
                            
                      }else if(jugador1.ficha1.casilla<76 && jugador1.ficha1.home){
                          System.out.println("La \033[33mFicha 1\u001B[0m está en casa, a "+(76-jugador1.ficha1.casilla)+" de la meta");
                          System.out.println("");
                          jugador1.ficha1.move = (76-jugador1.ficha1.casilla) >= dado.numero;
                      }
                  }else{
                      if(jugador1.ficha1.casilla==0 && !jugador1.ficha1.home){
                        System.out.println("La \033[33mFicha 1\u001B[0m esta en la base");
                        System.out.println("");
                        jugador1.ficha1.move = dado.numero==6 || dado.numero==1;
                      }else if(jugador1.ficha1.casilla<76 && jugador1.ficha1.casilla>0 && !jugador1.ficha1.home){
                          System.out.println("La \033[33mFicha 1\u001B[0m está en la casilla "+jugador1.ficha1.casilla);
                          jugador1.ficha1.move = true;
                      }
                  }
                  
                  if (jugador1.ficha2.home){
                      if(jugador1.ficha2.casilla==76 && jugador1.ficha2.home){
                          
                            System.out.println("La \033[33mFicha 2\u001B[0m ya llegó a la meta");
                            System.out.println("");
                            jugador1.ficha2.move = false;
                            
                      }else if(jugador1.ficha2.casilla<76 && jugador1.ficha2.home){
                          System.out.println("La \033[33mFicha 2\u001B[0m está en casa, a "+(76-jugador1.ficha2.casilla)+" de la meta");
                          System.out.println("");
                          jugador1.ficha2.move = (76-jugador1.ficha2.casilla) >= dado.numero;
                      }
                  }else{
                      if(jugador1.ficha2.casilla==0 && !jugador1.ficha2.home){
                        System.out.println("La \033[33mFicha 2\u001B[0m esta en la base");
                        System.out.println("");
                        jugador1.ficha2.move = dado.numero==6 || dado.numero==1;
                      }else if(jugador1.ficha2.casilla<76 && jugador1.ficha2.casilla>0 && !jugador1.ficha2.home){
                          System.out.println("La \033[33mFicha 2\u001B[0m está en la casilla "+jugador1.ficha2.casilla);
                          jugador1.ficha2.move = true;
                      }
                  }
                  
                   if (jugador1.ficha3.home){
                      if(jugador1.ficha3.casilla==76 && jugador1.ficha3.home){
                          
                            System.out.println("La \033[33mFicha 3\u001B[0m ya llegó a la meta");
                            System.out.println("");
                            jugador1.ficha3.move = false;
                            
                      }else if(jugador1.ficha3.casilla<76 && jugador1.ficha3.home){
                          System.out.println("La \033[33mFicha 3\u001B[0m está en casa, a "+(76-jugador1.ficha3.casilla)+" de la meta");
                          System.out.println("");
                          jugador1.ficha3.move = 76-jugador1.ficha3.casilla >= dado.numero;
                      }
                  }else{
                      if(jugador1.ficha3.casilla==0 && !jugador1.ficha3.home){
                        System.out.println("La \033[33mFicha 3\u001B[0m esta en la base");
                        System.out.println("");
                        jugador1.ficha3.move = dado.numero==6 || dado.numero==1;
                      }else if(jugador1.ficha3.casilla<76 && jugador1.ficha3.casilla>0 && !jugador1.ficha3.home){
                          System.out.println("La \033[33mFicha 3\u001B[0m está en la casilla "+jugador1.ficha3.casilla);
                          jugador1.ficha3.move = true;
                      }
                  }
                   if (jugador1.ficha4.home){
                      if(jugador1.ficha4.casilla==76 && jugador1.ficha4.home){
                          
                            System.out.println("La \033[33mFicha 4\u001B[0m ya llegó a la meta");
                            System.out.println("");
                            jugador1.ficha4.move = false;
                            
                      }else if(jugador1.ficha4.casilla<76 && jugador1.ficha4.home){
                          System.out.println("La \033[33mFicha 4\u001B[0m está en casa, a "+(76-jugador1.ficha4.casilla)+" de la meta");
                          System.out.println("");
                          jugador1.ficha4.move = (76-jugador1.ficha4.casilla) >= dado.numero;
                      }
                  }else{
                      if(jugador1.ficha4.casilla==0 && !jugador1.ficha4.home){
                        System.out.println("La \033[33mFicha 4\u001B[0m esta en la base");
                        System.out.println("");
                        jugador1.ficha4.move = dado.numero==6 || dado.numero==1;
                      }else if(jugador1.ficha4.casilla<76 && jugador1.ficha4.casilla>0 && !jugador1.ficha4.home){
                          System.out.println("La \033[33mFicha 4\u001B[0m está en la casilla "+jugador1.ficha4.casilla);
                          jugador1.ficha4.move = true;
                      }
                  }
                  
                    }
                     if (!jugador1.ficha1.move && !jugador1.ficha2.move && !jugador1.ficha3.move && !jugador1.ficha4.move){
                         System.out.println("No puedes mover ninguna ficha, lo siento");
                         System.out.println("");
                     }else{
                      System.out.println("¿Qué ficha deseas mover?");
                      System.out.println("");
                      
                      
                      Boolean move = false;
                      while(!move){
                      if (jugador1.ficha1.move){
                          System.out.println("1<----------Mover \033[33mFicha 1\u001B[0m");
                      }else{
                          System.out.println("No se puede mover la \033[33mFicha 1\u001B[0m");
                      }
                      
                      if (jugador1.ficha2.move){
                          System.out.println("2<----------Mover \033[33mFicha 2\u001B[0m");
                      }else{
                          System.out.println("No se puede mover la \033[33mFicha 2\u001B[0m");
                      }
                      
                      if (jugador1.ficha3.move){
                          System.out.println("3<----------Mover \033[33mFicha 3\u001B[0m");
                      }else{
                          System.out.println("No se puede mover la \033[33mFicha 3\u001B[0m");
                      }
                      
                      if (jugador1.ficha4.move){
                          System.out.println("4<----------Mover \033[33mFicha 4\u001B[0m");
                      }else{
                          System.out.println("No se puede mover la \033[33mFicha 4\u001B[0m");
                      }
                      
                      int FM1 = entrada.nextInt();
                      
                      
                      switch(FM1){
                          
                          case 1: 
                              if  (jugador1.ficha1.move){
                                  System.out.println("Se mueve la \033[33mFicha 1\u001B[0m...");
                                  if (jugador1.ficha1.home){
                                      jugador1.ficha1.casilla+=dado.numero;
                                      move = true;
                                      if(jugador1.ficha1.casilla==76){
                                          System.out.println("La \033[33mFicha 1\u001B[0m ha llegado a la meta");
                                          jugador1.fichaenCasa++;
                                      }else{
                                          
                                          System.out.println("La \033[33mFicha 1\u001B[0m está en la casa, a"+(76-jugador1.ficha1.casilla)+" de la meta");
                                          
                                      }
                                      
                                  }else if(jugador1.ficha1.casilla==0){
                                      jugador1.ficha1.casilla=5;
                                      System.out.println("La \033[33mFicha 1\u001B[0m salió a la casilla "+jugador1.ficha1.casilla);
                                      move = true;
                                  } else{
                                      jugador1.ficha1.casilla+=dado.numero;
                                      System.out.println("Ahora, \033[33mFicha 1\u001B[0m está en la casilla "+jugador1.ficha1.casilla);
                                      move = true;
                                      
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador2.ficha1.casilla && !jugador2.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador2.ficha2.casilla && !jugador2.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador2.ficha3.casilla && !jugador2.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador2.ficha4.casilla && !jugador2.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador3.ficha1.casilla && !jugador3.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador3.ficha2.casilla && !jugador3.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador3.ficha3.casilla && !jugador3.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador3.ficha4.casilla && !jugador3.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador4.ficha1.casilla && !jugador4.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador4.ficha2.casilla && !jugador4.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador4.ficha3.casilla && !jugador4.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha1.casilla==jugador4.ficha4.casilla && !jugador4.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                  }
                                     
                              }else{
                                  System.out.println("No se puede mover la \033[33mFicha 1\u001B[0m");
                                  System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                              }
                              break;
                        case 2: 
                              if  (jugador1.ficha2.move){
                                  System.out.println("Se mueve la \033[33mFicha 2\u001B[0m...");
                                  if (jugador1.ficha2.home){
                                      jugador1.ficha2.casilla+=dado.numero;
                                      move = true;
                                      if(jugador1.ficha2.casilla==76){
                                          System.out.println("La \033[33mFicha 2\u001B[0m ha llegado a la meta");
                                          jugador1.fichaenCasa++;
                                      }else{
                                          
                                          System.out.println("La \033[33mFicha 2\u001B[0m está en la casa, a"+(76-jugador1.ficha2.casilla)+" de la meta");
                                          
                                      }
                                      
                                  }else if(jugador1.ficha2.casilla==0){
                                      jugador1.ficha2.casilla=5;
                                      System.out.println("La \033[33mFicha 2\u001B[0m salió a la casilla "+jugador1.ficha2.casilla);
                                      move = true;
                                  } else{
                                      jugador1.ficha2.casilla+=dado.numero;
                                      System.out.println("Ahora, \033[33mFicha 2\u001B[0m está en la casilla "+jugador1.ficha2.casilla);
                                      move = true;
                                      
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador2.ficha1.casilla && !jugador2.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador2.ficha2.casilla && !jugador2.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador2.ficha3.casilla && !jugador2.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador2.ficha4.casilla && !jugador2.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador3.ficha1.casilla && !jugador3.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador3.ficha2.casilla && !jugador3.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador3.ficha3.casilla && !jugador3.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador3.ficha4.casilla && !jugador3.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador4.ficha1.casilla && !jugador4.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador4.ficha2.casilla && !jugador4.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador4.ficha3.casilla && !jugador4.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha2.casilla==jugador4.ficha4.casilla && !jugador4.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                  }
                                     
                              }else{
                                  System.out.println("No se puede mover la \033[33mFicha 2\u001B[0m");
                                  System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                              }
                              break;
                         
                        case 3:
                            if  (jugador1.ficha3.move){
                                  System.out.println("Se mueve la \033[33mFicha 3\u001B[0m...");
                                  if (jugador1.ficha3.home){
                                      jugador1.ficha3.casilla+=dado.numero;
                                      move = true;
                                      if(jugador1.ficha3.casilla==76){
                                          System.out.println("La \033[33mFicha 3\u001B[0m ha llegado a la meta");
                                          jugador1.fichaenCasa++;
                                      }else{
                                          
                                          System.out.println("La \033[33mFicha 3\u001B[0m está en la casa, a"+(76-jugador1.ficha3.casilla)+" de la meta");
                                          
                                      }
                                      
                                  }else if(jugador1.ficha3.casilla==0){
                                      jugador1.ficha3.casilla=5;
                                      System.out.println("La \033[33mFicha 3\u001B[0m salió a la casilla "+jugador1.ficha3.casilla);
                                      move = true;
                                  } else{
                                      jugador1.ficha3.casilla+=dado.numero;
                                      System.out.println("Ahora, \033[33mFicha 3\u001B[0m está en la casilla "+jugador1.ficha3.casilla);
                                      move = true;
                                      
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador2.ficha1.casilla && !jugador2.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador2.ficha2.casilla && !jugador2.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador2.ficha3.casilla && !jugador2.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador2.ficha4.casilla && !jugador2.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador3.ficha1.casilla && !jugador3.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador3.ficha2.casilla && !jugador3.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador3.ficha3.casilla && !jugador3.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador3.ficha4.casilla && !jugador3.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador4.ficha1.casilla && !jugador4.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador4.ficha2.casilla && !jugador4.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador4.ficha3.casilla && !jugador4.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha3.casilla==jugador4.ficha4.casilla && !jugador4.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                  }
                                     
                              }else{
                                  System.out.println("No se puede mover la \033[33mFicha 3\u001B[0m");
                                  System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                              }
                              break;
                        case 4: 
                            if  (jugador1.ficha4.move){
                                  System.out.println("Se mueve la \033[33mFicha 4\u001B[0m...");
                                  if (jugador1.ficha4.home){
                                      jugador1.ficha4.casilla+=dado.numero;
                                      move = true;
                                      if(jugador1.ficha4.casilla==76){
                                          System.out.println("La \033[33mFicha 4\u001B[0m ha llegado a la meta");
                                          jugador1.fichaenCasa++;
                                      }else{
                                          
                                          System.out.println("La \033[33mFicha 4\u001B[0m está en la casa, a"+(76-jugador1.ficha4.casilla)+" de la meta");
                                          
                                      }
                                      
                                  }else if(jugador1.ficha4.casilla==0){
                                      jugador1.ficha4.casilla=5;
                                      System.out.println("La \033[33mFicha 4\u001B[0m salió a la casilla "+jugador1.ficha4.casilla);
                                      move = true;
                                  } else{
                                      jugador1.ficha4.casilla+=dado.numero;
                                      System.out.println("Ahora, \033[33mFicha 4\u001B[0m está en la casilla "+jugador1.ficha4.casilla);
                                      move = true;
                                      
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador2.ficha1.casilla && !jugador2.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador2.ficha2.casilla && !jugador2.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador2.ficha3.casilla && !jugador2.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador2.ficha4.casilla && !jugador2.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador3.ficha1.casilla && !jugador3.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador3.ficha2.casilla && !jugador3.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador3.ficha3.casilla && !jugador3.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador3.ficha4.casilla && !jugador3.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador4.ficha1.casilla && !jugador4.ficha1.home){
                                      jugador2.ficha1.casilla=0;
                                      System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador4.ficha2.casilla && !jugador4.ficha2.home){
                                      jugador2.ficha2.casilla=0;
                                      System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador4.ficha3.casilla && !jugador4.ficha3.home){
                                      jugador2.ficha3.casilla=0;
                                      System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                  }
                                  
                                  if(jugador1.ficha4.casilla==jugador4.ficha4.casilla && !jugador4.ficha4.home){
                                      jugador2.ficha4.casilla=0;
                                      System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                  }
                                     
                              }else{
                                  System.out.println("No se puede mover la \033[33mFicha 4\u001B[0m");
                                  System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                              }
                              break;
                     
                        default:
                            System.out.println("Es casilla no existe");
                            
                          
                      }
                     }
                      
                     }
                      
                  }while(dado.numero==6 || dado.numero==1 && J1O != 2);
                    System.out.println("pene");
                }
            } 
            }
        }
    }
    

