package com.company;

public class RimlianDigitCheckerAndConvert {
    int arabianDigitA;
    int arabianDigitB;
    int rimlianDigitConverted;

    public int rimlianDigitToArabianAndCheck(String rDigit) {
        rDigit = rDigit.toUpperCase();
        switch (rDigit) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return 0;
        }
    }

    public String arabianDigitToRimlian(int aDigit) {
        int edinici = aDigit % 10;
        int desastki = (aDigit / 10) % 10;
        if (aDigit == 10) {
            edinici = 10;
            desastki = 0;
        }

        if (aDigit == 100) {
            desastki = 10;
        }
        String rim1;
        String rim2;

        switch (edinici) {
            case 1:
                rim1 = "I";
                break;
            case 2:
                rim1 = "II";
                break;
            case 3:
                rim1 = "III";
                break;
            case 4:
                rim1 = "IV";
                break;
            case 5:
                rim1 = "V";
                break;
            case 6:
                rim1 = "VI";
                break;
            case 7:
                rim1 = "VII";
                break;
            case 8:
                rim1 = "VIII";
                break;
            case 9:
                rim1 = "IX";
                break;
            case 10:
                rim1 = "X";
                break;
            default:
                rim1 = "";
                break;
        }
        switch (desastki) {
            case 1:
                rim2 = "X";
                break;
            case 2:
                rim2 = "XX";
                break;
            case 3:
                rim2 = "XXX";
                break;
            case 4:
                rim2 = "XL";
                break;
            case 5:
                rim2 = "L";
                break;
            case 6:
                rim2 = "LX";
                break;
            case 7:
                rim2 = "LXX";
                break;
            case 8:
                rim2 = "LXXX";
                break;
            case 9:
                rim2 = "XC";
                break;
            case 10:
                rim2 = "C";
                break;
            default:
                rim2 = "";
                break;
        }
        return rim2+rim1;
    }
}
