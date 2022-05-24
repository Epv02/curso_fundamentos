import java.util.Random;
public class Bicho{

    public static Bicho[][] bichos = new Bicho[3][3];
    private int salud;

    public Bicho(){}

    public Bicho(int salud){
        this.salud=salud;
    }

    public void setSalud(int salud){
        this.salud=salud;
    }

    public int getSalud(){
        return this.salud;
    }

    public static void imprimirTablero(Bicho[][] bichos){
        System.out.println("\n|----------------|");
        System.out.println("|TABLERO DE JUEGO|");
        System.out.println("|----------------|");
        System.out.println("\n-------------------");
        for(int i=0; i<Bicho.bichos.length; i++){
            System.out.print("|");
            for(int j=0; j<Bicho.bichos[0].length; j++){
                if(Bicho.bichos[i][j] != (null)){
                    if(Bicho.bichos[i][j].getSalud() > 0){
                        System.out.print(Bicho.bichos[i][j]+"|");
                    } else{
                        System.out.print(" DEAD|");
                    }

                } else {
                    System.out.print("     |");
                }
            }
            System.out.println("\n-------------------");
        }
    }

    public static void disparar(int fila, int columna){
        if(Bicho.bichos[fila][columna] != (null)){
            Bicho.bichos[fila][columna].setSalud(Bicho.bichos[fila][columna].getSalud() - 5);
            System.out.print("----El disparo ha impactado al objetivo----\n\n");
        } else {
            System.out.print("----En esa posicion no hay ningun bicho----\n\n");
        }
    }

    public static void bombaAtomica(){
        Random random = new Random();
        int minimo = 0;
        int maximo = 3;
        int fila = random.nextInt(maximo + minimo);
        int columna = random.nextInt(maximo + minimo);
        if(Bicho.bichos[fila][columna] != (null)  && Bicho.bichos[fila][columna].getSalud() > 0){
            System.out.println("----El bicho en la coordenada(" + fila +","+ columna +") ha sido abatido----\n\n");
            Bicho.bichos[fila][columna].setSalud(0);
        } else {
            Bicho.bombaAtomica();
        }

    }
    public static int[] bichoMenosSalud(){
        int[] posicionMenosSalud = new int[2];
        int saludComparar = 99999;
        int fila = 0;
        int columna = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(Bicho.bichos[i][j] != null){
                    if(saludComparar > Bicho.bichos[i][j].getSalud() && Bicho.bichos[i][j].getSalud() > 0 ){
                        saludComparar = Bicho.bichos[i][j].getSalud();
                        fila = i;
                        columna = j;
                    }
                } 
            } 
        }
        posicionMenosSalud[0] = fila;
        posicionMenosSalud[1] = columna;
        return(posicionMenosSalud);
    }

    public static void bichoMutante(){
        int[] posicionMenosSalud = Bicho.bichoMenosSalud();
        int fila = posicionMenosSalud[0];
        int columna = posicionMenosSalud[1];
        System.out.println("----El bicho en la posición (" + fila +"," + columna + ") ha mutado----\n\n");
        Bicho.bichos[fila][columna].setSalud(Bicho.bichos[fila][columna].getSalud() * 2);
    } 

    public static void intercambio(){
        Random random = new Random();
        int minimo = 0;
        int maximo = 3;
        int fila = random.nextInt(maximo + minimo);
        int columna = random.nextInt(maximo + minimo);
        int fila2 = random.nextInt(maximo + minimo);
        int columna2 = random.nextInt(maximo + minimo);
        if(Bicho.bichos[fila][columna] != null && Bicho.bichos[fila2][columna2] != null && !(fila == fila2 && columna == columna2)){
            System.out.println("----¡Cuidado! estos bichos están revoltosos, coordenada(" + fila +","+ columna +")" + "coordenada(" + fila2 +","+ columna2 +")----");
            Bicho bichotemporal = Bicho.bichos[fila][columna];
            Bicho.bichos[fila][columna] = Bicho.bichos[fila2][columna2];
            Bicho.bichos[fila2][columna2] = bichotemporal;
        } else {
            Bicho.intercambio();
        }
    }

    public static void bombaFila(){
        Random random = new Random();
        int minimo = 0;
        int maximo = 3;
        int vida = 0;
        int fila = random.nextInt(maximo + minimo);
        for(int i = 0; i < 3;i++){
            if(Bicho.bichos[fila][i] != null){
                vida = vida + Bicho.bichos[fila][i].getSalud();
            }
        }
        if(vida == 0){
            Bicho.bombaFila();
        } else {
            for(int j = 0; j < 3; j++){
                if(Bicho.bichos[fila][j] != null){
                    Bicho.bichos[fila][j].setSalud(0);
                }
            }
        }
    }

    public static float promedioVida(int instancias){
        int fila = 0;
        int columna = 0;
        float saludPromedio = 0;
        int bichosMuertos = 0;
        //System.out.println(instancias);
        for(int i = 0;i < instancias; i++){
            if(Bicho.bichos[fila][columna].getSalud() > 0){
                saludPromedio = saludPromedio + Bicho.bichos[fila][columna].getSalud();
            } else {
                bichosMuertos++;
            }
            //System.out.println("Posicion (" + fila + "," + columna + ")");
            if(columna == 2){
                fila++;
                columna = -1;
            }
            columna++;
        }
        if(saludPromedio != 0){
            saludPromedio = saludPromedio /(instancias-bichosMuertos); 
        } else {
            saludPromedio = 0;
        }
        return saludPromedio;
    }

    public static String fraseAbuela(){
        Random random = new Random();
        int minimo = 0;
        int maximo = 5;
        String [] frasesAbuela = new String [5];
        int fraseElegida = random.nextInt(maximo + minimo);
        frasesAbuela[0] = new String("¡Ahora sí le llegóo la hora a estos bichos mijito!\n\n");
        frasesAbuela[1] = new String("¡Este bicho espacial cree que yo soy caída del zarzo!\n\n");
        frasesAbuela[2] = new String("¡Que berriondera mijito, ya aparecieron hasta bichos alienigenas!\n\n");
        frasesAbuela[3] = new String("¡Mija! Pase la chancla que se nos metió un bicho mutante\n\n");
        frasesAbuela[4] = new String("¡Por los clavos de cristo! Un bicho Espacial\n\n");
        return frasesAbuela[fraseElegida];
    }

    public static void cambioSangre(){
        int[] posicionMenosSalud = Bicho.bichoMenosSalud();
        int fila = posicionMenosSalud[0];
        int columna = posicionMenosSalud[1];
        int tempSalud = Bicho.bichos[fila][columna].getSalud();
        Bicho.bichos[fila][columna] = new BichoEspacial();
        Bicho.bichos[fila][columna].setSalud(tempSalud);
        System.out.println("----El bicho en la posición (" + fila +"," + columna + ") ah cambiado de sangre----\n\n");
    } 
}
