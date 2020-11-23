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
        double x = from + step * row;
        Double result = 0.0;
        Double result1 = 0.0;
        switch (col) {
            case 0: {
                return x;
            }
            case 1: {
// Вычисление значения в точке по схеме Горнера.
                for (int i = coefficients.length - 1; i >= 0; i--) {
                    result *= x;
                    result += coefficients[i];
                }
                return result;
            }
            default: {
                for (int i = coefficients.length - 1; i >= 0; i--) {
                    result1 *= x;
                    result1 += coefficients[i];
                }
                //Integer k= (int)result1;
                int k = result1.intValue();
                int bef = k % 10;
                int af = (int) (((result1 - (result1.intValue())) * 10));
                String strk = Integer.toString(bef);
                String strf = Integer.toString(af);
                if (strk.equals(strf))
                    return true;
                else
                    return false;
            }
        }
    }

        @Override
        public Class<?> getColumnClass(int col){
            if (col == 0) return Double.class;
            if (col == 1) return Double.class;
            else return Boolean.class;
        }

        @Override
        public String getColumnName (int col)
        {
            switch (col) {
                case 0:
                    // Название 1-го столбца
                    return "Значение X";
                case 1:
                    // Название 2-го столбца
                    return "Значение многочлена";
                default:
                    // Название 4-го столбца
                    return "Ограниченная симметрия";
            }
        }
    }

