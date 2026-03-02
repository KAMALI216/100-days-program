//Hexadecimal → Binary
class Main {

    public static String convertion(String str) {
        char[] ch = str.toCharArray();
        String res = "";

        for (char c : ch) {
            switch (c) {
                case '0': res += "0000"; break;
                case '1': res += "0001"; break;
                case '2': res += "0010"; break;
                case '3': res += "0011"; break;
                case '4': res += "0100"; break;
                case '5': res += "0101"; break;
                case '6': res += "0110"; break;
                case '7': res += "0111"; break;
                case '8': res += "1000"; break;
                case '9': res += "1001"; break;
                case 'A': case 'a': res += "1010"; break;
                case 'B': case 'b': res += "1011"; break;
                case 'C': case 'c': res += "1100"; break;
                case 'D': case 'd': res += "1101"; break;
                case 'E': case 'e': res += "1110"; break;
                case 'F': case 'f': res += "1111"; break;
                default:
                    return "Invalid Hexadecimal Number";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "1ae";
        System.out.println("Binary: " + convertion(str));
    }
}
