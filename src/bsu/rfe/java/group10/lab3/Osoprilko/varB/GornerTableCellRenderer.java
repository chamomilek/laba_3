package bsu.rfe.java.group10.lab3.Osoprilko.varB;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GornerTableCellRenderer implements TableCellRenderer{
    private String needle = null;
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();
    public void setNeedle(String needle) {
        this.needle = needle;
    }
    public GornerTableCellRenderer() {
        // Показывать только 5 знаков после запятой
        formatter.setMaximumFractionDigits(5);
// Не использовать группировку (не отделять тысячи)
// Т.е. показывать число как "1000", а не "1 000" или "1,000"
        formatter.setGroupingUsed(false);
// Установить в качестве разделителя дробной части точку, а не запятую
// По умолчанию, в региональных настройках Россия/Беларусь дробная часть
// отделяется запятой
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
        // Разместить надпись внутри панели
        panel.add(label);
// Установить выравнивание надписи по левому краю панели
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }


    @Override
    public Component getTableCellRendererComponent(JTable table, Object
            value, boolean isSelected, boolean hasFocus, int row, int col) {
// Преобразовать число в строку с помощью форматировщика
        String formattedDouble = formatter.format(value);
        int i;
// Установить текст надписи равным строковому представлению числа
        label.setText(formattedDouble);
        if ( (col == 1) && needle != null && needle.equals(formattedDouble))
        {

            label.setText("true");
                    }

        else {
            // Иначе - в обычный белый
            panel.setBackground(Color.WHITE);
        }
        return panel;

    }

}
