package Amazon;

/**
 * Created by raghu on 1/16/2017.
 * Find the first circular tour that visits all petrol pumps
 * http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 */
public class PetrolPumpCircle {

    public static void main(String[] args) {

        int[][] a= {{6, 4}, {3, 6}, {7, 3}};
        System.out.println(new PetrolPumpCircle().checkRoute(a));

    }

    public String checkRoute(int a[][])
    {
        int n = a.length -1;
        for(int i=0; i<a.length; i++)
        {
            int end = i;
            int start = (i % n) +1;

            int curPetrol = a[i][0];
            int nextDist = a[i][1];

            if(curPetrol >= nextDist) {
                curPetrol = curPetrol - nextDist;

                while (end != start && curPetrol >= 0) {
                    curPetrol += a[start][0];

                    if (curPetrol < a[start][0])
                        break;
                    else {
                        curPetrol = curPetrol - a[start][1];
                        start = (start % n) + 1;
                    }
                }

                if (end == start) {
                    return String.valueOf(start);
                }
            }
        }

        return "No Solution";
    }
}
