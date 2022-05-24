public class BichoAlien extends Bicho
{
    public BichoAlien(){
        super(20);
    }
    
    @Override
    public String toString(){
        String informacion = ("BA-"+super.getSalud()); 
        return informacion;
    }
}
