package com.company;
class Calculator {
    public int result;
    public int calc (String operationType,int a,int b) {
        if (operationType == "+") {
            this.result=a + b;
        } else if (operationType == "-") {
            this.result=a - b;
        } else if (operationType == "*") {
            this.result=a * b;
        } else if (operationType == "/") {
            this.result=a / b;
        }
        return result;
    };

}
