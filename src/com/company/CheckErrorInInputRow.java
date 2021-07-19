package com.company;

class CheckError {
    public String rowForChecking;
    public int error;
    public String errorText;
    public String operatinoTip;
    public String varA;
    public String varB;
    public String numAflag;
    public String numBflag;
    public String calcDirectoin;
    public int arabianA;
    public int arabianB;


    public void CheckStringLen() {
        this.error = 0;
        this.errorText = "Ошибок нет";
        if (rowForChecking == null || rowForChecking == "") {
            this.error = 1;
            this.errorText = "Ошибка строка ввода пуста";
        } else if (rowForChecking.length() < 3) {
            this.error = 1;
            this.errorText = "Ошибка строка ввода не может быть короче 3х символов";
        } else if (rowForChecking.length() > 9) {
            this.error = 1;
            this.errorText = "Ошибка строка ввода не может быть более 7ми символов";
        }


    }

    public void CheckOperationType() {
        this.error = 0;
        this.errorText = "Ошибок нет";
        int plus = rowForChecking.indexOf('+');
        int minus = rowForChecking.indexOf('-');
        int umozhit = rowForChecking.indexOf('*');
        int delit = rowForChecking.indexOf('/');
        //конвертируем строку в маасив символов, для проверки на 2 и более одтинаковых знака, если знак найден.
        char[] rowDataCharArray = rowForChecking.toCharArray();
        String type;

        if (plus == -1) {
            error = error + 0;
        } else {
            error = error + 1;
            this.operatinoTip = "+";
        }
        if (minus == -1) {
            error = error + 0;
        } else {
            error = error + 1;
            this.operatinoTip = "-";
        }
        if (umozhit == -1) {
            error = error + 0;
        } else {
            error = error + 1;
            this.operatinoTip = "*";
        }
        if (delit == -1) {
            error = error + 0;
        } else {
            error = error + 1;
            this.operatinoTip = "/";
        }
// проверяем сколько знаков операций найдено если 0 - ошибка, если более 1 ошибка
        if (error == 0) {
            this.error = 1;
            this.errorText = "Ошибка строка не содержит знаков операций +-*/";
        } else if (error > 1) {
            this.error = 1;
            this.errorText = "Ошибка строка содержит более 1 знака операций +-*/";
        } else if (error == 1) {
            //Пока все ок нашли уникальный тип операции, например сложение,
            // и теперб проверяем на наличе дубля, тоесть еще одного + в строке или иного знака
            // будем сравнивать индекс первого вхождения по знаку и последнего вхождения,
            // если они равны, значит это знак операции не дублируется
            if (rowForChecking.indexOf(this.operatinoTip) == rowForChecking.lastIndexOf(this.operatinoTip)) {
                this.error = 0;
                this.errorText = "Ошибок нет";
            } else {
                this.error = 1;
                this.errorText = "Ошибка знак операции встречается 2 или более раз";
            }
        }

    }


    public int getErrorCode() {
        return error;
    }

    public String getErrorText() {
        return errorText;
    }

    public String getOperatinoTip() {
        return operatinoTip;
    }

    public void checkErrorInVariable() {
        this.error = 0;
        try {
            Integer.parseInt(varA);
            this.numAflag = "digit";
        } catch (NumberFormatException e) {
            this.numAflag = "text";
        }
        try {
            Integer.parseInt(varB);
            this.numBflag = "digit";
        } catch (NumberFormatException e) {
            this.numBflag = "text";
        }


        if (numAflag==numBflag&&numAflag=="digit") {
            this.calcDirectoin = "arabianDigit";

        } else if (numAflag==numBflag&&numAflag=="text") {
            this.calcDirectoin = "rimlianDigit";

        } else {
            this.error = 1;
            this.errorText="Ошибка одна или обе переменных указаны в разных или не корректных форматах\nможно использовать только арабские или римские цифры \nзначение переменной не более 10";
        }
    }

    public String getCalcDirectoin() {

        return calcDirectoin;
    }
    public void checkErrorArabianDigit() {
        int a=Integer.parseInt(varA);
        int b=Integer.parseInt(varB);
        this.arabianA=a;
        this.arabianB=b;
        this.error = 0;
        this.errorText="Можно отдавать на расчет";
        if (a>10) {
            this.error = 1;
            this.errorText="Ошибка переменная A больше 10, обе переменные должны быть менее 10";

        }
        if (b>10) {
            this.error = 1;
            this.errorText="Ошибка переменная Б больше 10, обе переменные должны быть менее 10";
        }
        if (b==0) {
            this.error = 1;
            this.errorText="Ошибка деление на ноль не возможно";
        }

    }

}
