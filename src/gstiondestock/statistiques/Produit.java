/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gstiondestock.statistiques;

/**
 *
 * @author bel
 */
public class Produit {

    
   
            
    public String getNom_pro() {
        return nom_High_pro_profit;
    }

    
     public int getid() {
        return id_produit_wanted;
    }
       public double getff() {
        return ff;
    }
   
    private int id_produit_wanted;
    private double ff;
    private String nom_High_pro_profit;
   

    public Produit(String nom_High_pro_profit, double qte_High_pro_profit) {
        this.nom_High_pro_profit = nom_High_pro_profit;
        this.ff = qte_High_pro_profit;
    }

    public Produit(int id_produit_wanted, double qte_wanted) {
        this.id_produit_wanted = id_produit_wanted;
        this.ff = qte_wanted;
    }

    public Produit(double profit) {
        this.ff = profit;

    }

    
}
