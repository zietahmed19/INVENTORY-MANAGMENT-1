/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gstiondestock;

import gstiondestock.statistiques.Produit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Db {

    
//***************************************************************************** Connection Data Base*****************************************************************************
private static Connection myconn;
 public static Connection Createdata() {
        try {  
            myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
              //CREATE DATABASE 
           Statement st=null;
           st=myconn.createStatement();
           st.execute("CREATE DATABASE IF NOT EXISTS InventoryManagmentAInversion");
               System.out.println("create database");
        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
        }
        return myconn;
    }
 
    public static Connection getConnection() {
        try {  myconn=DriverManager.getConnection("jdbc:mysql://localhost/InventoryManagmentAInversion", "root", "");
      System.out.println("connect");
        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
        }
        return myconn;
    }

    public static ResultSet SelectAll(String sql) {
        ResultSet rs = null;
        getConnection();
        Statement stmt = null;

        try {
            stmt = myconn.createStatement();
            rs = stmt.executeQuery(sql);

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
        }

        return rs;
    }

    public static boolean Insert(String sql) {
        getConnection();
        Statement stmt = null;
        try {

            stmt = myconn.createStatement();
            stmt.execute(sql);

            return true;

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return false;
        }

    }

    public static boolean Login(String sql) {

        return isexit(sql);

    }

    public static Produit most(String sql) {
        Produit most = null;

        getConnection();
        ResultSet rs = null;
        Statement stmt = null;

        try {

            stmt = myconn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                most = new Produit(rs.getString("npro"), rs.getDouble("qte"));

            }
            return most;

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return null;

        }

    }

    public static Produit most1(String sql) {
        Produit most1 = null;

        getConnection();
        ResultSet rs = null;
        Statement stmt = null;

        try {

            stmt = myconn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                most1 = new Produit(rs.getInt("id"), rs.getDouble("Quantite"));

            }
            return most1;

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return null;

        }

    }

    public static double Statistiqueff(String sql) {
        Produit profit = null;

        getConnection();
        ResultSet rs = null;
        Statement stmt = null;

        try {

            stmt = myconn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {

                return rs.getDouble("flot");

            } else {
                return 0;
            }

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return 0;

        }

    }

    public static boolean isexit(String sql) {
        getConnection();
        Statement stmt = null;
        boolean exi = false;
        try {
            stmt = myconn.createStatement();
            System.err.println("cooll");
            ResultSet rs = stmt.executeQuery(sql);
            System.err.println("cooll");
            if (rs.next()) {
                if (rs.getInt("nb") > 0) {
                    exi = true;
                }
            }

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            exi = false;
        }
        return exi;
    }

    public static boolean Update(String sql) {

        getConnection();

        Statement stmt = null;
        PreparedStatement ps = null;
        try {

            stmt = myconn.createStatement();
            stmt.execute(sql);
            return true;

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return false;

        }

    }

    public static boolean DELETE(String sql) {

        getConnection();

        Statement stmt = null;

        try {
            stmt = myconn.createStatement();
            stmt.execute(sql);
            return true;

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return false;

        }

    }

    public static JComboBox RemplirِComboBox(JComboBox comb, String sql) {

        comb.removeAllItems();
        ResultSet rs = null;
        getConnection();
        Statement stmt = null;
        try {
            stmt = myconn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                comb.addItem(rs.getString("nom"));
            }

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());

        }

        return comb;
    }

    public static int getIdByName(String sql) {
        getConnection();
        int id = -1;
        Statement stmt = null;

        try {
            //virifier si le client exist deja

            System.err.println(sql);
            stmt = myconn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                id = rs.getInt("id");

            }

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());

        }
        return id;
    }

    public static int getNbRow(String sql) {
        getConnection();
        int row = -1;
        Statement stmt = null;

        try {
            //virifier si le client exist deja

            System.err.println(sql);
            stmt = myconn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                row = rs.getInt("nb");

            }

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());

        }
        return row;
    }

    public static String getNameById(String sql) {
        getConnection();
        String nom = null;
        Statement stmt = null;

        try {
            //virifier si le client exist deja

            System.err.println(sql);
            stmt = myconn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                nom = rs.getString("nom");

            }

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
        }
        return nom;
    }
        public static boolean init() {
        
        getConnection();
        Statement stmt = null;
        try {
          
           stmt = myconn.createStatement();
         
                  
    //Table structure for table `users`
           String users="CREATE TABLE IF NOT EXISTS `users` (\n" +
"  `ID` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT ,\n" +
"  `nameuser` varchar(255) NOT NULL UNIQUE KEY,\n" +
"  `password` varchar(255) NOT NULL\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
           stmt.execute(users);
        //-- --------------------------------------------------------   
         // Table structure for table `clients`
       String clients="CREATE TABLE IF NOT EXISTS `clients` (\n" +
"  `id_client` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT ,\n" +
"  `nom_client` varchar(255) NOT NULL,\n" +
"  `tel_client` text NOT NULL,\n" +
"  `address_client` text NOT NULL,\n" +
"  `date` date NOT NULL DEFAULT current_timestamp()\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
       stmt.execute(clients);
        //-- --------------------------------------------------------
        //Table structure for table `familles`
     String familles="CREATE TABLE IF NOT EXISTS `familles` (\n" +
"  `id_familles` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
"  `nom_familles` varchar(255) NOT NULL,\n" +
"  `archivage` tinyint(1) NOT NULL DEFAULT 0,\n" +
"  `date` date NOT NULL DEFAULT current_timestamp()\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
     stmt.execute(familles);
        //-- --------------------------------------------------------
        //Table structure for table `fournisseurs`
       String fournisseurs="CREATE TABLE IF NOT EXISTS `fournisseurs` (\n" +
"  `id_fournisseurs` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
"  `nom_fournisseurs` varchar(255) NOT NULL,\n" +
"  `tel_fournisseurs` varchar(10) NOT NULL,\n" +
"  `address_fournisseurs` text NOT NULL,\n" +
"  `date` date NOT NULL DEFAULT current_timestamp()\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
        stmt.execute(fournisseurs);
        //-- --------------------------------------------------------
        //Table structure for table `produits`
      String produits="CREATE TABLE IF NOT EXISTS `produits` (\n" +
"  `id_pro` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
"  `nom_pro` varchar(255) NOT NULL,\n" +
"  `id_familles` int(11) NOT NULL ,\n" +
"  `seuil_pro` float NOT NULL DEFAULT 3,\n" +
"  `qte_stock` float NOT NULL DEFAULT 0,\n" +
"  `archivage_pro` tinyint(1) NOT NULL DEFAULT 0,\n" +
"  `date` date NOT NULL DEFAULT current_timestamp(),\n" +
"  FOREIGN KEY (`id_familles`) REFERENCES `familles` (`id_familles`) ON DELETE CASCADE\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
      stmt.execute(produits);
        //-- --------------------------------------------------------
        //Table structure for table `sorte`
         String sorte="CREATE TABLE IF NOT EXISTS `sorte` (\n" +
"  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
"  `id_client` int(11) NOT NULL ,\n" +
"  `qte_sorte` float NOT NULL,\n" +
"  `date` date NOT NULL DEFAULT current_timestamp(),\n" +
"  `id_pro` int(11) NOT NULL,\n" +
"  `prix_vente` decimal(20,2) NOT NULL,\n" +
"  FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`) ON DELETE CASCADE\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
         stmt.execute(sorte);
        //-- --------------------------------------------------------
        //Table structure for table `entre`
           String entre="CREATE TABLE IF NOT EXISTS `entre` (\n" +
"  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
"  `id_fournisseurs` int(11) NOT NULL,\n" +
"  `qte_entre` float NOT NULL,\n" +
"  `date` date NOT NULL DEFAULT current_timestamp(),\n" +
"  `id_pro` int(11) NOT NULL,\n" +
"  `prix_achat` decimal(20,2) NOT NULL,\n" +
"   FOREIGN KEY (`id_fournisseurs`) REFERENCES `fournisseurs` (`id_fournisseurs`) ON DELETE CASCADE\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
            stmt.execute(entre);
        //-- --------------------------------------------------------

            

            return true;

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return false;
        }

    }

}
