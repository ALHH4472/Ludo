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

        switch (jugadores) {//switch/case para validar el numero de jugadores

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

        }//fin para los casos que validan el numero de jugadores

        if (!jugador1.play && !jugador2.play) {//condicion que en caso de no haber indicado un numero valido de jugadores indica que la cantidad de estos deve indicarse de nuevo
            System.out.println("Ingrese nuevamente la cantidad de jugadores");
            System.out.println("");
        } else {//en caso de existir un numero valido de jugadores ejecuta lo sisguiente

            while (ganador == null) {//inicio del ciclo while que se repetira mientras no haya un ganador

                if (jugador1.play) {

                    System.out.println("Es el turno del \033[33m Jugador 1\u001B[0m");
                    System.out.println("");
                    System.out.println("Tienes " + jugador1.fichaenCasa + " Fichas en la meta");

                    int J1O = 0;//declaracion de la variable para lanzar los dados u salir del juego
                    do {
                        System.out.println("1<----------Lanzar el dado");
                        System.out.println("2<----------Abandonar partida");
                        System.out.println("");
                        J1O = entrada.nextInt();//se asigna un valor a la variable J1O

                        switch (J1O) {//inicio del switch/case para lanzar los dados o saltar turno
                            case 1:
                                dado.lanzar();
                                System.out.println("El dado cae y muestra el numero " + dado.numero);
                                break;
                            case 2:
                                jugador1.play = false;
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }//fin del switch/case para lanzar los dados o saltar turno

                        if (jugador1.ficha1.casilla == 0 && jugador1.ficha2.casilla == 0 && jugador1.ficha3.casilla == 0 && jugador1.ficha4.casilla == 0) {//inicio de las condiciones que comprueva si las fichas del jugador 1 se encuentran en la casilla 0
                            System.out.println("Todas tus Fichas están en la base.");
                            System.out.println("");

                            if (dado.numero == 6 || dado.numero == 1) {//inicio condicionales para la salidad de las fichas del jugador 1
                                jugador1.ficha1.move = true;
                                jugador1.ficha2.move = true;
                                jugador1.ficha3.move = true;
                                jugador1.ficha4.move = true;
                            } else {
                                jugador1.ficha1.move = false;
                                jugador1.ficha2.move = false;
                                jugador1.ficha3.move = false;
                                jugador1.ficha4.move = false;
                            }//fin de la condicionales para la salida de la fichas
                        } else {// si el las fichas no estan en la posicion 0

                            if (jugador1.ficha1.home) {
                                if (jugador1.ficha1.casilla == 76 && jugador1.ficha1.home) {

                                    System.out.println("La \033[33mFicha 1\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador1.ficha1.move = false;

                                } else if (jugador1.ficha1.casilla < 76 && jugador1.ficha1.home) {
                                    System.out.println("La \033[33mFicha 1\u001B[0m está en casa, a " + (76 - jugador1.ficha1.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador1.ficha1.move = (76 - jugador1.ficha1.casilla) >= dado.numero;
                                }
                            } else {
                                if (jugador1.ficha1.casilla == 0 && !jugador1.ficha1.home) {
                                    System.out.println("La \033[33mFicha 1\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador1.ficha1.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador1.ficha1.casilla < 76 && jugador1.ficha1.casilla > 0 && !jugador1.ficha1.home) {
                                    System.out.println("La \033[33mFicha 1\u001B[0m está en la casilla " + jugador1.ficha1.casilla);
                                    jugador1.ficha1.move = true;
                                }
                            }

                            if (jugador1.ficha2.home) {
                                if (jugador1.ficha2.casilla == 76 && jugador1.ficha2.home) {

                                    System.out.println("La \033[33mFicha 2\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador1.ficha2.move = false;

                                } else if (jugador1.ficha2.casilla < 76 && jugador1.ficha2.home) {
                                    System.out.println("La \033[33mFicha 2\u001B[0m está en casa, a " + (76 - jugador1.ficha2.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador1.ficha2.move = (76 - jugador1.ficha2.casilla) >= dado.numero;
                                }
                            } else {
                                if (jugador1.ficha2.casilla == 0 && !jugador1.ficha2.home) {
                                    System.out.println("La \033[33mFicha 2\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador1.ficha2.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador1.ficha2.casilla < 76 && jugador1.ficha2.casilla > 0 && !jugador1.ficha2.home) {
                                    System.out.println("La \033[33mFicha 2\u001B[0m está en la casilla " + jugador1.ficha2.casilla);
                                    jugador1.ficha2.move = true;
                                }
                            }

                            if (jugador1.ficha3.home) {
                                if (jugador1.ficha3.casilla == 76 && jugador1.ficha3.home) {

                                    System.out.println("La \033[33mFicha 3\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador1.ficha3.move = false;

                                } else if (jugador1.ficha3.casilla < 76 && jugador1.ficha3.home) {
                                    System.out.println("La \033[33mFicha 3\u001B[0m está en casa, a " + (76 - jugador1.ficha3.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador1.ficha3.move = 76 - jugador1.ficha3.casilla >= dado.numero;
                                }
                            } else {
                                if (jugador1.ficha3.casilla == 0 && !jugador1.ficha3.home) {
                                    System.out.println("La \033[33mFicha 3\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador1.ficha3.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador1.ficha3.casilla < 76 && jugador1.ficha3.casilla > 0 && !jugador1.ficha3.home) {
                                    System.out.println("La \033[33mFicha 3\u001B[0m está en la casilla " + jugador1.ficha3.casilla);
                                    jugador1.ficha3.move = true;
                                }
                            }
                            if (jugador1.ficha4.home) {
                                if (jugador1.ficha4.casilla == 76 && jugador1.ficha4.home) {

                                    System.out.println("La \033[33mFicha 4\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador1.ficha4.move = false;

                                } else if (jugador1.ficha4.casilla < 76 && jugador1.ficha4.home) {
                                    System.out.println("La \033[33mFicha 4\u001B[0m está en casa, a " + (76 - jugador1.ficha4.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador1.ficha4.move = (76 - jugador1.ficha4.casilla) >= dado.numero;
                                }
                            } else {
                                if (jugador1.ficha4.casilla == 0 && !jugador1.ficha4.home) {
                                    System.out.println("La \033[33mFicha 4\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador1.ficha4.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador1.ficha4.casilla < 76 && jugador1.ficha4.casilla > 0 && !jugador1.ficha4.home) {
                                    System.out.println("La \033[33mFicha 4\u001B[0m está en la casilla " + jugador1.ficha4.casilla);
                                    jugador1.ficha4.move = true;
                                }
                            }
                        }//fin

                        if (!jugador1.ficha1.move && !jugador1.ficha2.move && !jugador1.ficha3.move && !jugador1.ficha4.move) {
                            System.out.println("No puedes mover ninguna ficha, lo siento");
                            System.out.println("");
                        } else {
                            System.out.println("¿Qué ficha deseas mover?");
                            System.out.println("");

                            Boolean move = false;
                            while (!move) {
                                if (jugador1.ficha1.move) {
                                    System.out.println("1<----------Mover \033[33mFicha 1\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 1\u001B[0m");
                                }

                                if (jugador1.ficha2.move) {
                                    System.out.println("2<----------Mover \033[33mFicha 2\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 2\u001B[0m");
                                }

                                if (jugador1.ficha3.move) {
                                    System.out.println("3<----------Mover \033[33mFicha 3\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 3\u001B[0m");
                                }

                                if (jugador1.ficha4.move) {
                                    System.out.println("4<----------Mover \033[33mFicha 4\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 4\u001B[0m");
                                }

                                int FM1 = entrada.nextInt();

                                switch (FM1) {

                                    case 1:
                                        if (jugador1.ficha1.move) {
                                            System.out.println("Se mueve la \033[33mFicha 1\u001B[0m...");
                                            if (jugador1.ficha1.home) {
                                                jugador1.ficha1.casilla += dado.numero;
                                                move = true;
                                                if (jugador1.ficha1.casilla == 76) {
                                                    System.out.println("La \033[33mFicha 1\u001B[0m ha llegado a la meta");
                                                    jugador1.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 1\u001B[0m está en la casa, a" + (76 - jugador1.ficha1.casilla) + " de la meta");

                                                }

                                            } else if (jugador1.ficha1.casilla == 0) {
                                                jugador1.ficha1.casilla = 5;
                                                System.out.println("La \033[33mFicha 1\u001B[0m salió a la casilla " + jugador1.ficha1.casilla);
                                                move = true;
                                            } else {
                                                jugador1.ficha1.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 1\u001B[0m está en la casilla " + jugador1.ficha1.casilla);
                                                move = true;

                                            }

                                            if (jugador1.ficha1.casilla == jugador2.ficha1.casilla && !jugador2.ficha1.home) {
                                                jugador2.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha1.casilla == jugador2.ficha2.casilla && !jugador2.ficha2.home) {
                                                jugador2.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha1.casilla == jugador2.ficha3.casilla && !jugador2.ficha3.home) {
                                                jugador2.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha1.casilla == jugador2.ficha4.casilla && !jugador2.ficha4.home) {
                                                jugador2.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }

                                            if (jugador1.ficha1.casilla == jugador3.ficha1.casilla && !jugador3.ficha1.home) {
                                                jugador3.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha1.casilla == jugador3.ficha2.casilla && !jugador3.ficha2.home) {
                                                jugador3.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha1.casilla == jugador3.ficha3.casilla && !jugador3.ficha3.home) {
                                                jugador3.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha1.casilla == jugador3.ficha4.casilla && !jugador3.ficha4.home) {
                                                jugador3.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador1.ficha1.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha1.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha1.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha1.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 1\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;
                                    case 2:
                                        if (jugador1.ficha2.move) {
                                            System.out.println("Se mueve la \033[33mFicha 2\u001B[0m...");
                                            if (jugador1.ficha2.home) {
                                                jugador1.ficha2.casilla += dado.numero;
                                                move = true;
                                                if (jugador1.ficha2.casilla == 76) {
                                                    System.out.println("La \033[33mFicha 2\u001B[0m ha llegado a la meta");
                                                    jugador1.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 2\u001B[0m está en la casa, a" + (76 - jugador1.ficha2.casilla) + " de la meta");

                                                }

                                            } else if (jugador1.ficha2.casilla == 0) {
                                                jugador1.ficha2.casilla = 5;
                                                System.out.println("La \033[33mFicha 2\u001B[0m salió a la casilla " + jugador1.ficha2.casilla);
                                                move = true;
                                            } else {
                                                jugador1.ficha2.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 2\u001B[0m está en la casilla " + jugador1.ficha2.casilla);
                                                move = true;

                                            }

                                            if (jugador1.ficha2.casilla == jugador2.ficha1.casilla && !jugador2.ficha1.home) {
                                                jugador2.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha2.casilla == jugador2.ficha2.casilla && !jugador2.ficha2.home) {
                                                jugador2.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha2.casilla == jugador2.ficha3.casilla && !jugador2.ficha3.home) {
                                                jugador2.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha2.casilla == jugador2.ficha4.casilla && !jugador2.ficha4.home) {
                                                jugador2.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }

                                            if (jugador1.ficha2.casilla == jugador3.ficha1.casilla && !jugador3.ficha1.home) {
                                                jugador3.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha2.casilla == jugador3.ficha2.casilla && !jugador3.ficha2.home) {
                                                jugador3.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha2.casilla == jugador3.ficha3.casilla && !jugador3.ficha3.home) {
                                                jugador3.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha2.casilla == jugador3.ficha4.casilla && !jugador3.ficha4.home) {
                                                jugador3.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador1.ficha2.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha2.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha2.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha2.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 2\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;

                                    case 3:
                                        if (jugador1.ficha3.move) {
                                            System.out.println("Se mueve la \033[33mFicha 3\u001B[0m...");
                                            if (jugador1.ficha3.home) {
                                                jugador1.ficha3.casilla += dado.numero;
                                                move = true;
                                                if (jugador1.ficha3.casilla == 76) {
                                                    System.out.println("La \033[33mFicha 3\u001B[0m ha llegado a la meta");
                                                    jugador1.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 3\u001B[0m está en la casa, a" + (76 - jugador1.ficha3.casilla) + " de la meta");

                                                }

                                            } else if (jugador1.ficha3.casilla == 0) {
                                                jugador1.ficha3.casilla = 5;
                                                System.out.println("La \033[33mFicha 3\u001B[0m salió a la casilla " + jugador1.ficha3.casilla);
                                                move = true;
                                            } else {
                                                jugador1.ficha3.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 3\u001B[0m está en la casilla " + jugador1.ficha3.casilla);
                                                move = true;

                                            }

                                            if (jugador1.ficha3.casilla == jugador2.ficha1.casilla && !jugador2.ficha1.home) {
                                                jugador2.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha3.casilla == jugador2.ficha2.casilla && !jugador2.ficha2.home) {
                                                jugador2.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha3.casilla == jugador2.ficha3.casilla && !jugador2.ficha3.home) {
                                                jugador2.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha3.casilla == jugador2.ficha4.casilla && !jugador2.ficha4.home) {
                                                jugador2.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }

                                            if (jugador1.ficha3.casilla == jugador3.ficha1.casilla && !jugador3.ficha1.home) {
                                                jugador3.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha3.casilla == jugador3.ficha2.casilla && !jugador3.ficha2.home) {
                                                jugador3.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha3.casilla == jugador3.ficha3.casilla && !jugador3.ficha3.home) {
                                                jugador3.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha3.casilla == jugador3.ficha4.casilla && !jugador3.ficha4.home) {
                                                jugador3.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador1.ficha3.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha3.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha3.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha3.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 3\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;
                                    case 4:
                                        if (jugador1.ficha4.move) {
                                            System.out.println("Se mueve la \033[33mFicha 4\u001B[0m...");
                                            if (jugador1.ficha4.home) {
                                                jugador1.ficha4.casilla += dado.numero;
                                                move = true;
                                                if (jugador1.ficha4.casilla == 76) {
                                                    System.out.println("La \033[33mFicha 4\u001B[0m ha llegado a la meta");
                                                    jugador1.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 4\u001B[0m está en la casa, a" + (76 - jugador1.ficha4.casilla) + " de la meta");

                                                }

                                            } else if (jugador1.ficha4.casilla == 0) {
                                                jugador1.ficha4.casilla = 5;
                                                System.out.println("La \033[33mFicha 4\u001B[0m salió a la casilla " + jugador1.ficha4.casilla);
                                                move = true;
                                            } else {
                                                jugador1.ficha4.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 4\u001B[0m está en la casilla " + jugador1.ficha4.casilla);
                                                move = true;

                                            }

                                            if (jugador1.ficha4.casilla == jugador2.ficha1.casilla && !jugador2.ficha1.home) {
                                                jugador2.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha4.casilla == jugador2.ficha2.casilla && !jugador2.ficha2.home) {
                                                jugador2.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha4.casilla == jugador2.ficha3.casilla && !jugador2.ficha3.home) {
                                                jugador2.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha4.casilla == jugador2.ficha4.casilla && !jugador2.ficha4.home) {
                                                jugador2.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }

                                            if (jugador1.ficha4.casilla == jugador3.ficha1.casilla && !jugador3.ficha1.home) {
                                                jugador3.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha4.casilla == jugador3.ficha2.casilla && !jugador3.ficha2.home) {
                                                jugador3.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha4.casilla == jugador3.ficha3.casilla && !jugador3.ficha3.home) {
                                                jugador3.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha4.casilla == jugador3.ficha4.casilla && !jugador3.ficha4.home) {
                                                jugador3.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador1.ficha4.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador1.ficha4.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador1.ficha4.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador1.ficha4.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 4\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;

                                    default:
                                        System.out.println("Es casilla no existe");

                                }
                            }

                        }
                    } while (dado.numero == 6 || dado.numero == 1 && J1O != 2);
                    System.out.println("FIN---> se acabo todo");
                }
            //fin jugador 1
                

            //jugador 2
                if (jugador2.play) {

                    System.out.println("Es el turno del \033[33m Jugador 1\u001B[0m");
                    System.out.println("");
                    System.out.println("Tienes " + jugador2.fichaenCasa + " Fichas en la meta");

                    int J2O = 0;//declaracion de la variable para lanzar los dados u salir del juego
                    do {
                        System.out.println("1<----------Lanzar el dado");
                        System.out.println("2<----------Abandonar partida");
                        System.out.println("");
                        J2O = entrada.nextInt();//se asigna un valor a la variable J1O

                        switch (J2O) {//inicio del switch/case para lanzar los dados o saltar turno
                            case 1:
                                dado.lanzar();
                                System.out.println("El dado cae y muestra el numero " + dado.numero);
                                break;
                            case 2:
                                jugador2.play = false;
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }//fin del switch/case para lanzar los dados o saltar turno

                        if (jugador2.ficha1.casilla == 0 && jugador2.ficha2.casilla == 0 && jugador2.ficha3.casilla == 0 && jugador2.ficha4.casilla == 0) {//inicio de las condiciones que comprueva si las fichas del jugador 1 se encuentran en la casilla 0
                            System.out.println("Todas tus Fichas están en la base.");
                            System.out.println("");

                            if (dado.numero == 6 || dado.numero == 1) {//inicio condicionales para la salidad de las fichas del jugador 1
                                jugador2.ficha1.move = true;
                                jugador2.ficha2.move = true;
                                jugador2.ficha3.move = true;
                                jugador2.ficha4.move = true;
                            } else {
                                jugador2.ficha1.move = false;
                                jugador2.ficha2.move = false;
                                jugador2.ficha3.move = false;
                                jugador2.ficha4.move = false;
                            }//fin de la condicionales para la salida de la fichas
                            
                        } else {// si el las fichas no estan en la posicion 0

                            if (jugador2.ficha1.home) {
                                if (jugador2.ficha1.casilla == 25 && jugador2.ficha1.home) {

                                    System.out.println("La \033[33mFicha 1\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador2.ficha1.move = false;

                                } else if (jugador2.ficha1.casilla < 25 && jugador2.ficha1.home) {
                                    System.out.println("La \033[33mFicha 1\u001B[0m está en casa, a " + (25 - jugador2.ficha1.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador2.ficha1.move = (25 - jugador2.ficha1.casilla) >= dado.numero;
                                }
                            } else {
                                if (jugador2.ficha1.casilla == 0 && !jugador2.ficha1.home) {
                                    System.out.println("La \033[33mFicha 1\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador2.ficha1.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador2.ficha1.casilla < 25 && jugador2.ficha1.casilla > 0 && !jugador2.ficha1.home) {
                                    System.out.println("La \033[33mFicha 1\u001B[0m está en la casilla " + jugador2.ficha1.casilla);
                                    jugador2.ficha1.move = true;
                                }
                            }
                            
                            //coniciones de la ficha 3 en home
                            if (jugador2.ficha2.home) {
                                if (jugador2.ficha2.casilla == 25 && jugador2.ficha2.home) {

                                    System.out.println("La \033[33mFicha 2\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador2.ficha2.move = false;

                                } else if (jugador2.ficha2.casilla < 25 && jugador2.ficha2.home) {
                                    System.out.println("La \033[33mFicha 2\u001B[0m está en casa, a " + (25 - jugador2.ficha2.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador2.ficha2.move = (25 - jugador2.ficha2.casilla) >= dado.numero;
                                }
                            } else {
                                if (jugador2.ficha2.casilla == 0 && !jugador2.ficha2.home) {
                                    System.out.println("La \033[33mFicha 2\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador2.ficha2.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador2.ficha2.casilla < 25 && jugador2.ficha2.casilla > 0 && !jugador2.ficha2.home) {
                                    System.out.println("La \033[33mFicha 2\u001B[0m está en la casilla " + jugador2.ficha2.casilla);
                                    jugador2.ficha2.move = true;
                                }
                            }//fin coniciones de la ficha 2
                            
                            //coniciones de la ficha 3 en home
                            if (jugador2.ficha3.home) {
                                if (jugador2.ficha3.casilla == 25 && jugador2.ficha3.home) {

                                    System.out.println("La \033[33mFicha 3\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador2.ficha3.move = false;

                                } else if (jugador2.ficha3.casilla < 25 && jugador2.ficha3.home) {
                                    System.out.println("La \033[33mFicha 3\u001B[0m está en casa, a " + (25 - jugador2.ficha3.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador2.ficha3.move = 25 - jugador2.ficha3.casilla >= dado.numero;
                                }
                            } else {
                                if (jugador2.ficha3.casilla == 0 && !jugador2.ficha3.home) {
                                    System.out.println("La \033[33mFicha 3\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador2.ficha3.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador2.ficha3.casilla < 25 && jugador2.ficha3.casilla > 0 && !jugador2.ficha3.home) {
                                    System.out.println("La \033[33mFicha 3\u001B[0m está en la casilla " + jugador2.ficha3.casilla);
                                    jugador2.ficha3.move = true;
                                }
                            }//fin coniciones de la ficha 3
                            
                            //condicion en caso de que la ficha 4 este en el home
                            if (jugador2.ficha4.home) {
                                if (jugador2.ficha4.casilla == 25 && jugador2.ficha4.home) {

                                    System.out.println("La \033[33mFicha 4\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador2.ficha4.move = false;

                                } else if (jugador2.ficha4.casilla < 25 && jugador2.ficha4.home) {
                                    System.out.println("La \033[33mFicha 4\u001B[0m está en casa, a " + (25 - jugador2.ficha4.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador2.ficha4.move = (25 - jugador2.ficha4.casilla) >= dado.numero;
                                }
                            } else {
                                if (jugador2.ficha4.casilla == 0 && !jugador2.ficha4.home) {
                                    System.out.println("La \033[33mFicha 4\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador2.ficha4.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador2.ficha4.casilla < 25 && jugador2.ficha4.casilla > 0 && !jugador2.ficha4.home) {
                                    System.out.println("La \033[33mFicha 4\u001B[0m está en la casilla " + jugador2.ficha4.casilla);
                                    jugador2.ficha4.move = true;
                                }
                            }
                        }//fin coniciones de la ficha 4

                        if (!jugador2.ficha1.move && !jugador2.ficha2.move && !jugador2.ficha3.move && !jugador2.ficha4.move) {
                            System.out.println("No puedes mover ninguna ficha, lo siento");
                            System.out.println("");
                        } else {
                            System.out.println("¿Qué ficha deseas mover?");
                            System.out.println("");

                            Boolean move = false;
                            while (!move) {
                                if (jugador2.ficha1.move) {
                                    System.out.println("1<----------Mover \033[33mFicha 1\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 1\u001B[0m");
                                }

                                if (jugador2.ficha2.move) {
                                    System.out.println("2<----------Mover \033[33mFicha 2\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 2\u001B[0m");
                                }

                                if (jugador2.ficha3.move) {
                                    System.out.println("3<----------Mover \033[33mFicha 3\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 3\u001B[0m");
                                }

                                if (jugador2.ficha4.move) {
                                    System.out.println("4<----------Mover \033[33mFicha 4\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 4\u001B[0m");
                                }

                                int FM2 = entrada.nextInt();

                                switch (FM2) {

                                    case 1:
                                        if (jugador2.ficha1.move) {
                                            System.out.println("Se mueve la \033[33mFicha 1\u001B[0m...");
                                            if (jugador2.ficha1.home) {
                                                jugador2.ficha1.casilla += dado.numero;
                                                move = true;
                                                if (jugador2.ficha1.casilla == 25) {
                                                    System.out.println("La \033[33mFicha 1\u001B[0m ha llegado a la meta");
                                                    jugador2.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 1\u001B[0m está en la casa, a" + (25 - jugador2.ficha1.casilla) + " de la meta");

                                                }

                                            } else if (jugador2.ficha1.casilla == 0) {
                                                jugador2.ficha1.casilla = 22;
                                                System.out.println("La \033[33mFicha 1\u001B[0m salió a la casilla " + jugador2.ficha1.casilla);
                                                move = true;
                                            } else {
                                                jugador2.ficha1.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 1\u001B[0m está en la casilla " + jugador2.ficha1.casilla);
                                                move = true;

                                            }

                                            if (jugador2.ficha1.casilla == jugador1.ficha1.casilla && !jugador1.ficha1.home) {
                                                jugador1.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha1.casilla == jugador1.ficha2.casilla && !jugador1.ficha2.home) {
                                                jugador1.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha1.casilla == jugador1.ficha3.casilla && !jugador1.ficha3.home) {
                                                jugador1.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha1.casilla == jugador1.ficha4.casilla && !jugador1.ficha4.home) {
                                                jugador1.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }
                                            
                                            

                                            if (jugador2.ficha1.casilla == jugador3.ficha1.casilla && !jugador3.ficha1.home) {
                                                jugador3.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha1.casilla == jugador3.ficha2.casilla && !jugador3.ficha2.home) {
                                                jugador3.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha1.casilla == jugador3.ficha3.casilla && !jugador3.ficha3.home) {
                                                jugador3.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha1.casilla == jugador3.ficha4.casilla && !jugador3.ficha4.home) {
                                                jugador3.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador2.ficha1.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha1.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha1.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha1.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 1\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;
                                    case 2:
                                        if (jugador2.ficha2.move) {
                                            System.out.println("Se mueve la \033[33mFicha 2\u001B[0m...");
                                            if (jugador2.ficha2.home) {
                                                jugador2.ficha2.casilla += dado.numero;
                                                move = true;
                                                if (jugador2.ficha2.casilla == 25) {
                                                    System.out.println("La \033[33mFicha 2\u001B[0m ha llegado a la meta");
                                                    jugador2.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 2\u001B[0m está en la casa, a" + (25 - jugador2.ficha2.casilla) + " de la meta");

                                                }

                                            } else if (jugador2.ficha2.casilla == 0) {
                                                jugador2.ficha2.casilla = 22;
                                                System.out.println("La \033[33mFicha 2\u001B[0m salió a la casilla " + jugador2.ficha2.casilla);
                                                move = true;
                                            } else {
                                                jugador2.ficha2.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 2\u001B[0m está en la casilla " + jugador2.ficha2.casilla);
                                                move = true;
                                            }

                                            if (jugador2.ficha2.casilla == jugador1.ficha1.casilla && !jugador1.ficha1.home) {
                                                jugador1.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha2.casilla == jugador1.ficha2.casilla && !jugador1.ficha2.home) {
                                                jugador1.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha2.casilla == jugador1.ficha3.casilla && !jugador1.ficha3.home) {
                                                jugador1.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha2.casilla == jugador1.ficha4.casilla && !jugador1.ficha4.home) {
                                                jugador1.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }
                                            

                                            if (jugador2.ficha2.casilla == jugador3.ficha1.casilla && !jugador3.ficha1.home) {
                                                jugador3.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha2.casilla == jugador3.ficha2.casilla && !jugador3.ficha2.home) {
                                                jugador3.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha2.casilla == jugador3.ficha3.casilla && !jugador3.ficha3.home) {
                                                jugador3.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha2.casilla == jugador3.ficha4.casilla && !jugador3.ficha4.home) {
                                                jugador3.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador2.ficha2.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha2.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha2.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha2.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 2\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;

                                    case 3:
                                        if (jugador2.ficha3.move) {
                                            System.out.println("Se mueve la \033[33mFicha 3\u001B[0m...");
                                            if (jugador2.ficha3.home) {
                                                jugador2.ficha3.casilla += dado.numero;
                                                move = true;
                                                if (jugador2.ficha3.casilla == 25) {
                                                    System.out.println("La \033[33mFicha 3\u001B[0m ha llegado a la meta");
                                                    jugador2.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 3\u001B[0m está en la casa, a" + (25 - jugador2.ficha3.casilla) + " de la meta");

                                                }

                                            } else if (jugador2.ficha3.casilla == 0) {
                                                jugador2.ficha3.casilla = 22;
                                                System.out.println("La \033[33mFicha 3\u001B[0m salió a la casilla " + jugador2.ficha3.casilla);
                                                move = true;
                                            } else {
                                                jugador2.ficha3.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 3\u001B[0m está en la casilla " + jugador2.ficha3.casilla);
                                                move = true;

                                            }

                                            if (jugador2.ficha3.casilla == jugador1.ficha1.casilla && !jugador1.ficha1.home) {
                                                jugador1.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha3.casilla == jugador1.ficha2.casilla && !jugador1.ficha2.home) {
                                                jugador1.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha3.casilla == jugador1.ficha3.casilla && !jugador1.ficha3.home) {
                                                jugador1.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha3.casilla == jugador1.ficha4.casilla && !jugador1.ficha4.home) {
                                                jugador1.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }

                                            if (jugador2.ficha3.casilla == jugador3.ficha1.casilla && !jugador3.ficha1.home) {
                                                jugador3.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha3.casilla == jugador3.ficha2.casilla && !jugador3.ficha2.home) {
                                                jugador3.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha3.casilla == jugador3.ficha3.casilla && !jugador3.ficha3.home) {
                                                jugador3.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha3.casilla == jugador3.ficha4.casilla && !jugador3.ficha4.home) {
                                                jugador3.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador2.ficha3.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha3.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha3.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha3.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 3\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;
                                    case 4:
                                        if (jugador2.ficha4.move) {
                                            System.out.println("Se mueve la \033[33mFicha 4\u001B[0m...");
                                            if (jugador2.ficha4.home) {
                                                jugador2.ficha4.casilla += dado.numero;
                                                move = true;
                                                if (jugador2.ficha4.casilla == 25) {
                                                    System.out.println("La \033[33mFicha 4\u001B[0m ha llegado a la meta");
                                                    jugador2.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 4\u001B[0m está en la casa, a" + (25 - jugador2.ficha4.casilla) + " de la meta");

                                                }

                                            } else if (jugador2.ficha4.casilla == 0) {
                                                jugador2.ficha4.casilla = 22;
                                                System.out.println("La \033[33mFicha 4\u001B[0m salió a la casilla " + jugador2.ficha4.casilla);
                                                move = true;
                                            } else {
                                                jugador2.ficha4.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 4\u001B[0m está en la casilla " + jugador2.ficha4.casilla);
                                                move = true;

                                            }

                                            if (jugador2.ficha4.casilla == jugador1.ficha1.casilla && !jugador1.ficha1.home) {
                                                jugador1.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha4.casilla == jugador1.ficha2.casilla && !jugador1.ficha2.home) {
                                                jugador1.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha4.casilla == jugador1.ficha3.casilla && !jugador1.ficha3.home) {
                                                jugador1.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha4.casilla == jugador1.ficha4.casilla && !jugador1.ficha4.home) {
                                                jugador1.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }

                                            if (jugador2.ficha4.casilla == jugador3.ficha1.casilla && !jugador3.ficha1.home) {
                                                jugador3.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha4.casilla == jugador3.ficha2.casilla && !jugador3.ficha2.home) {
                                                jugador3.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha4.casilla == jugador3.ficha3.casilla && !jugador3.ficha3.home) {
                                                jugador3.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha4.casilla == jugador3.ficha4.casilla && !jugador3.ficha4.home) {
                                                jugador3.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador2.ficha4.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador2.ficha4.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador2.ficha4.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador2.ficha4.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 4\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;

                                    default:
                                        System.out.println("Es casilla no existe");

                                }
                            }

                        }
                    } while (dado.numero == 6 || dado.numero == 1 && J2O != 2);
                    System.out.println("FIN---> se acabo todo");
                }
                //fin jugador 2
                
                
            //jugador 3
                if (jugador3.play) {

                    System.out.println("Es el turno del \033[33m Jugador 1\u001B[0m");
                    System.out.println("");
                    System.out.println("Tienes " + jugador3.fichaenCasa + " Fichas en la meta");

                    int J3O = 0;//declaracion de la variable para lanzar los dados u salir del juego
                    do {
                        System.out.println("1<----------Lanzar el dado");
                        System.out.println("2<----------Abandonar partida");
                        System.out.println("");
                        J3O = entrada.nextInt();//se asigna un valor a la variable J1O

                        switch (J3O) {//inicio del switch/case para lanzar los dados o saltar turno
                            case 1:
                                dado.lanzar();
                                System.out.println("El dado cae y muestra el numero " + dado.numero);
                                break;
                            case 2:
                                jugador3.play = false;
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }//fin del switch/case para lanzar los dados o saltar turno

                        if (jugador3.ficha1.casilla == 0 && jugador3.ficha2.casilla == 0 && jugador3.ficha3.casilla == 0 && jugador3.ficha4.casilla == 0) {//inicio de las condiciones que comprueva si las fichas del jugador 1 se encuentran en la casilla 0
                            System.out.println("Todas tus Fichas están en la base.");
                            System.out.println("");

                            if (dado.numero == 6 || dado.numero == 1) {//inicio condicionales para la salidad de las fichas del jugador 1
                                jugador3.ficha1.move = true;
                                jugador3.ficha2.move = true;
                                jugador3.ficha3.move = true;
                                jugador3.ficha4.move = true;
                            } else {
                                jugador3.ficha1.move = false;
                                jugador3.ficha2.move = false;
                                jugador3.ficha3.move = false;
                                jugador3.ficha4.move = false;
                            }//fin de la condicionales para la salida de la fichas
                            
                        } else {// si el las fichas no estan en la posicion 0

                            if (jugador3.ficha1.home) {
                                if (jugador3.ficha1.casilla == 42 && jugador3.ficha1.home) {

                                    System.out.println("La \033[33mFicha 1\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador3.ficha1.move = false;

                                } else if (jugador3.ficha1.casilla < 42 && jugador3.ficha1.home) {
                                    System.out.println("La \033[33mFicha 1\u001B[0m está en casa, a " + (42 - jugador3.ficha1.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador3.ficha1.move = (42 - jugador3.ficha1.casilla) >= dado.numero;
                                }
                            } else {
                                if (jugador3.ficha1.casilla == 0 && !jugador3.ficha1.home) {
                                    System.out.println("La \033[33mFicha 1\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador3.ficha1.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador3.ficha1.casilla < 42 && jugador3.ficha1.casilla > 0 && !jugador3.ficha1.home) {
                                    System.out.println("La \033[33mFicha 1\u001B[0m está en la casilla " + jugador3.ficha1.casilla);
                                    jugador3.ficha1.move = true;
                                }
                            }
                            
                            //coniciones de la ficha 3 en home
                            if (jugador3.ficha2.home) {
                                if (jugador3.ficha2.casilla == 42 && jugador3.ficha2.home) {

                                    System.out.println("La \033[33mFicha 2\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador3.ficha2.move = false;

                                } else if (jugador3.ficha2.casilla < 42 && jugador3.ficha2.home) {
                                    System.out.println("La \033[33mFicha 2\u001B[0m está en casa, a " + (42 - jugador3.ficha2.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador3.ficha2.move = (42 - jugador3.ficha2.casilla) >= dado.numero;
                                }
                            } else {
                                if (jugador3.ficha2.casilla == 0 && !jugador3.ficha2.home) {
                                    System.out.println("La \033[33mFicha 2\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador3.ficha2.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador3.ficha2.casilla < 42 && jugador3.ficha2.casilla > 0 && !jugador3.ficha2.home) {
                                    System.out.println("La \033[33mFicha 2\u001B[0m está en la casilla " + jugador3.ficha2.casilla);
                                    jugador3.ficha2.move = true;
                                }
                            }//fin coniciones de la ficha 2
                            
                            //coniciones de la ficha 3 en home
                            if (jugador3.ficha3.home) {
                                if (jugador3.ficha3.casilla == 42 && jugador3.ficha3.home) {

                                    System.out.println("La \033[33mFicha 3\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador3.ficha3.move = false;

                                } else if (jugador3.ficha3.casilla < 42 && jugador3.ficha3.home) {
                                    System.out.println("La \033[33mFicha 3\u001B[0m está en casa, a " + (42 - jugador3.ficha3.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador3.ficha3.move = 42 - jugador3.ficha3.casilla >= dado.numero;
                                }
                            } else {
                                if (jugador3.ficha3.casilla == 0 && !jugador3.ficha3.home) {
                                    System.out.println("La \033[33mFicha 3\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador3.ficha3.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador3.ficha3.casilla < 42 && jugador3.ficha3.casilla > 0 && !jugador3.ficha3.home) {
                                    System.out.println("La \033[33mFicha 3\u001B[0m está en la casilla " + jugador3.ficha3.casilla);
                                    jugador3.ficha3.move = true;
                                }
                            }//fin coniciones de la ficha 3
                            
                            //condicion en caso de que la ficha 4 este en el home
                            if (jugador3.ficha4.home) {
                                if (jugador3.ficha4.casilla == 42 && jugador3.ficha4.home) {

                                    System.out.println("La \033[33mFicha 4\u001B[0m ya llegó a la meta");
                                    System.out.println("");
                                    jugador3.ficha4.move = false;

                                } else if (jugador3.ficha4.casilla < 42 && jugador3.ficha4.home) {
                                    System.out.println("La \033[33mFicha 4\u001B[0m está en casa, a " + (42 - jugador3.ficha4.casilla) + " de la meta");
                                    System.out.println("");
                                    jugador3.ficha4.move = (42 - jugador3.ficha4.casilla) >= dado.numero;
                                }
                            } else {
                                if (jugador3.ficha4.casilla == 0 && !jugador3.ficha4.home) {
                                    System.out.println("La \033[33mFicha 4\u001B[0m esta en la base");
                                    System.out.println("");
                                    jugador3.ficha4.move = dado.numero == 6 || dado.numero == 1;
                                } else if (jugador3.ficha4.casilla < 42 && jugador3.ficha4.casilla > 0 && !jugador3.ficha4.home) {
                                    System.out.println("La \033[33mFicha 4\u001B[0m está en la casilla " + jugador3.ficha4.casilla);
                                    jugador3.ficha4.move = true;
                                }
                            }
                        }//fin coniciones de la ficha 4

                        if (!jugador3.ficha1.move && !jugador3.ficha2.move && !jugador3.ficha3.move && !jugador3.ficha4.move) {
                            System.out.println("No puedes mover ninguna ficha, lo siento");
                            System.out.println("");
                        } else {
                            System.out.println("¿Qué ficha deseas mover?");
                            System.out.println("");

                            Boolean move = false;
                            while (!move) {
                                if (jugador3.ficha1.move) {
                                    System.out.println("1<----------Mover \033[33mFicha 1\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 1\u001B[0m");
                                }

                                if (jugador3.ficha2.move) {
                                    System.out.println("2<----------Mover \033[33mFicha 2\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 2\u001B[0m");
                                }

                                if (jugador3.ficha3.move) {
                                    System.out.println("3<----------Mover \033[33mFicha 3\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 3\u001B[0m");
                                }

                                if (jugador3.ficha4.move) {
                                    System.out.println("4<----------Mover \033[33mFicha 4\u001B[0m");
                                } else {
                                    System.out.println("No se puede mover la \033[33mFicha 4\u001B[0m");
                                }

                                int FM3 = entrada.nextInt();

                                switch (FM3) {

                                    case 1:
                                        if (jugador3.ficha1.move) {
                                            System.out.println("Se mueve la \033[33mFicha 1\u001B[0m...");
                                            if (jugador3.ficha1.home) {
                                                jugador3.ficha1.casilla += dado.numero;
                                                move = true;
                                                if (jugador3.ficha1.casilla == 42) {
                                                    System.out.println("La \033[33mFicha 1\u001B[0m ha llegado a la meta");
                                                    jugador3.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 1\u001B[0m está en la casa, a" + (42 - jugador3.ficha1.casilla) + " de la meta");

                                                }

                                            } else if (jugador3.ficha1.casilla == 0) {
                                                jugador3.ficha1.casilla = 39;
                                                System.out.println("La \033[33mFicha 1\u001B[0m salió a la casilla " + jugador3.ficha1.casilla);
                                                move = true;
                                            } else {
                                                jugador3.ficha1.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 1\u001B[0m está en la casilla " + jugador3.ficha1.casilla);
                                                move = true;

                                            }

                                            if (jugador3.ficha1.casilla == jugador1.ficha1.casilla && !jugador1.ficha1.home) {
                                                jugador1.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha1.casilla == jugador1.ficha2.casilla && !jugador1.ficha2.home) {
                                                jugador1.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha1.casilla == jugador1.ficha3.casilla && !jugador1.ficha3.home) {
                                                jugador1.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha1.casilla == jugador1.ficha4.casilla && !jugador1.ficha4.home) {
                                                jugador1.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }
                                            
                                            

                                            if (jugador3.ficha1.casilla == jugador2.ficha1.casilla && !jugador2.ficha1.home) {
                                                jugador2.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha1.casilla == jugador2.ficha2.casilla && !jugador2.ficha2.home) {
                                                jugador2.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha1.casilla == jugador2.ficha3.casilla && !jugador2.ficha3.home) {
                                                jugador2.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha1.casilla == jugador3.ficha4.casilla && !jugador2.ficha4.home) {
                                                jugador2.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador3.ficha1.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 1\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha1.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha1.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha1.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 1\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 1\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;
                                    case 2:
                                        if (jugador3.ficha2.move) {
                                            System.out.println("Se mueve la \033[33mFicha 2\u001B[0m...");
                                            if (jugador3.ficha2.home) {
                                                jugador3.ficha2.casilla += dado.numero;
                                                move = true;
                                                if (jugador3.ficha2.casilla == 42) {
                                                    System.out.println("La \033[33mFicha 2\u001B[0m ha llegado a la meta");
                                                    jugador3.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 2\u001B[0m está en la casa, a" + (42 - jugador3.ficha2.casilla) + " de la meta");
                                                }

                                            } else if (jugador3.ficha2.casilla == 0) {
                                                jugador3.ficha2.casilla = 39;
                                                System.out.println("La \033[33mFicha 2\u001B[0m salió a la casilla " + jugador3.ficha2.casilla);
                                                move = true;
                                            } else {
                                                jugador3.ficha2.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 2\u001B[0m está en la casilla " + jugador3.ficha2.casilla);
                                                move = true;
                                            }

                                            if (jugador3.ficha2.casilla == jugador1.ficha1.casilla && !jugador1.ficha1.home) {
                                                jugador1.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha2.casilla == jugador1.ficha2.casilla && !jugador1.ficha2.home) {
                                                jugador1.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha2.casilla == jugador1.ficha3.casilla && !jugador1.ficha3.home) {
                                                jugador1.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha2.casilla == jugador1.ficha4.casilla && !jugador1.ficha4.home) {
                                                jugador1.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }
                                            

                                            if (jugador3.ficha2.casilla == jugador2.ficha1.casilla && !jugador2.ficha1.home) {
                                                jugador2.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha2.casilla == jugador2.ficha2.casilla && !jugador2.ficha2.home) {
                                                jugador2.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha2.casilla == jugador2.ficha3.casilla && !jugador2.ficha3.home) {
                                                jugador2.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha2.casilla == jugador2.ficha4.casilla && !jugador2.ficha4.home) {
                                                jugador2.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador3.ficha2.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 2\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha2.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha2.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha2.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 2\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 2\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;

                                    case 3:
                                        if (jugador3.ficha3.move) {
                                            System.out.println("Se mueve la \033[33mFicha 3\u001B[0m...");
                                            if (jugador3.ficha3.home) {
                                                jugador3.ficha3.casilla += dado.numero;
                                                move = true;
                                                if (jugador3.ficha3.casilla == 42) {
                                                    System.out.println("La \033[33mFicha 3\u001B[0m ha llegado a la meta");
                                                    jugador3.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 3\u001B[0m está en la casa, a" + (42 - jugador2.ficha3.casilla) + " de la meta");

                                                }

                                            } else if (jugador3.ficha3.casilla == 0) {
                                                jugador3.ficha3.casilla = 39;
                                                System.out.println("La \033[33mFicha 3\u001B[0m salió a la casilla " + jugador3.ficha3.casilla);
                                                move = true;
                                            } else {
                                                jugador3.ficha3.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 3\u001B[0m está en la casilla " + jugador3.ficha3.casilla);
                                                move = true;
                                            }

                                            if (jugador3.ficha3.casilla == jugador1.ficha1.casilla && !jugador1.ficha1.home) {
                                                jugador1.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha3.casilla == jugador1.ficha2.casilla && !jugador1.ficha2.home) {
                                                jugador1.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha3.casilla == jugador1.ficha3.casilla && !jugador1.ficha3.home) {
                                                jugador1.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha3.casilla == jugador1.ficha4.casilla && !jugador1.ficha4.home) {
                                                jugador1.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }

                                            if (jugador3.ficha3.casilla == jugador2.ficha1.casilla && !jugador2.ficha1.home) {
                                                jugador2.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha3.casilla == jugador2.ficha2.casilla && !jugador2.ficha2.home) {
                                                jugador2.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha3.casilla == jugador2.ficha3.casilla && !jugador2.ficha3.home) {
                                                jugador2.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha3.casilla == jugador2.ficha4.casilla && !jugador2.ficha4.home) {
                                                jugador2.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador3.ficha3.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 3\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha3.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha3.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha3.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 3\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 3\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;
                                    case 4:
                                        if (jugador3.ficha4.move) {
                                            System.out.println("Se mueve la \033[33mFicha 4\u001B[0m...");
                                            if (jugador3.ficha4.home) {
                                                jugador3.ficha4.casilla += dado.numero;
                                                move = true;
                                                if (jugador3.ficha4.casilla == 42) {
                                                    System.out.println("La \033[33mFicha 4\u001B[0m ha llegado a la meta");
                                                    jugador3.fichaenCasa++;
                                                } else {

                                                    System.out.println("La \033[33mFicha 4\u001B[0m está en la casa, a" + (42 - jugador3.ficha4.casilla) + " de la meta");
                                                }

                                            } else if (jugador3.ficha4.casilla == 0) {
                                                jugador3.ficha4.casilla = 39;
                                                System.out.println("La \033[33mFicha 4\u001B[0m salió a la casilla " + jugador3.ficha4.casilla);
                                                move = true;
                                            } else {
                                                jugador3.ficha4.casilla += dado.numero;
                                                System.out.println("Ahora, \033[33mFicha 4\u001B[0m está en la casilla " + jugador3.ficha4.casilla);
                                                move = true;
                                            }

                                            if (jugador3.ficha4.casilla == jugador1.ficha1.casilla && !jugador1.ficha1.home) {
                                                jugador1.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha4.casilla == jugador1.ficha2.casilla && !jugador1.ficha2.home) {
                                                jugador1.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha4.casilla == jugador1.ficha3.casilla && !jugador1.ficha3.home) {
                                                jugador1.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha4.casilla == jugador1.ficha4.casilla && !jugador1.ficha4.home) {
                                                jugador1.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[34mFicha 4\u001B[0m ");
                                            }

                                            if (jugador3.ficha4.casilla == jugador2.ficha1.casilla && !jugador2.ficha1.home) {
                                                jugador2.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \031[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha4.casilla == jugador2.ficha2.casilla && !jugador2.ficha2.home) {
                                                jugador2.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha4.casilla == jugador2.ficha3.casilla && !jugador2.ficha3.home) {
                                                jugador2.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha4.casilla == jugador2.ficha4.casilla && !jugador2.ficha4.home) {
                                                jugador2.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[31mFicha 4\u001B[0m ");
                                            }

                                            if (jugador3.ficha4.casilla == jugador4.ficha1.casilla && !jugador4.ficha1.home) {
                                                jugador4.ficha1.casilla = 0;
                                                System.out.println("\033[33mFicha 4\u001B[0m se ha comido a la \032[34mFicha 1\u001B[0m ");
                                            }

                                            if (jugador3.ficha4.casilla == jugador4.ficha2.casilla && !jugador4.ficha2.home) {
                                                jugador4.ficha2.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \033[32mFicha 2\u001B[0m ");
                                            }

                                            if (jugador3.ficha4.casilla == jugador4.ficha3.casilla && !jugador4.ficha3.home) {
                                                jugador4.ficha3.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \032[31mFicha 3\u001B[0m ");
                                            }

                                            if (jugador3.ficha4.casilla == jugador4.ficha4.casilla && !jugador4.ficha4.home) {
                                                jugador4.ficha4.casilla = 0;
                                                System.out.println("La \033[33mFicha 4\u001B[0m se ha comido a la \032[31mFicha 4\u001B[0m ");
                                            }

                                        } else {
                                            System.out.println("No se puede mover la \033[33mFicha 4\u001B[0m");
                                            System.out.println("Seleccione otra \033[33mFicha\u001B[0m");
                                        }
                                        break;

                                    default:
                                        System.out.println("Es casilla no existe");

                                }
                            }

                        }
                    } while (dado.numero == 6 || dado.numero == 1 && J3O != 2);
                    System.out.println("FIN---> se acabo todo");
                }
                //fin jugador 3
            }
        }
    }
}
