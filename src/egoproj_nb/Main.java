/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package egoproj_nb;

import java.awt.Point;
import java.sql.Date;


public class Main {
   
//otobüs    
    public class otobus {
        int id;
        int no;
        String ad;
        
    } 
    
//durak   
    public class durak {
        int id;
        int no;
        String ad;
        Point lokasyon; 
   }  

//harita   
    public class harita {
       
        Point konum;
        
        private void goruntule(){
            Harita frm4=new Harita();
            frm4.setVisible(true);
        }
   } 

//bildiri   
    public class bildiri {
        int bildiri_no;
        Date bildiri_tarih;         
   }   

//şikayetçi   
    public class sikayetci {
        String TC;
        String ad;
        String soyad;
        String tel;
        String mail;
        String bildiri;
   }
}


