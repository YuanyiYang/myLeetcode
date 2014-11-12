package first;

public class TestStaticInnerClass {

    int x = 0;
    static int sx = 1;
    
    public void print(){
        System.out.println("Outer class instance print!");
    }
    
    public static void staticPrint(){
        System.out.println("Outer class static print!");
    }
    
    class InnerClass{
        void innerPrint(){
            print();
        }
        
        void innerStaticPrint(){
            staticPrint();
        }
    }
    
    static class StaticInnerClass{
        static void staticInnerInstancePrint(){
            new TestStaticInnerClass().print();
        }
        
        void staticInnerPrint(){
            System.out.println(sx);
        }
    }
    
    public static void main(String[] args) {
        
       StaticInnerClass s = new TestStaticInnerClass.StaticInnerClass();
       s.staticInnerPrint();
    }
}
