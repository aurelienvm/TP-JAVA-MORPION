import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenue sur le jeu du Morpion.");
        Plateau plateau = new Plateau();
        boolean placeDispo = false;
        int ligne = 0;
        int colonne = 0;
        int J = 1; 
        System.out.println(plateau);
        
        while(plateau.gagne() == 0){
            // Permet d'entrer les coordonées.
            System.out.println("Entrez la ligne: ");
            ligne = input.nextInt();
            System.out.println("Entrez la colonne: ");
            colonne = input.nextInt();
            

            do{
            // Permet de savoir si une case est occupée.
                if(plateau.getCase(ligne,colonne).GetX() ==0){
                    placeDispo=true;
                }
                else{
                    System.out.println("Case déjà jouée. Réessayez");
                    System.out.println("Entrez la ligne: ");
                    ligne = input.nextInt();
                    System.out.println("Entrez la colonne: ");
                    colonne = input.nextInt();
        
                }
            }
            while(!placeDispo);

            if(placeDispo){
                plateau.getCase(ligne,colonne).SetX(J);
            }
        
            System.out.println(plateau);
            
        // Permet de passer d'un joueur à un autre.
            if(J == 1){
                J=2;
            }
			else{
                J=1;
            }

            System.out.println(plateau);
            System.out.println("Joueur suivant:");
        
        }

        if(plateau.gagne() == 1){
            System.out.println("Le joueur 1 a gagne! ");
        }
        else if(plateau.gagne() == 2){
            System.out.println("Le joueur 2 a gagne!");
        }
        else{
            System.out.println("Match nul!");
        }

    }

}
