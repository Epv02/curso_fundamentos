public class BichoNormal extends Bicho{
    public BichoNormal(){
        super(10);
    }
    
    @Override
    public String toString(){
        String informacion = ("BN-"+super.getSalud()); 
        return informacion;
    }
}
