/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gstiondestock.statistiques;

import gstiondestock.Db;
import gstiondestock.Home;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 *
 * @author bel
 */
public class Statistique extends javax.swing.JFrame {

    /**
     * Creates new form Statistique
     */
    String date1 = "";
    String date2 = "";
    boolean state = false;

    public Statistique() {
        initComponents();

        //total  entre 
        String sql = "";
        sql = "SELECT sum(qte_entre*prix_achat) AS flot FROM entre";
        double entre = Db.Statistiqueff(sql);
        BigDecimal en = new BigDecimal(entre);
        entree.setText(en + " DA");

        //total  sortie 
        sql = "SELECT sum(qte_sorte*prix_vente) AS flot FROM sorte";
        double sortie = Db.Statistiqueff(sql);
        BigDecimal sorti = new BigDecimal(sortie);
        sortiee.setText(sorti + " DA");

        //profit 
        double profit = sortie - entre;
        BigDecimal pr = new BigDecimal(profit);
        PROFIT.setText(pr + " DA");

        totalProduit();

        //Most Wanted Product
        sql = "SELECT id_pro As id ,MAX(qte_sorte) AS Quantite FROM sorte";
        Produit mostw = Db.most1(sql);
        sql = "SELECT nom_pro AS nom  FROM produits WHERE id_pro=" + mostw.getid();
        String nom_w = Db.getNameById(sql);
        mostwantd.setText(nom_w);
        BigDecimal mwq = new BigDecimal(mostw.getff());
        mqt.setText(mwq + " Piece");

        //-----------------------------------------------------------------------------------------------------
        sql = "SELECT Count(*) AS nb FROM clients";
        int client = Db.getNbRow(sql);
        nbclient.setText(client + "");

        sql = "SELECT Count(*) AS nb FROM fournisseurs";
        int fourni = Db.getNbRow(sql);
        nbfournisseur.setText(fourni + "");

        sql = "SELECT Count(*) AS nb FROM familles WHERE archivage=" + state;
        int famille = Db.getNbRow(sql);
        nbfamiile.setText(famille + "");

        sql = "SELECT Count(*) AS nb FROM produits WHERE archivage_pro=" + state;
        int prod = Db.getNbRow(sql);
        nbproduct.setText(prod + "");

        

       

        //total  entre 
    }

    private void totalProduit() {
        String sql;
        //prix on stock
        sql = "SELECT sum(qte_stock*prix_achat)AS flot FROM produits WHERE archivage_pro=" + state;
        double stock = Db.Statistiqueff(sql);
        BigDecimal sk = new BigDecimal(stock);
        jstock.setText(sk + " DA");

        //Higher profit rate product
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nbclient = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nbfournisseur = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nbproduct = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nbfamiile = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PROFIT = new javax.swing.JLabel();
        mostwantd = new javax.swing.JLabel();
        mqt = new javax.swing.JLabel();
        jstock = new javax.swing.JLabel();
        entree = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        sortiee = new javax.swing.JLabel();
        firstdate = new com.toedter.calendar.JDateChooser();
        secenddate = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        is_archiver = new javax.swing.JCheckBox();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(23, 32, 33));

        jLabel1.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Statistiques");

        jLabel10.setBackground(new java.awt.Color(63, 157, 215));
        jLabel10.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Number  clients  :  ");

        nbclient.setBackground(new java.awt.Color(204, 255, 51));
        nbclient.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        nbclient.setForeground(new java.awt.Color(63, 157, 215));
        nbclient.setText("_____");
        nbclient.setInheritsPopupMenu(false);

        jLabel12.setBackground(new java.awt.Color(63, 157, 215));
        jLabel12.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Number Fournisseur :");

        nbfournisseur.setBackground(new java.awt.Color(204, 255, 51));
        nbfournisseur.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        nbfournisseur.setForeground(new java.awt.Color(63, 157, 215));
        nbfournisseur.setText("_____");
        nbfournisseur.setInheritsPopupMenu(false);

        jLabel13.setBackground(new java.awt.Color(63, 157, 215));
        jLabel13.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Number  produit :");

        nbproduct.setBackground(new java.awt.Color(204, 255, 51));
        nbproduct.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        nbproduct.setForeground(new java.awt.Color(63, 157, 215));
        nbproduct.setText("_____");
        nbproduct.setInheritsPopupMenu(false);

        jLabel16.setBackground(new java.awt.Color(63, 157, 215));
        jLabel16.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Number  Famille :");

        nbfamiile.setBackground(new java.awt.Color(204, 255, 51));
        nbfamiile.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        nbfamiile.setForeground(new java.awt.Color(63, 157, 215));
        nbfamiile.setText("_____");
        nbfamiile.setInheritsPopupMenu(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nbclient, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nbfournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nbproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nbfamiile, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbclient, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbfournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbfamiile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(38, 45, 53));
        jPanel3.setForeground(new java.awt.Color(63, 157, 215));
        jPanel3.setToolTipText("--------------");

        jLabel2.setBackground(new java.awt.Color(63, 157, 215));
        jLabel2.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Profit");

        jLabel4.setBackground(new java.awt.Color(63, 157, 215));
        jLabel4.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Most Wanted Product");

        jLabel5.setBackground(new java.awt.Color(63, 157, 215));
        jLabel5.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total price Achat");

        jLabel6.setBackground(new java.awt.Color(63, 157, 215));
        jLabel6.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Prix VENT");

        jLabel7.setBackground(new java.awt.Color(63, 157, 215));
        jLabel7.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Prix on stock");

        PROFIT.setBackground(new java.awt.Color(204, 255, 51));
        PROFIT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PROFIT.setForeground(new java.awt.Color(63, 157, 215));
        PROFIT.setText("_____________");
        PROFIT.setInheritsPopupMenu(false);

        mostwantd.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        mostwantd.setForeground(new java.awt.Color(63, 157, 215));
        mostwantd.setText("--------------");
        mostwantd.setToolTipText("");

        mqt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        mqt.setForeground(new java.awt.Color(63, 157, 215));
        mqt.setText("--------------");
        mqt.setToolTipText("");

        jstock.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jstock.setForeground(new java.awt.Color(63, 157, 215));
        jstock.setText("--------------");
        jstock.setToolTipText("--------------");

        entree.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        entree.setForeground(new java.awt.Color(63, 157, 215));
        entree.setText("--------------");
        entree.setToolTipText("--------------");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 204, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        sortiee.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        sortiee.setForeground(new java.awt.Color(63, 157, 215));
        sortiee.setText("--------------");
        sortiee.setToolTipText("--------------");

        firstdate.setFont(new java.awt.Font("Inter Black", 0, 12)); // NOI18N
        firstdate.setMaxSelectableDate(new java.util.Date(253370808112000L));
        firstdate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                firstdateAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        secenddate.setBackground(new java.awt.Color(255, 255, 255));
        secenddate.setFont(new java.awt.Font("Inter Black", 0, 12)); // NOI18N
        secenddate.setMaxSelectableDate(new java.util.Date(253370808112000L));

        jLabel9.setBackground(new java.awt.Color(63, 157, 215));
        jLabel9.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Secend date");

        jLabel11.setBackground(new java.awt.Color(63, 157, 215));
        jLabel11.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("First date");

        jButton1.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("send");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        is_archiver.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        is_archiver.setForeground(new java.awt.Color(255, 255, 255));
        is_archiver.setText("Archivage");
        is_archiver.setContentAreaFilled(false);
        is_archiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                is_archiverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(mostwantd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mqt, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jstock, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entree, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sortiee, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(firstdate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(secenddate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1))
                                    .addComponent(PROFIT, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(is_archiver, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(is_archiver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secenddate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PROFIT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mostwantd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mqt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortiee, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entree, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jstock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(804, 468));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Home h = new Home();
        h.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void firstdateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_firstdateAncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_firstdateAncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date1 = sdf.format(firstdate.getDate());
        date2 = sdf.format(secenddate.getDate());
        System.out.println(date1 + " " + date2);
        String sql = "";
        sql = "SELECT sum(qte_entre*prix_achat) AS flot FROM entre WHERE date BETWEEN '" + date1 + "' AND '" + date2 + "'";
        System.out.println(sql);
        double entre = Db.Statistiqueff(sql);
        BigDecimal en = new BigDecimal(entre);
        entree.setText(en + " DA");

        //total  sortie 
        sql = "SELECT sum(qte_sorte*prix_vente) AS flot FROM sorte WHERE date BETWEEN '" + date1 + "' AND '" + date2 + "'";
        System.out.println(sql);
        double sortie = Db.Statistiqueff(sql);
        BigDecimal sorti = new BigDecimal(sortie);
        sortiee.setText(sorti + " DA");

        //profit 
        double profit = sortie - entre;
        BigDecimal pr = new BigDecimal(profit);
        PROFIT.setText(pr + " DA");

        //Most Wanted Product
        sql = "SELECT id_pro As id ,MAX(qte_sorte) AS Quantite FROM sorte WHERE date BETWEEN '" + date1 + "' AND '" + date2 + "'";
        System.out.println(sql);
        Produit mostw = Db.most1(sql);
        sql = "SELECT nom_pro AS nom  FROM produits WHERE id_pro=" + mostw.getid();
        System.out.println(sql);
        String nom_w = Db.getNameById(sql);
        mostwantd.setText(nom_w);
        BigDecimal mwq = new BigDecimal(mostw.getff());
        mqt.setText(mwq + " Piece");

        //-----------------------------------------------------------------------------------------------------
        sql = "SELECT Count(*) AS nb FROM clients WHERE date BETWEEN '" + date1 + "' AND '" + date2 + "'";
        System.out.println(sql);
        int client = Db.getNbRow(sql);
        nbclient.setText(client + "");

        sql = "SELECT Count(*) AS nb FROM fournisseurs WHERE date BETWEEN '" + date1 + "' AND '" + date2 + "'";

        int fourni = Db.getNbRow(sql);
        nbfournisseur.setText(fourni + "");

        sql = "SELECT Count(*) AS nb FROM familles WHERE date BETWEEN '" + date1 + "' AND '" + date2 + "'";
        System.out.println(sql);
        int famille = Db.getNbRow(sql);
        nbfamiile.setText(famille + "");

        sql = "SELECT Count(*) AS nb FROM produits WHERE date BETWEEN '" + date1 + "' AND '" + date2 + "'";
        System.out.println(sql);
        int prod = Db.getNbRow(sql);
        nbproduct.setText(prod + "");

      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void is_archiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_is_archiverActionPerformed
        // TODO add your handling code here:
        state = is_archiver.isSelected();
        totalProduit();
        String sql;
        if (date1 == "" || date2 == "") {
            sql = "SELECT Count(*) AS nb FROM familles WHERE archivage=" + state;
            int famille = Db.getNbRow(sql);
            nbfamiile.setText(famille + "");

            sql = "SELECT Count(*) AS nb FROM produits WHERE archivage_pro=" + state;
            int prod = Db.getNbRow(sql);
            nbproduct.setText(prod + "");
        } else {
            sql = "SELECT Count(*) AS nb FROM familles WHERE date BETWEEN '" + date1 + "' AND '" + date2 + "' AND  archivage=" + state;
            System.out.println(sql);
            int famille = Db.getNbRow(sql);
            nbfamiile.setText(famille + "");

            sql = "SELECT Count(*) AS nb FROM produits WHERE date BETWEEN '" + date1 + "' AND '" + date2 + "'AND  archivage_pro=" + state;
            System.out.println(sql);
            int prod = Db.getNbRow(sql);
            nbproduct.setText(prod + "");
        }
    }//GEN-LAST:event_is_archiverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Statistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statistique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PROFIT;
    private javax.swing.JLabel entree;
    private com.toedter.calendar.JDateChooser firstdate;
    private javax.swing.JCheckBox is_archiver;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jstock;
    private javax.swing.JLabel mostwantd;
    private javax.swing.JLabel mqt;
    private javax.swing.JLabel nbclient;
    private javax.swing.JLabel nbfamiile;
    private javax.swing.JLabel nbfournisseur;
    private javax.swing.JLabel nbproduct;
    private com.toedter.calendar.JDateChooser secenddate;
    private javax.swing.JLabel sortiee;
    // End of variables declaration//GEN-END:variables
}
