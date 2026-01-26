import java.util.Scanner;
public class RPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter games: ");
        int n = sc.nextInt();
        int userWins = 0, compWins = 0;
        for(int i=0; i<n; i++) {
            int comp = (int)(Math.random() * 3); 
            System.out.print("0:Rock, 1:Paper, 2:Scissors? ");
            int user = sc.nextInt();
            if(user == comp) System.out.println("Draw");
            else if((user==0 && comp==2) || (user==1 && comp==0) || (user==2 && comp==1)) userWins++;
            else compWins++;
        }
        System.out.println("User Wins: " + userWins + " (" + (userWins*100.0/n) + "%)");
        System.out.println("Comp Wins: " + compWins + " (" + (compWins*100.0/n) + "%)");
    }
}