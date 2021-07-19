package com.company;

public class RowParsing {
    public String variableA;
    public String variableB;
    public String row;
    public String rowToSplit;
    public String delimetr;


    public void getVarFromArray() {
        this.rowToSplit = row.replace(delimetr, " ");
        String[] varArr = rowToSplit.split(" ");
        this.variableA = varArr[0];
        if (varArr.length > 1) {
            this.variableB = varArr[1];
        }
    }


    public String getVariableA() {
        return variableA;
    }

    public String getVariableB() {
        return variableB;
    }


}
