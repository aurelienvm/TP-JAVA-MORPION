import MG2D.*;
import MG2D.geometrie.*;
import java.awt.Font;

class InterfaceGraphique {
    
    
    public static void main(String[] args){
        Plateau tabInterface = new Plateau();
        int X = 300;
        int Y = 400;
        int J = 1;
        Fenetre f = new Fenetre("MORPION",X,Y);
        Souris s = f.getSouris();
        Texte texteJoueur1 = new Texte(Couleur.ORANGE,"ORANGE (J1)",new Font("Arial",Font.TYPE1_FONT,30),new Point(150,360));
        Texte texteJoueur2 = new Texte(Couleur.BLEU,"VIOLET (J2)",new Font("Arial",Font.TYPE1_FONT,0),new Point(150,360));
    
        // Permet d'afficher la grille.
        for(int i=1;i<3;i++){
            Ligne Horizontale = new Ligne(new Point(0,i*100),new Point(X,i*100));
            f.ajouter(Horizontale);
            
        }
        for(int j=1;j<3;j++){
            Ligne Verticale = new Ligne(new Point(j*100,X),new Point(j*100,0));
            f.ajouter(Verticale);
        } 
        f.rafraichir();
        
        

        while(tabInterface.gagne() == 0 && tabInterface.plein() == false){
            tabInterface = cliqueSouris(s,f,tabInterface,J);
            System.out.println(tabInterface);
            f.rafraichir();
        
        
        
        // Permet de passer d'un joueur à un autre.
        if(J == 1){
            f.supprimer(texteJoueur2);
            f.ajouter(texteJoueur1);
            J = 2;
         
            
        }else if(J == 2){
            f.supprimer(texteJoueur1);
            f.ajouter(texteJoueur2);
            J = 1;
            
        }
        f.rafraichir();
        }

        // Permet de vérifier s'il y a un gagnant.
        if (tabInterface.gagne() == 1){
            try{
                Thread.sleep(500);
            }catch(Exception e){}
            f.effacer();
            Texte victoireJoueur1 = new Texte(Couleur.ORANGE,"Le joueur1 gagne!",new Font("Arial",Font.TYPE1_FONT,22),new Point(150,250));
            f.ajouter(victoireJoueur1);
            }
            else if(tabInterface.gagne() == 2){
            try{
                Thread.sleep(500);
            }catch(Exception e){}
            f.effacer();
            Texte victoireJoueur2 = new Texte(Couleur.BLEU,"Le joueur2 gagne!",new Font("Arial",Font.TYPE1_FONT,22),new Point(150,250));
            f.ajouter(victoireJoueur2);
            }
            
            if(tabInterface.gagne() == 0){
                try{
                    Thread.sleep(500);
                }catch(Exception e){}
                f.effacer();
                Texte egalite = new Texte(Couleur.NOIR,"ex æquo!",new Font("Arial",Font.TYPE1_FONT,30),new Point(150,250));
                f.ajouter(egalite);
            }
            f.rafraichir();
        
    }
    

    // Utilisation de la souris.
    public static Plateau cliqueSouris(Souris s,Fenetre f,Plateau tabInterface,int J){
        Point souris = new Point();
        boolean placeDispo = false;
        Couleur couleurJ1 = new Couleur(255,190,140);
        Couleur couleurJ2 = new Couleur(210,160,228);

            do{
                souris = new Point(s.getPosition()); 
                try{
                    Thread.sleep(1);
                }catch(Exception e){}
            }while(!s.getClicGauche());
            
            int xMouse = souris.getX()/100;
            int yMouse = souris.getY()/100;



        if(placeDispo= false){ 
            if(J == 1){
                J = 2;
                   
            }
            else if(J == 2){
                J = 1;       
            }
        }
        else{
            tabInterface.getCase(xMouse, yMouse).SetX(J);
            
        }
        
        if(J == 1){
            Cercle c1 = new Cercle(couleurJ1,new Point(xMouse*100+50,yMouse*100+50),50,true); 
            f.ajouter(c1);
            
            
        }
        else if(J == 2){
            Cercle c2 = new Cercle(couleurJ2,new Point(xMouse*100+50,yMouse*100+50),50,true);
            f.ajouter(c2);
            
            
        }
        
        return tabInterface;
        
    }
    
}


