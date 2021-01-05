/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sp0011;
import static sp0011.Convert.ConvertFromBinary;
import static sp0011.Convert.ConvertFromDecimal;
import static sp0011.Convert.ConvertFromHexa;
import static sp0011.Validate.checkInputBinary;
import static sp0011.Validate.checkInputDecimal;
import static sp0011.Validate.checkInputHexaDecimal;
import static sp0011.Validate.checkInputIntLimit;


/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            System.out.println("1. Convert From Binary.");
            System.out.println("2. Convert From Decimal.");
            System.out.println("3. Convert From Hexa.");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sp0011.Validate.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    ConvertFromBinary();
                    break;
                case 2:
                    ConvertFromDecimal();
                    break;
                case 3:
                    ConvertFromHexa();
                    break;
                case 4:
                    return;
            }
        }
    }

}
