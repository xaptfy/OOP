import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;

public class FractalExplorer {
    private int displaySize; //размер дисплея
    private JImageDisplay display; //для обновления отображения в разных методах
    private FractalGenerator fractal; //будет использоваться ссылка на баззовый класс для отображения других фракталов
    private Rectangle2D.Double range; //указывает диапазон коплексной плоскости, выводящийся на экран
    public FractalExplorer(int size) {
        //размер дисплея
        displaySize = size;
        //инициализирует фрактал генератор
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);
    }
    //создаем и рисуем на окне
    public void createAndShowGUI() {
        //рамка для java.awt.BorderLayout
        display.setLayout(new BorderLayout());
        JFrame myframe = new JFrame("Fractal Explorer");
        //изображение
        myframe.add(display, BorderLayout.CENTER);
        //кнопка сброса
        JButton resetButton = new JButton("Reset Display");
        //сброс кнопки сброса
        ResetHandler handler = new ResetHandler();
        resetButton.addActionListener(handler);
        //добавляем кнопку сброса в BorderLayout.SOUTH
        myframe.add(resetButton, BorderLayout.SOUTH);
        //добавляем MouseHandler
        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);
        //закрытие окна на кнопку закрыть
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Сделать видимым и запретить растягивание
        myframe.pack();
        myframe.setVisible(true);
        myframe.setResizable(false);
    }
    //рисуем фрактал
    private void drawFractal()
    {
        //смотрим каждый пиксель
        for (int x=0; x<displaySize; x++){
            for (int y=0; y<displaySize; y++){
                // координаты х и у фракталы
                double xCoord = fractal.getCoord(range.x, range.x + range.width, displaySize, x);
                double yCoord = fractal.getCoord(range.y, range.y + range.height, displaySize, y);
                //количество итераций для координат в области отображения фрактала
                int iteration = fractal.numIterations(xCoord, yCoord);
                //если итераций 0, то черный пиксель
                if (iteration == -1){
                    display.drawPixel(x, y, 0);
                }
                else
                    {
                    //ставим цвет исходя из числа итераций
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    //обновляем дисплей
                    display.drawPixel(x, y, rgbColor);
                }
            }
        }
        //перерисовываем JImageDisplay
        display.repaint();
    }
    //реализация ActionListener от кнопки сброса
    private class ResetHandler implements ActionListener {
        //рисует фрактал после сброса диапазона
        public void actionPerformed(ActionEvent e)
        {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }
    //класс для обработки событий MouseListener с дисплея
    private class MouseHandler extends MouseAdapter {
        //приблежает при щелчке
        @Override
        public void mouseClicked(MouseEvent e) {
            //получаем х при щелчке
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x, range.x + range.width, displaySize, x);
            //получаем у при щелчке
            int y = e.getY();
            double yCoord = fractal.getCoord(range.y, range.y + range.height, displaySize, y);
            //вызов приблежения с увеличение 2 раза
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            //перерисовываем фрактал
            drawFractal();
        }
    }
    //запускаем это дерьмо с размером 600*600
    public static void main(String[] args) {
        FractalExplorer displayExplorer = new FractalExplorer(600);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}
