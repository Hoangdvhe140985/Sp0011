package sp0011;

import java.math.BigInteger;
import static sp0011.Validate.checkInputBinary;
import static sp0011.Validate.checkInputDecimal;
import static sp0011.Validate.checkInputHexaDecimal;
import static sp0011.Validate.checkInputIntLimit;

/**
 *
 * @author THAYCACAC
 */
public class Convert {

    //allow user convert from binary to decimal
    public static String convertBinaryToDecimal(String binary) {
        BigInteger decimalValue = BigInteger.ZERO;
        // Initializing base value to 1, i.e 2^0
        BigInteger base = BigInteger.ONE;

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimalValue = decimalValue.add(base);
            }
            base = base.multiply(new BigInteger("2"));
        }
        String result = String.valueOf(decimalValue);
        return result;

    }

    //allow user convert from binary to decimal
    public static String convertBinaryToHexa(String binary) {
        String decimal = convertBinaryToDecimal(binary);
        String hexa = convertDecimalToHexa(decimal);
        return hexa;
    }

    //allow user convert from binary to decimal
    public static String convertDecimalToBinary(String deci) {
        BigInteger decimal = new BigInteger(deci);
        BigInteger rem;
        String result = "";
        if (deci.equals("0")) {
            return "0";
        } else {
            while (!decimal.equals(BigInteger.ZERO)) {
                rem = decimal.mod(new BigInteger("2"));
                decimal = decimal.divide(new BigInteger("2"));
                result = rem + result;
            }
        }
        return result;

    }

    //allow user convert from decimal to hexa
    public static String convertDecimalToHexa(String deci) {
        BigInteger decimal = new BigInteger(deci);
        if (decimal.equals(BigInteger.ZERO)) {
            return "0";
        }
        String hexa = "";
        BigInteger digit;
        while (!decimal.equals(BigInteger.ZERO)) {
            String h = "";
            digit = decimal.mod(new BigInteger("16"));
            if (digit.equals(new BigInteger("10"))) {
                h = "A";
            } else if (digit.equals(new BigInteger("11"))) {
                h = "B";
            } else if (digit.equals(new BigInteger("12"))) {
                h = "C";
            } else if (digit.equals(new BigInteger("13"))) {
                h = "D";
            } else if (digit.equals(new BigInteger("14"))) {
                h = "E";
            } else if (digit.equals(new BigInteger("15"))) {
                h = "F";
            } else {
                h = digit + h;
            }
            hexa = h + hexa;
            decimal = decimal.divide(new BigInteger("16"));
        }
        return hexa;
    }

    //allow user convert from hexa to decimal
    public static String convertHexaToDecimal(String hexa) {
        BigInteger base = BigInteger.ONE;
        //  String result = "";
        BigInteger dec_val = BigInteger.ZERO;
        BigInteger val = BigInteger.ZERO;
        // loop từ 0 - độ dài của chuỗi trừ 1
        if (hexa.equals(0)) {
            return "0";
        } else {
            for (int i = 0; i < hexa.length(); i++) {
                //chính xuất các kí tự từ phải qua trái
                char c = hexa.charAt(hexa.length() - i - 1);
                if (c == 'A') {
                    val = new BigInteger("10");
                }
                if (c == 'B') {
                    val = new BigInteger("11");
                }
                if (c == 'C') {
                    val = new BigInteger("12");
                }
                if (c == 'D') {
                    val = new BigInteger("13");
                }
                if (c == 'E') {
                    val = new BigInteger("14");
                }
                if (c == 'F') {
                    val = new BigInteger("15");
                }
                if (c == '1') {
                    val = new BigInteger("1");
                }
                if (c == '2') {
                    val = new BigInteger("2");
                }
                if (c == '3') {
                    val = new BigInteger("3");
                }
                if (c == '4') {
                    val = new BigInteger("4");
                }
                if (c == '5') {
                    val = new BigInteger("5");
                }
                if (c == '6') {
                    val = new BigInteger("6");
                }
                if (c == '7') {
                    val = new BigInteger("7");
                }
                if (c == '8') {
                    val = new BigInteger("8");
                } else if (c == '9') {
                    val = new BigInteger("9");
                }
                val = val.multiply(base);
                dec_val = dec_val.add(val);
                //  incrementing base by power( tăng dân cơ số theo lũy thừa)
                base = base.multiply(new BigInteger("16"));
            }
            String result = String.valueOf(dec_val);
            return result;
        }
    }

    //allow user convert from binary to decimal
    public static String convertHexaToBinary(String hexaDecimal) {
        String decimal = convertHexaToDecimal(hexaDecimal);
        String binary = convertDecimalToBinary(decimal);
        return binary;
    }

    public static int ConvertFromBinary() {
        System.out.println("1. Convert form Binary to Decimal");
        System.out.println("2. Convert form Binary to Hexa");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 2);
        String binary = checkInputBinary();
        switch (choice) {
            case 1:
                System.out.println("Decimal: "
                        + convertBinaryToDecimal(binary));
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + convertBinaryToHexa(binary));
                break;
        }
        return choice;

    }

    public static int ConvertFromDecimal() {
        System.out.println("1. Convert form Decimal to Binary");
        System.out.println("2. Convert form Decimal to Hexa");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 2);
        String decimal = checkInputDecimal();
        switch (choice) {
            case 1:
                System.out.println("Binary: " + convertDecimalToBinary(decimal));
                break;
            case 2:
                System.out.println("Hexadecimal: " + convertDecimalToHexa(decimal));
                break;
        }
        return choice;
    }

    public static int ConvertFromHexa() {

        System.out.println("1. Convert form Hexa to Binary");
        System.out.println("2. Convert form Hexa to Decimal");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 2);
        String hexa = checkInputHexaDecimal();
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + convertHexaToBinary(hexa)
                );
                break;
            case 2:
                System.out.println("Decimal: "
                        + convertHexaToDecimal(hexa));
                break;
        }
        return choice;
    }

}
