public class BichoEspacial extends Bicho{
    public BichoEspacial(){
        super(30);
    }
    
    @Override
    public String toString(){
        String informacion = ("BE-"+super.getSalud()); 
        return informacion;
    }
}
