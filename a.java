import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class lab {
    public static String Data(int arr[][]) {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) {
                    s += " ";
                } else {
                    s += arr[i][j] + "";
                }
            }
        }
        return s;
    }

    public static ArrayList<String> children(String s) {
        int x = -1;
        int y = -1;
        int k = 0;
        int matrix[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s.charAt(k) == ' ') {
                    x = i;
                    y = j;
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Integer.parseInt(s.charAt(k) + "");
                }
                k++;

            }
        }
        int v = -1;
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        if (x - 1 >= 0) {
            v = matrix[x - 1][y];
            matrix[x - 1][y] = matrix[x][y];
            matrix[x][y] = v;
            a = Data(matrix);
            v = matrix[x - 1][y];
            matrix[x - 1][y] = matrix[x][y];
            matrix[x][y] = v;
        }
        if (y - 1 >= 0) {
            v = matrix[x][y - 1];
            matrix[x][y - 1] = matrix[x][y];
            matrix[x][y] = v;
            b = Data(matrix);
            v = matrix[x][y - 1];
            matrix[x][y - 1] = matrix[x][y];
            matrix[x][y] = v;
        }
        if (x + 1 < 3) {
            v = matrix[x + 1][y];
            matrix[x + 1][y] = matrix[x][y];
            matrix[x][y] = v;
            c = Data(matrix);
            v = matrix[x + 1][y];
            matrix[x + 1][y] = matrix[x][y];
            matrix[x][y] = v;
        }
        if (y + 1 < 3) {
            v = matrix[x][y + 1];
            matrix[x][y + 1] = matrix[x][y];
            matrix[x][y] = v;
            d = Data(matrix);
            v = matrix[x][y + 1];
            matrix[x][y + 1] = matrix[x][y];
            matrix[x][y] = v;
        }
        ArrayList<String> m = new ArrayList<>();
        if (a.length() != 0) {
            m.add(a);
        }
        if (b.length() != 0) {
            m.add(b);
        }
        if (c.length() != 0) {
            m.add(c);
        }
        if (d.length() != 0) {
            m.add(d);
        }
        return m;

    }

    public static boolean agent(String i, Hashtable<String, Integer> h, ArrayList<String> a, String target) {
        a.add(i);
        if (i.compareTo(target) == 0) {
            System.out.println("hello");
            return true;
        }
        h.put(i, 1);
        ArrayList<String> d = children(i);
        // System.out.println(d);
        for (String s : d) {
            if (h.containsKey(s)) {
                return false;
            }else {
                if (agent(s, h, a, target)) {
                    return true;
                }
            }
        }
        a.remove(i);
        return false;
    }

    public static void main(String[] args) {
        int arr[][] ={ { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 0, 8 },
};
        int target[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 0 },
        };
        String s = "";
        String t = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) {
                    s += " ";
                } else {
                    s += arr[i][j] + "";
                }
                if (target[i][j] == 0) {
                    t += " ";
                } else {
                    t += target[i][j] + "";
                }
            }
        }
        System.out.println(s);
        System.out.println(t);
        Hashtable<String, Integer> h = new Hashtable<>();
        ArrayList<String> a = new ArrayList<>();
        agent(s, h, a, t);
        System.out.println(a);
    }
}