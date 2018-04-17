/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea3KarolYJaha;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author karol
 */
public class Lines extends JPanel {

    Graphics d;

    public Lines() {

        try {

        } catch (Exception e) {
            System.out.println("fatal errorcillo" + e);
        }

    } // constructor

    public void draw(Graphics g) {

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                int x = (int) (Math.random() * 1000) + 1;
                int y = (int) (Math.random() * 1000) + 1;

                g.setColor(Color.blue);

                bresenham(g, x, y, 1500, 600);//600 600  
                break;
            }
        }
        // dibujar los ejes del plano cartesiano

    } // draw

    public void bresenham(Graphics g, int x0, int y0, int x1, int y1) {

        int x, y, dx, dy, p, incE, incNE, stepx, stepy;

        dx = (x1 - x0);//eje x
        dy = (y1 - y0);//eje y

        dx = (int) (Math.random() * 1000) + 1;
        dy = (int) (Math.random() * 1000) + 1;

        /* determinar que punto usar para empezar, cual para terminar */
        if (dy < 0) {
            dy = -dy;
            stepy = -1;//-1

        } else {
            stepy = 1;//1
        }
        if (dx < 0) {
            dx = -dx;
            stepx = -1;

        } else {
            stepx = 1;//puntos para trazar la linea 1
            //  System.out.println("stepx 3" + stepx);

        }
        x = x0;

        y = y0;

        g.drawLine(x0, y0, x0, y0);
        /* se cicla hasta llegar al extremo de la línea */
        if (dx > dy) {
            p = 2 * dy - dx;

            incE = 2 * dy;
            incNE = 2 * (dy - dx);
            while (x != x1) {
                x = x + stepx;
                if (p < 0) {
                    p = p + incE;
                } else {
                    y = y + stepy;
                    p = p + incNE;
                }
                g.drawLine(x, y, x, y);
            }
        } else {
            p = 2 * dx - dy;

            incE = 2 * dx;
       
            incNE = 2 * (dx - dy);

            while (y != y1) {

                y = y + stepy;

                if (p < 0) {
                    p = p + incE;

                } else {
                    x = x + stepx;

                    p = p + incNE;

                    break;
                }
                g.drawLine(x, y, x, y);
            }

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // se llama al meto draw
        draw(g);

    }

    public static void main(String arv[]) {
        JFrame window = new JFrame("Graphing Function");
        window.add(new Lines());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(2000, 1000);
        window.setVisible(true);

    }
}
