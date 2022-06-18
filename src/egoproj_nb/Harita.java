
package egoproj_nb;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import waypoint.EventWaypoint;
import waypoint.MyWaypoint;
import waypoint.WaypointRender;

public class Harita extends javax.swing.JFrame {
    
    private final Set<MyWaypoint> waypoints = new HashSet<>();
    private EventWaypoint event;
    
    public Harita() {
        initComponents();
        init();
    }
    public FrmGiris parent;
    
    private void init(){
        TileFactoryInfo info = new OSMTileFactoryInfo();
        //new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP)
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer.setTileFactory(tileFactory);
        GeoPosition geo = new GeoPosition (39.9837055,32.8228384);
        jXMapViewer.setAddressLocation(geo);
        jXMapViewer.setZoom(8);
        
        MouseInputListener mm = new PanMouseInputListener(jXMapViewer);
        jXMapViewer.addMouseListener(mm);
        jXMapViewer.addMouseMotionListener(mm);
        jXMapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer));
        event=getEvent();
    }
    
    private void addWaypoint(MyWaypoint waypoint) {
        for(MyWaypoint d:waypoints){
            jXMapViewer.remove(d.getButton());
        }
        waypoints.add(waypoint);
        initWaypoint();
    }
    
    private void initWaypoint() {
        WaypointPainter<MyWaypoint> wp = new WaypointRender();
        wp.setWaypoints(waypoints);
        jXMapViewer.setOverlayPainter(wp);
        for(MyWaypoint d:waypoints){
            jXMapViewer.add(d.getButton());
        }
    }
    
    private void clearWaypoint(){
        for(MyWaypoint d:waypoints){
            jXMapViewer.remove(d.getButton());
        }
        waypoints.clear();
        initWaypoint();
    }
    
    private EventWaypoint getEvent(){
        return new EventWaypoint(){
            @Override
            public void selected(MyWaypoint waypoint){
                JOptionPane.showMessageDialog(Harita.this, waypoint.getName());
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMapViewer = new org.jxmapviewer.JXMapViewer();
        cmdAdd = new javax.swing.JButton();
        cmdClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DURAKLAR");

        cmdAdd.setText("Durakları Göster");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });

        cmdClear.setText("Durakları Gizle");
        cmdClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapViewerLayout = new javax.swing.GroupLayout(jXMapViewer);
        jXMapViewer.setLayout(jXMapViewerLayout);
        jXMapViewerLayout.setHorizontalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapViewerLayout.createSequentialGroup()
                .addComponent(cmdAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdClear)
                .addGap(0, 633, Short.MAX_VALUE))
        );
        jXMapViewerLayout.setVerticalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapViewerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdAdd)
                    .addComponent(cmdClear))
                .addContainerGap(540, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jXMapViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jXMapViewer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
       

       addWaypoint(new MyWaypoint("KAZAN AİLE YAŞAM MERKEZİ - 51133", event, new GeoPosition(40.233296, 32.688325)));       
       addWaypoint(new MyWaypoint("TARIK BUĞRA SK. - 51139", event, new GeoPosition(40.228920, 32.687027)));       
       addWaypoint(new MyWaypoint("ADLİYE KAZAN - 51138", event, new GeoPosition(40.224728, 32.685800)));       
       addWaypoint(new MyWaypoint("KAZAN KAYMAKAMLIĞI - 51136", event, new GeoPosition(40.221867, 32.684959)));       
       addWaypoint(new MyWaypoint("ÖĞRETMEN KOŞU YOLU - 51135", event, new GeoPosition(40.217456, 32.683718)));       
       addWaypoint(new MyWaypoint("SATI KADIN PARKI - 51134", event, new GeoPosition(40.214682, 32.682885)));       
       addWaypoint(new MyWaypoint("KAZAN DSİ - 51146", event, new GeoPosition(40.211148, 32.681824)));       
       addWaypoint(new MyWaypoint("KAZAN ANADOLU TİCARET MESLEK LİSESİ - 51110", event, new GeoPosition(40.208564, 32.681057)));       
       addWaypoint(new MyWaypoint("KAZAN BELEDİYESİ - 51109", event, new GeoPosition(40.206148, 32.680907)));        
       addWaypoint(new MyWaypoint("HAMDİ ERİŞ DEVLET HASTANESİ - 51353", event, new GeoPosition(40.202222, 32.680371)));
       addWaypoint(new MyWaypoint("OSMANLI CD. - 51124", event, new GeoPosition(40.197461, 32.673934)));
       addWaypoint(new MyWaypoint("OKSAN SK. - 52332", event, new GeoPosition(40.194645, 32.669637)));
       addWaypoint(new MyWaypoint("KAZAN TOKİ - 51125", event, new GeoPosition(40.191052, 32.671054)));
       addWaypoint(new MyWaypoint("AYBÜKE SK. - 51123", event, new GeoPosition(40.192937, 32.674077)));
       addWaypoint(new MyWaypoint("KAHRAMANKAZAN DEVLET HASTANESİ - 57016", event, new GeoPosition(40.195933, 32.676346)));
       addWaypoint(new MyWaypoint("HAMDİ ERİŞ DEVLET HASTANESİ - 52343", event, new GeoPosition(40.202123, 32.680510)));       
       addWaypoint(new MyWaypoint("KAZAN TERMİNAL - 51122", event, new GeoPosition(40.202919, 32.682247)));       
       addWaypoint(new MyWaypoint("ANKARA BLV. MİLLİ EGEMENLİK PARKI - 51120", event, new GeoPosition(40.201834, 32.683221)));       
       addWaypoint(new MyWaypoint("KAYI ORTA OKULU - 51118", event, new GeoPosition(40.198674, 32.688169)));       
       addWaypoint(new MyWaypoint("ARTVİN MAHALLESİ - 51114", event, new GeoPosition(40.194565, 32.690383)));       
       addWaypoint(new MyWaypoint("OSMANLI CD. - 52344", event, new GeoPosition(40.187489, 32.688961)));       
       addWaypoint(new MyWaypoint("YEŞİLOVA VİLLALARI - 51112", event, new GeoPosition(40.184354, 32.687082)));       
       addWaypoint(new MyWaypoint("KARAYOLLARI BÖLGE - 51100", event, new GeoPosition(40.180178, 32.683621)));      
       addWaypoint(new MyWaypoint("KUMPINAR KÖYÜ - 51105", event, new GeoPosition(40.174777, 32.678419)));       
       addWaypoint(new MyWaypoint("AYDIN KÖYÜ - 51097", event, new GeoPosition(40.165134, 32.668480)));       
       addWaypoint(new MyWaypoint("KUM OCAKLARI - 51104", event, new GeoPosition(40.158068, 32.662507)));       
       addWaypoint(new MyWaypoint("GAZİ ÜNİVERSİTESİ MESLEK YÜKSEK OKULU - 53117", event, new GeoPosition(40.149957, 32.655055)));       
       addWaypoint(new MyWaypoint("MALİYE DENETİM - 51102", event, new GeoPosition(40.143469, 32.650156)));       
       addWaypoint(new MyWaypoint("İMRENDİ KÖYÜ - 51095", event, new GeoPosition(40.133496, 32.642197)));       
       addWaypoint(new MyWaypoint("İMRENDİ MAHALLESİ - 56882", event, new GeoPosition(40.122831, 32.636291)));       
       addWaypoint(new MyWaypoint("KARAYOL AĞIRLIK KONTROL - 50961", event, new GeoPosition(40.117366, 32.633103)));      
       addWaypoint(new MyWaypoint("D750 KARAYOLU - 50940", event, new GeoPosition(40.114191, 32.630645)));       
       addWaypoint(new MyWaypoint("ANKARA BOLU YOLU - 53255", event, new GeoPosition(40.107459, 32.626708)));       
       addWaypoint(new MyWaypoint("ANKARA ÜNİVERSİTESİ VETERİNERLİK FAKÜLTESİ - 50968", event, new GeoPosition(40.092955, 32.620861)));       
       addWaypoint(new MyWaypoint("DAĞYAKA KÖYÜ - 50958", event, new GeoPosition(40.087260, 32.617471)));       
       addWaypoint(new MyWaypoint("CUMHURİYET SARAY TESİSLERİ - 50956", event, new GeoPosition(40.080515, 32.613323)));
       addWaypoint(new MyWaypoint("2008 SK. - 53020", event, new GeoPosition(40.078272, 32.611970)));     
       addWaypoint(new MyWaypoint("AKINCI YOL AYRIMI - 50981", event, new GeoPosition(40.064549, 32.614343)));       
       addWaypoint(new MyWaypoint("ÇANİÇİ CD. - 50984", event, new GeoPosition(40.064646, 32.614306)));       
       addWaypoint(new MyWaypoint("ATOM CD. - 50992", event, new GeoPosition(40.061101, 32.618466)));
       addWaypoint(new MyWaypoint("115 SK. - 50979", event, new GeoPosition(40.056074, 32.625289)));
       addWaypoint(new MyWaypoint("HAMDİ ERİŞ İLKOKULU - 50976", event, new GeoPosition(40.052630, 32.629867)));       
       addWaypoint(new MyWaypoint("GIDACILAR CD. - 50995", event, new GeoPosition(40.048686, 32.635006)));
       addWaypoint(new MyWaypoint("YURT SK. - 50994", event, new GeoPosition(40.041943, 32.637379)));
       addWaypoint(new MyWaypoint("ANKARA BOLU YOLU - 50978", event, new GeoPosition(40.035684, 32.638415)));       
       addWaypoint(new MyWaypoint("SUSUZ KÖYÜ - 51084", event, new GeoPosition(40.017727, 32.652644)));       
       addWaypoint(new MyWaypoint("ANKARA DEFTERDARLIĞI SUSUZ KÖY DEPOSU - 50735", event, new GeoPosition(40.009740, 32.655113))); 
       addWaypoint(new MyWaypoint("ASKİ SUSUZ POMPA İSTASYONU - 51083", event, new GeoPosition(40.005386, 32.655763)));       
       addWaypoint(new MyWaypoint("GÖKSU PARKI ÜST GİRİŞİ - 50736", event, new GeoPosition(39.996909, 32.655553)));       
       addWaypoint(new MyWaypoint("GÖKSU PARK - 51091", event, new GeoPosition(39.993199, 32.655219)));       
       addWaypoint(new MyWaypoint("GÖKSU PARK ÇIKIŞI - 51089", event, new GeoPosition(39.986528, 32.656327)));
       addWaypoint(new MyWaypoint("ÜTOPYA KONUTLARI - 57004", event, new GeoPosition(39.983904, 32.657145)));       
       addWaypoint(new MyWaypoint("İSTANBUL YOLU METRO İSTASYONU - 51090", event, new GeoPosition(39.979747, 32.658364)));       
       addWaypoint(new MyWaypoint("ARAÇ MUAYENE - 51154", event, new GeoPosition(39.977572, 32.658970)));       
       addWaypoint(new MyWaypoint("KAPLAN CD. - 50767", event, new GeoPosition(39.974919, 32.659900)));       
       addWaypoint(new MyWaypoint("TARIM KREDİ KOOPERATİFİ - 50792", event, new GeoPosition(39.972008, 32.661810)));
       addWaypoint(new MyWaypoint("TARIM KREDİ KOOPERATİFİ - 51252", event, new GeoPosition(39.968878, 32.666987)));       
       addWaypoint(new MyWaypoint("AYAŞ 48 GÜN KÖPRÜ - 51175", event, new GeoPosition(39.964798, 32.675708)));       
       addWaypoint(new MyWaypoint("3. HAVA İSTİKAM - 51166", event, new GeoPosition(39.959395, 32.686678)));       
       addWaypoint(new MyWaypoint("HAVA ULAŞTIRMA - 51167", event, new GeoPosition(39.956090, 32.692234)));       
       addWaypoint(new MyWaypoint("İSGÜM - 51178", event, new GeoPosition(39.952245, 32.698303)));       
       addWaypoint(new MyWaypoint("AÇIK CEZAEVİ - 51179", event, new GeoPosition(39.949664, 32.702380)));
       addWaypoint(new MyWaypoint("HAVA KUVVETLERİ MÜZESİ - 51180", event, new GeoPosition(39.947014, 32.707089)));      
       addWaypoint(new MyWaypoint("ŞAŞMAZ OTO SANAYİ KAVŞAĞI - 51181", event, new GeoPosition(39.945162, 32.714163)));
       addWaypoint(new MyWaypoint("GÜVERCİNLİK JANDARMA KOMUTANLIĞI - 51182", event, new GeoPosition(39.945114, 32.718679)));
       addWaypoint(new MyWaypoint("JANDARMA İSTİHKAM İNŞAAT GRUP KOMUTANLIĞI - 51183", event, new GeoPosition(39.944999, 32.726004)));
       addWaypoint(new MyWaypoint("EŞREF BİTLİS KIŞLASI - 51184", event, new GeoPosition(39.944960, 32.737870)));
       addWaypoint(new MyWaypoint("AFET ACİL DURUM EĞİTİM MERKEZİ - 51185", event, new GeoPosition(39.944900, 32.745164)));
       addWaypoint(new MyWaypoint("KARA HAVACILIK OKULU - 51207", event, new GeoPosition(39.944867, 32.749071)));
       addWaypoint(new MyWaypoint("ŞEHİTLER PARKI - 51208", event, new GeoPosition(39.944792, 32.757010)));
       addWaypoint(new MyWaypoint("ACİTY AVM - 51209", event, new GeoPosition(39.944759, 32.761749)));
       addWaypoint(new MyWaypoint("TOPRAK MAHSULLERİ OFİSİ - 51250", event, new GeoPosition(39.944714, 32.767080)));
       addWaypoint(new MyWaypoint("TRAFİK ŞUBE - 10692", event, new GeoPosition(39.945981, 32.777939)));
       addWaypoint(new MyWaypoint("POLİS KOLEJİ - 10693", event, new GeoPosition(39.946912, 32.782888)));
       addWaypoint(new MyWaypoint("ATATÜRK ORMAN ÇİFTLİĞİ KAVŞAĞI - 10694", event, new GeoPosition(39.948564, 32.787417)));       
       addWaypoint(new MyWaypoint("ANFA GÜVENLİK - 10712", event, new GeoPosition(39.951554, 32.796057)));
       addWaypoint(new MyWaypoint("ÇİFTLİK TOKİ KONUTLARI - 11423", event, new GeoPosition(39.952571, 32.802516)));
       addWaypoint(new MyWaypoint("TARIM BAKANLIĞI KAMPÜSÜ - 11422", event, new GeoPosition(39.953250, 32.808761)));
       addWaypoint(new MyWaypoint("İVEDİK - 11480", event, new GeoPosition(39.953844, 32.817929)));
       addWaypoint(new MyWaypoint("İCRA MÜDÜRLÜĞÜ - 11483", event, new GeoPosition(39.950029, 32.824893))); 
       addWaypoint(new MyWaypoint("TÜRK PATENT ENSTİTÜSÜ - 11471", event, new GeoPosition(39.947552, 32.828281)));
       addWaypoint(new MyWaypoint("GÜZEL SANATLAR - 11522", event, new GeoPosition(39.943917, 32.833279)));
       addWaypoint(new MyWaypoint("ANKARA BÜYÜKŞEHİR BELEDİYESİ - 11532", event, new GeoPosition(39.941115, 32.837050)));
       addWaypoint(new MyWaypoint("ANKARA SPOR SALONU - 11557", event, new GeoPosition(39.937448, 32.845704)));
       addWaypoint(new MyWaypoint("ANKARA SPOR SALONU - 11564", event, new GeoPosition(39.939235, 32.849234)));
       addWaypoint(new MyWaypoint("OPERA - 11645", event, new GeoPosition(39.935277, 32.853882)));
       addWaypoint(new MyWaypoint("ADLİYE - 11646", event, new GeoPosition(39.931390, 32.853903)));
       
       initWaypoint();
    }//GEN-LAST:event_cmdAddActionPerformed

    private void cmdClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearActionPerformed
        clearWaypoint();
    }//GEN-LAST:event_cmdClearActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Harita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdClear;
    private org.jxmapviewer.JXMapViewer jXMapViewer;
    // End of variables declaration//GEN-END:variables
}
