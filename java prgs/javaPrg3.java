abstract class shape{
    int dim1,dim2;

    abstract void printArea();

    shape(int dim1,int dim2){
        this.dim1=dim1;
        this.dim2=dim2;
    }
}

class rectangle extends shape{

    rectangle(int length,int breadth){
        super(length, breadth);
    }

    void printArea(){
        int area = dim1*dim2;
        System.out.println("Rectangle Area="+area);
    }
    
    
}

class triangle extends shape{

    triangle(int base,int height){
        super(base, height);
    }

    void printArea(){
        double area=0.5*dim1*dim2;
        System.out.println("Triangle Area="+area);
    }
    
}

class circle extends shape{

    circle(int radius){
        super(radius,0);
    }

    void printArea(){
        double area=3.14 * dim1 * dim1;
        System.out.println("Circle Area="+area);
    }
    
}

public class javaPrg3 {
    public static void main(String[] args) {
        shape s;
        s =new rectangle(20,5);
        s.printArea();
        s =new triangle(10,5);
        s.printArea();
        s=new circle(10);
        s.printArea();
    }
}