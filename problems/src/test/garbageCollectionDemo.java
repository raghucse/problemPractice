package test;

/**
 * Created by raghu on 1/3/2017.
 */

class Fdemo{
    int i;

    Fdemo( int i){
        this.i = i;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Destroying "+ i +" object");
    }

    public void generate(int i)
    {
        new Fdemo(i);
    }

}


public class garbageCollectionDemo {
    public static void main(String[] args) {
        Fdemo example = new Fdemo(1);

        for(int i =2; i <= 10000000; i++)
        {
            example.generate(i);
        }
    }

}
