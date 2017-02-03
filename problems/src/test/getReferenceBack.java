package test;

/**
 * Created by raghu on 1/5/2017.
 */
public class getReferenceBack {
    int i = 0;
    getReferenceBack(int i)
    {
        this.i = i;
    }

    public static void main(String[] args) {
        getReferenceBack gc = new getReferenceBack(5);
        gc = null;
        System.gc();
        while (true)
        {
           if(refer.g != null) {
               refer.g.back();
               refer.g = null;
               System.gc();
           }
        }

    }

    public void back()
    {
        System.out.println(i);
    }

    @Override
    protected void finalize() throws Throwable {
        refer.g = this;
    }
}
