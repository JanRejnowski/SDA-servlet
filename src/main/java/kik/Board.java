package kik;

/**
 * Created by RENT on 2017-06-20.
 */
public class Board {
    private String[] array;

    private int counter = 0;

    public Board() {
        array = new String[9];
    }

    public boolean addMove (int position, String sign){
        boolean valueToReturn = false;
        if(checkRange(position) && isPositionEmpty(position)) {
            array[position - 1] = sign;
            counter++;
            valueToReturn = true;
        }
        return valueToReturn;
    }

    private boolean checkRange(int position) {
        return (position > 0 && position < 10);
    }

    private boolean isPositionEmpty(int position){
        return array[position - 1] == null;
    }

    public boolean isGameFinished() {
        return  isFulfilled() || checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean isFulfilled() {
        return counter == 9;
    }

    private boolean areValuesEqual(int i, int j, int k) {
        return array[i] != null && array[i].equals(array[j]) && array[i].equals(array[k]);
    }

    private boolean checkRows() {
        boolean flag;
        int i = 0;
        do{
            flag = areValuesEqual(i,i+1, i + 2);
            i += 3;
        } while (i < 9 && !flag);
        return flag;
    }

    private boolean checkColumns() {
        boolean flag;
        int i = 0;
        do {
            flag = areValuesEqual(i, i + 3, i + 6);
            i++;
        } while (i < 3 && !flag);
        return flag;
    }

    private boolean checkDiagonals(){
        return array[4] != null && (areValuesEqual(0,4,8) || areValuesEqual(2,4,6));
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i] == null ? (i + 1) : array[i]);
            stringBuilder.append((i + 1) % 3 == 0 ? "\n" : "|");
        }
        return stringBuilder.toString();
    }

    public int getCounter() {
        return counter;
    }
}
