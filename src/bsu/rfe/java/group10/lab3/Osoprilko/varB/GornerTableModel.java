package bsu.rfe.java.group10.lab3.Osoprilko.varB;

import javax.swing.table.AbstractTableModel;
public class GornerTableModel extends AbstractTableModel {
        private Double[] coefficients;
        private Double from;
        private Double to;
        private Double step;

        public GornerTableModel(Double from, Double to, Double step, Double[]
                coefficients) {
            this.from = from;
            this.to = to;
            this.step = step;
            this.coefficients = coefficients;
        }
        public Double getFrom() {
            return from;
        }
        public Double getTo() {
            return to;
        }
        public Double getStep() {
            return step;
        }
    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public int getRowCount() {
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }
    @Override
    public Object getValueAt(int row, int col) {
// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step*row;
        // Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        Double result = 0.0;
        switch (col)
        {
            case 0:
                {
            return x; }
            case 1:{
// Вычисление значения в точке по схеме Горнера.
// Вспомнить 1-ый курс и реализовать
// ...
            for (int i = coefficients.length - 1; i >= 0; i--)
            {
                result *= x;
                result += coefficients[i];
            }
            return result;
        }
            default: {
            int k = result.intValue();
            int bef=(Math.abs(k) % 10);
            int af = (int) (((result - ((result.intValue())) * 10)));
            String strk = Integer.toString(bef);
            String strf = Integer.toString(af);

            if (strk == strf)
                return true;
            else
                return false;
        }
        }
    }

    @Override
    public Class<?> getColumnClass(int col) {
            if(col==0) return Double.class;
            if(col==1) return Double.class;
            else return Boolean.class;
        }

    @Override
    public String getColumnName(int col)
    {
        switch (col)
        {
            case 0:
                // Название 1-го столбца
                return "Значение X";
            case 1:
                // Название 2-го столбца
                return "Значение многочлена в double";
            default:
                // Название 4-го столбца
                return "Ограниченная симметрия";
        }
    }
}
