import java.util.TreeMap;

public class Solution2 {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        tmap.put(6,3);
        tmap.put(8,2);
        tmap.put(4,1);
        System.out.println(tmap.higherKey(5));
        System.out.println(tmap);
    }
}
