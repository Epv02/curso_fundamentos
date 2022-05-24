import java.util.Random;
import java.util.Scanner;
public class PrincipalBicho{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
            System.out.println("|-------------------------|");
            System.out.println("|BIENVENIDO/A A BichosGame|");
            System.out.println("|-------------------------|");
            System.out.println("|¿Deseas Iniciar el Juego?|");
            System.out.println("|-------------------------|");
            System.out.print("Si/No -->");
            while(true){
                String respuestaUsuario = sc.next();
                if(respuestaUsuario.equalsIgnoreCase("Si") || respuestaUsuario.equalsIgnoreCase("Sí")){
                    PrincipalBicho.iniciarJuego();
                    break;
                } else if(respuestaUsuario.equalsIgnoreCase("No")){
                    System.out.println("Se acaba el juego");
                    break;
                } else {
                    System.out.println("Ingresa una respuesta correcta");
                }
            }
        
        
    }
    public static void imprimirMenu(int instancias){
        Scanner sc = new Scanner(System.in);
        while(true){
            Bicho.imprimirTablero(Bicho.bichos);
            float promedioVida = Bicho.promedioVida(instancias);
            if(promedioVida == 0){
                break;
            }
            System.out.println("|------------------------------------|");
            System.out.println("|           Menú Principal           |");
            System.out.println("|------------------------------------|");
            System.out.println("|Elije una de las siguientes acciones|");
            System.out.println("|    1.Disparar                      |");
            System.out.println("|    2.Lanzar bomba atómica          |");
            System.out.println("|    3.Mutar un bicho                |");
            System.out.println("|    4.Intercambio aleatorio         |");
            System.out.println("|    5.Conversion de sangre          |");
            System.out.println("|    6.Bomba de fila                 |");
            System.out.println("|    7.Promedio tenebroso            |");
            System.out.println("|    8.La frase de la abuela         |");
            System.out.println("|------------------------------------|");
            System.out.print("-->");
            int accion = sc.nextInt();
            if(accion == 0){
              break;
            }
            switch(accion){

                case 1:
                System.out.print("\nIngrese la cordenada en x (fila entre 0 y 2)-->");
                int fila = sc.nextInt();
                System.out.print("\nIngrese la cordenada en y (columna entre 0 y 2)-->");
                int columna = sc.nextInt();
                Bicho.disparar(fila, columna);
                break;

                case 2:
                System.out.println("\n----Se ha lanzado una bomba atómica aleatoriamente----");
                Bicho.bombaAtomica();
                break;

                case 3:
                Bicho.bichoMutante();
                break;

                case 4:
                System.out.println("----Dos bichos han cambiado de lugar----");
                Bicho.intercambio();
                break;
                
                case 5:
                Bicho.cambioSangre();
                break;

                case 6:
                System.out.println("----Se ha lanzado una bomba mucho más potente que matará toda la fila----");
                Bicho.bombaFila();
                break;

                case 7:
                System.out.println("----Los bichos tiene un promedio de " +  String.format("%.2f", Bicho.promedioVida(instancias)) + " de salud-----");
                break;

                case 8:
                System.out.print("La abuela Olga te está diciendo algo: ");
                System.out.print(Bicho.fraseAbuela());
                break;
            }
        }
        System.out.println("|-------------------------------------------|");
        System.out.println("|Parece que has acabado con todos los bichos|");
        System.out.println("|-------------------------------------------|");
        System.out.println("El juego ha terminado");
    }
    public static void iniciarJuego(){
        Random random = new Random();
        int min = 1;
        int max = 8;
        int fila = 0;
        int columna = 0;
        int instancias = random.nextInt(max + min)+min;
        System.out.println("|-----------------------------------------------|");
        System.out.println("| Cantidad de bichos creados para tu tablero: "+instancias+" |");
        System.out.println("|-----------------------------------------------|");
        for(int i = 0; i < instancias; i++){
            int minNumero = 1;
            int maxNumero = 2;
            int numero = random.nextInt(maxNumero + minNumero)+minNumero;
            switch(numero){

                case 1: 
                    Bicho bn1 = new BichoNormal();
                    Bicho.bichos[fila][columna] = bn1;
                    break;

                case 2:
                    Bicho ba1 = new BichoAlien();
                    Bicho.bichos[fila][columna] = ba1;
                    break;

                case 3:
                    Bicho be1 = new BichoEspacial();
                    Bicho.bichos[fila][columna] = be1;
                    break;
            }
            if(columna == 2){
                columna = -1;
                fila++;
            }
            columna++;
        }
        PrincipalBicho.imprimirMenu(instancias);
    }
}
