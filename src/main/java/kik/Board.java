package kik;

import java.util.Iterator;

/**
 * Created by RENT on 2017-06-20.
 */
public class Board {
    private String[] array;

    public Board() {
        array = new String[9];
    }

    public boolean addMove (int position, String sign){
        boolean valueToReturn = false;
        if(checkRange(position) && isPositionEmpty(position)) {
            array[position - 1] = sign;
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

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i] == null ? (i + 1) : array[i]);
            stringBuilder.append((i + 1) % 3 == 0 ? "\n" : "|");
        }
        return stringBuilder.toString();
    }

    private boolean checkIsEmpty (Board board) {
        for (int i = 0; i < board.array.length; i++) {
            if(board.array[i] == null) {
                return true;
            }
        }
        return false;
    }

    private boolean isGameFinished() {

    }

    private boolean isFulfilled() {

    }

    private boolean areValuesEqual(int i, int j, int k) {
        return array[i] != null && array[i].equals(array[j]) && array[i].equals(array[k]);
    }

    private boolean checkRows() {
        boolean sum = false;
        for (int i = 0; i < 3; i++) {
            sum = sum || ;
        }
    }

    private boolean checkColumns() {

    }

    private boolean checkDiagonals(){

    }


}
