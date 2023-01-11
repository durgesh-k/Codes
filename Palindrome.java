public class Palindrome {
public static int countPalindromes(String string) {
int n = string.length();
int[][] palindrome_count = new int[n][n];
for (int i = 0; i < n; i++) {
palindrome_count[i][i] = 1;
}
for (int i = 0; i < n - 1; i++) {
if (string.charAt(i) == string.charAt(i + 1)) {
palindrome_count[i][i + 1] = 1;
}
}
    for (int k = 3; k <= n; k++) {
        for (int i = 0; i <= n - k; i++) {
            int j = i + k - 1;
            if (string.charAt(i) == string.charAt(j) && palindrome_count[i + 1][j - 1] == 1) {
                palindrome_count[i][j] = 1;
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            ans += palindrome_count[i][j];
        }
    }
    return ans;
}

public static void main(String[] args) {
    String string = "aaa";
    System.out.println(countPalindromes(string));

    string = "daata";
    System.out.println(countPalindromes(string)); 

    string = "abccba";
    System.out.println(countPalindromes(string)); 
}}
