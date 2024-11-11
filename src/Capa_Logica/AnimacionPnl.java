/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import Capa_Interfaz.PanelRound;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Mao
 */
public class AnimacionPnl {
    
    // Metodo para animar un panel en conjunto a un boton
    public void animarPanel(JPanel pnl, JButton btn, JPanel contenedor) {
        if(pnl.getX() == 0){
            Animacion.Animacion.mover_izquierda(pnl.getX(), -pnl.getWidth(), 10, 12, pnl);
            Animacion.Animacion.mover_izquierda(btn.getX(), 0, 10, 12, btn);
            Animacion.Animacion.mover_izquierda(contenedor.getX(), 100, 10, 12, contenedor);
            btn.setIcon(new FlatSVGIcon("Imagenes/Expand2.svg"));
        } 
        else{
            Animacion.Animacion.mover_derecha(pnl.getX(), 0, 10, 12, pnl);
            Animacion.Animacion.mover_derecha(btn.getX(), pnl.getWidth(), 10, 12, btn);
            Animacion.Animacion.mover_derecha(contenedor.getX(), pnl.getWidth(), 10, 12, contenedor);
            btn.setIcon(new FlatSVGIcon("Imagenes/Expand.svg"));
        }
        
        
    }
}
