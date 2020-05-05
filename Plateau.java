class Plateau {

    // Déclaration des attributs
    private Case tableau[][];
    


    // Constructeur par défaut
    public Plateau(){
        tableau = new Case[3][3];
        for(int i=0; i<tableau.length; i++) {
            for(int j=0; j<tableau[i].length; j++) {
            tableau[i][j]=new Case();
            }
        }
    }

    //GETTER
    public Case getCase(int i, int j) {
        return tableau[i][j];
    }

    // Méthodes
    public boolean plein(){
        boolean rempli = false;

        for (int i=0 ; i<tableau.length ; i++){
            for(int j=0; j<tableau[i].length; j++){
                if(tableau[i][j].GetX() == 0) {
                    return false;
                }
            }
                
        } 
            return true;
    }

    public int gagne(){
        // PARCOURS LIGNE
        for (int i=0 ; i<3 ; i++){
            if (tableau[i][0].GetX() == 1 && tableau[i][1].GetX() == 1 && tableau[i][2].GetX() == 1){
                return tableau[i][0].GetX();
            }
                else if (tableau[i][0].GetX() == 2 && tableau[i][1].GetX() == 2 && tableau[i][2].GetX() == 2){
                    return tableau[i][0].GetX();
                }
               
        }

        // PARCOURS COLONNE
        for (int j=0 ; j<3 ; j++){ 
            if (tableau[0][j].GetX() == 1 && tableau[1][j].GetX() ==1 && tableau[2][j].GetX() == 1) {
                return tableau[0][j].GetX();
            }
            else if (tableau[0][j].GetX() == 2 && tableau[1][j].GetX() ==2 && tableau[2][j].GetX() == 2) {
                return tableau[0][j].GetX();
            
            }
        }
        
        // DIAGONALE
        
            if (tableau[0][0].GetX() == 1 &&  tableau[1][1].GetX() == 1 && tableau[2][2].GetX() == 1) {
                return (tableau[1][1].GetX());
            }
            
            else if (tableau[0][0].GetX() == 2 && tableau[1][1].GetX() ==2 && tableau[2][2].GetX() == 2 ) {
                return (tableau[2][2].GetX());
            }
            
            if (tableau[0][2].GetX() == 1 && tableau[1][1].GetX() == 1 &&  tableau[2][0].GetX() == 1){
                return (tableau[1][1].GetX());
            }

            else if (tableau[0][2].GetX() == 2 && tableau[1][1].GetX() == 2 && tableau[2][0].GetX() == 2){
                return (tableau[2][2].GetX());
            } 
            return 0;
    
        
    }
    

    // ToString
    public String toString() {
        String tab = "";
        for(int i= 0; i< tableau.length; i++) {
            for(int j = 0; j <tableau.length; j++) {
              tab = tab + tableau[i][j];   
    
            }
            tab += "\n";
        }
        return tab;
    }
}
    