package sample;

public class puzzle {
    public static void main(String[] args) {
        char[][] puzzle={{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'},
                         {'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'},
                         {'e', 'f', 'r', 'o', 'p', 'o', 'k', 'l'},
                         {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'},
                         {'a', 'b', 'c', 'd', 'e', 'c', 'a', 'n'},
                         {'p', 's', 'r', 'm', 'm', 'a', 'r', 't'},
                         {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'},
                         {'m', 'n', 'o', 'p', 'q', 'r', 's', 't'}};
        int[] position = new int[2];
        position = search(puzzle,"aed");
        System.out.println(position[0]+" "+position[1]);
    }
    public static int[] search(char[][] a,String key){
        int[] location = {-1,-1};
        for (int row = 0;row < a.length ; row++){
            for (int i = 0; i < a[0].length; i++) {
                //1)
                int j =0;
                while (i<=a.length-key.length()&&j<key.length()&&a[row][i+j]==key.charAt(j)){
                    j++;
                }
                if (j == key.length()) {
                    location[0]=row; location[1]=i;
                    return location;
                }
                //2)
                j =0;
                while (i>=key.length()-1&&j<key.length()&&a[row][i+j]==key.charAt(j)){
                    j++;
                }
                if (j == key.length()) {
                    location[0]=row; location[1]=i;
                    return location;
                }
                //3)
                j =0;
                while (row<=a.length-key.length()&&j<key.length()&&a[row+j][i]==key.charAt(j)){
                    j++;
                }
                if (j == key.length()) {
                    location[0]=row; location[1]=i;
                    return location;
                }
                //4)
                j =0;
                while (row>=key.length()-1&&j<key.length()&&a[row+j][i]==key.charAt(j)){
                    j++;
                }
                if (j == key.length()) {
                    location[0]=row; location[1]=i;
                    return location;
                }
                //5)
                j =0;
                while (row<=a.length-key.length()&&i<=a[0].length-key.length() &&j<key.length()&&a[row+j][i+j]==key.charAt(j)){
                    j++;
                }
                if (j == key.length()) {
                    location[0]=row; location[1]=i;
                    return location;
                }
                //6)
                j =0;
                while (row>=key.length()-1&&i>=key.length()-1 &&j<key.length()&&a[row-j][i-j]==key.charAt(j)){
                    j++;
                }
                if (j == key.length()) {
                    location[0]=row; location[1]=i;
                    return location;
                }
                //7)
                j =0;
                while (row<=a.length-key.length()-1&&i>=key.length()-1 &&j<key.length()&&a[row+j][i-j]==key.charAt(j)){
                    j++;
                }
                if (j == key.length()) {
                    location[0]=row; location[1]=i;
                    return location;
                }
                //8)
                j =0;
                while (row<=key.length()-1&&i<=a[0].length-key.length() &&j<key.length()&&a[row-j][i+j]==key.charAt(j)){
                    j++;
                }
                if (j == key.length()) {
                    location[0]=row; location[1]=i;
                    return location;
                }
            }
        }
        return location;
    }
}
