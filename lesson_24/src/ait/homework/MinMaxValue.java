package ait.homework;

public class MinMaxValue {
    public static void main(String[] args) {
        if (args.length == 0) {
            printMinMaxValues("byte", "short", "char", "int", "long", "float", "double");
        } else {
            for (String arg : args) {
                switch (arg) {
                    case "byte":
                        System.out.println("Min byte: " + Byte.MIN_VALUE);
                        System.out.println("Max byte: " + Byte.MAX_VALUE);
                        break;
                    case "short":
                        System.out.println("Min short: " + Short.MIN_VALUE);
                        System.out.println("Max short: " + Short.MAX_VALUE);
                        break;
                    case "char":
                        System.out.println("Min char: " + (int) Character.MIN_VALUE);
                        System.out.println("Max char: " + (int) Character.MAX_VALUE);
                        break;
                    case "int":
                        System.out.println("Min int: " + Integer.MIN_VALUE);
                        System.out.println("Max int: " + Integer.MAX_VALUE);
                        break;
                    case "long":
                        System.out.println("Min long: " + Long.MIN_VALUE);
                        System.out.println("Max long: " + Long.MAX_VALUE);
                        break;
                    case "float":
                        System.out.println("Min float: " + Float.MIN_VALUE);
                        System.out.println("Max float: " + Float.MAX_VALUE);
                        break;
                    case "double":
                        System.out.println("Min double: " + Double.MIN_VALUE);
                        System.out.println("Max double: " + Double.MAX_VALUE);
                        break;
                    default:
                        System.out.println("Wrong type: " + arg);
                        break;
                }
            }
        }
    }

    private static void printMinMaxValues(String aByte, String aShort, String aChar, String anInt, String aLong, String aFloat, String aDouble) {
    }
}

