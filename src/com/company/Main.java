package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Input:");
            Scanner inputString = new Scanner(System.in);
            String inputRowText = inputString.nextLine();
            /*
            Калькулятор должен принимать на вход числа от 1 до 10 включительно, значит
            Первое и второе арабское число не должно быть более 2х знаков, Римские более 4х знаков (VIII)
            + знак операции еще 1 знак. Общая длина строки должна быть не менее 3х и не более 4+4+1=9 знаков.
            Проверяем первое условие CheckStringLen();
            */
            CheckError row = new CheckError();
            row.rowForChecking = inputRowText;
            row.CheckStringLen();
            int error = row.getErrorCode();
            if (error > 0) {
                String errorMessage = row.getErrorText();
                throw new Exception(errorMessage);
            }
            /*
            Нужно убедиться, что строка содержить знак математической операции, для этого
            будем искать в строке один из знаков + - / *, если не найдем то выбросим исключением с текстом ошибки
             */
            row.CheckOperationType();
            int error1 = row.getErrorCode();
            if (error1 > 0) {
                String errorMessage = row.getErrorText();
                throw new Exception(errorMessage);
            }
            /*
            Тип операции найден, теперь будем делить строку на 2 переменных https://metanit.com/java/tutorial/7.2.php
            метод SPLIT, в качестве делителя будет знак операции
            далее останется проверить каждую переменную на условия:
            - римские или арабские - все римские или арабские (удалим знак и проверим конверируется ли в число, если да
            то пойдем по римскоей ветке, если нет, то каждую переменную проверяем на корректность арабским символам тоесть
            должна быть равна I||II||III|IV||V|VI|VII|VIII||IX||X) - будем сравнивать в верхнем регистре
                -   если римские то конвертировать в арабские
            - каждая переменна не пустая и не null
            - каждая переменная = не более 10
             */
            String stringA;//переменная 1
            String stringB;//переменная 1
            String operationType = row.getOperatinoTip();
            //System.out.println("Операция для выполнения: "+operationType);
            RowParsing rowP = new RowParsing();
            rowP.delimetr = operationType;
            rowP.row = inputRowText;
            rowP.getVarFromArray();
            stringA = rowP.getVariableA();
            stringB = rowP.getVariableB();
            //System.out.println("Переменная А=" + stringA + " Переменная В=" + stringB);
            // получили переменные из строки, отправляем на проверку пусто?*2 число?*2 текст?*2
            row.varA = stringA;
            row.varB = stringB;
            row.checkErrorInVariable();
            int error2 = row.getErrorCode();
            if (error2 > 0) {
                String errorMessage = row.getErrorText();
                throw new Exception(errorMessage);
            }
            // определились что имеем чифры или текст и что формат переменных одинаковый,
            // запускаем проверку ошибок в соответсвие с направлениями для расчетов;
            String calcDirection = row.calcDirectoin;
            //проверяем условия для арабских чисел

            if (calcDirection == "arabianDigit") {
                row.checkErrorArabianDigit();
                int error3 = row.getErrorCode();
                if (error3 > 0) {
                    String errorMessage = row.getErrorText();
                    throw new Exception(errorMessage);
                }
                Calculator calc = new Calculator();
                int calcResult = calc.calc(operationType,row.arabianA,row.arabianB);
                System.out.println("Output\n" + calcResult);
                return;




            } else if (calcDirection == "rimlianDigit") {
                //Попробуем найти римское число от 1 до 10 в переменных, если нет - ошибка
                // будем применять IF ELSE, если все римские отдадим их в класс Calculator,
                // ответ обработаем конвертером с применением нум или ELSE IF или SWITCH CASE
                RimlianDigitCheckerAndConvert rcheck = new RimlianDigitCheckerAndConvert();
                rcheck.arabianDigitA=rcheck.rimlianDigitToArabianAndCheck(stringA);
                rcheck.arabianDigitB=rcheck.rimlianDigitToArabianAndCheck(stringB);
                if (rcheck.arabianDigitA==0) {
                    throw new Exception("Ошибка переменная А не является арабским числом до 10");
                }
                if (rcheck.arabianDigitB==0) {
                    throw new Exception("Ошибка переменная Б не является арабским числом до 10");
                }
                Calculator calc = new Calculator();
                int calcResult = calc.calc(operationType,rcheck.arabianDigitA,rcheck.arabianDigitB);
                //System.out.println("Output\n" + calcResult);
                String rimlianResult=rcheck.arabianDigitToRimlian(calcResult);
                System.out.println("Output\n" +rimlianResult);




            }


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }


    }

}
