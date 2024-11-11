/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Logica;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Mao
 */
public class SVGImage extends JLabel{
    
    private FlatSVGIcon svgIcon;
    
    public void setSvgImage(String imagen, int width, int height) {
        setIcon(svgIcon);
    }
}
