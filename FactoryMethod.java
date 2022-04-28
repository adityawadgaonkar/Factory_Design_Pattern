abstract class FactoryMethod{
     void putlabel(){
        System.out.println("Put the labels");
    }
    void putprice(){
        System.out.println("Put the Price");
    }
    abstract void prepare();
}
class IndianStyleTop extends FactoryMethod{
    void prepare(){
        System.out.println("Preparing a Indian Style Top");
    }
}
class IndianStyleBottom extends FactoryMethod{
    void prepare(){
        System.out.println("Preparing a Indian Style Bottom");
    }
}
class WesternStyleTop extends FactoryMethod{
    void prepare(){
        System.out.println("Preparing a Western Style Top");
    }
}
class WesternStyleBottom extends FactoryMethod{
    void prepare(){
        System.out.println("Preparing a Western Style Bottom");
    }
}
abstract class GarmentsStore{
    FactoryMethod g;
    public void orderGarments(String name){
        g=createGarments(name);
        g.putlabel();
        g.putprice();
        g.prepare();
    }
    abstract FactoryMethod createGarments(String name);
}
class IndianGarmentsStore extends GarmentsStore{
    FactoryMethod g;
    FactoryMethod createGarments(String name){
        if(name.equalsIgnoreCase("Indian Style Top")){
            g=new IndianStyleTop();
        }
        if(name.equalsIgnoreCase("Indian Style Bottom")){
            g=new IndianStyleBottom();
        }
        return g;
    }
}

class WesternGarmentsStore extends GarmentsStore{
    FactoryMethod g;
    FactoryMethod createGarments(String name){
        if(name.equalsIgnoreCase("Western Style Top")){
            g=new WesternStyleTop();
        }
        if(name.equalsIgnoreCase("Western Style Bottom")){
            g=new WesternStyleBottom();
        }
        return g;
    }
}
class Demo{
    public static void main(String[] args) {
        GarmentsStore gs;
        gs=new IndianGarmentsStore();
        gs.orderGarments("Indian Style Top");  
        gs.orderGarments("Indian Style Bottom");  

        System.out.println("-------------------------");
        GarmentsStore gs1;
        gs1=new WesternGarmentsStore();
        gs1.orderGarments("Western Style Top");  
        gs1.orderGarments("Western Style Bottom");  
    }
}