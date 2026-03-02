//Binary → Hex

class Main {

    public static String binaryToHex(String binary) {
        // Make length multiple of 4 by adding leading zeros
        int len = binary.length();
        int rem = len % 4;

        if (rem != 0) {
            int padding = 4 - rem;
            for (int i = 0; i < padding; i++) {
                binary = "0" + binary;
            }
        }

        String hex = "";

        for (int i = 0; i < binary.length(); i += 4) {
            String group = binary.substring(i, i + 4);

            switch (group) {
                case "0000": hex += "0"; break;
                case "0001": hex += "1"; break;
                case "0010": hex += "2"; break;
                case "0011": hex += "3"; break;
                case "0100": hex += "4"; break;
                case "0101": hex += "5"; break;
                case "0110": hex += "6"; break;
                case "0111": hex += "7"; break;
                case "1000": hex += "8"; break;
                case "1001": hex += "9"; break;
                case "1010": hex += "A"; break;
                case "1011": hex += "B"; break;
                case "1100": hex += "C"; break;
                case "1101": hex += "D"; break;
                case "1110": hex += "E"; break;
                case "1111": hex += "F"; break;
                default:
                    return "Invalid Binary";
            }
        }

        return hex;
    }

    public static void main(String[] args) {
        String binary = "10101110";
        System.out.println("Hexadecimal: " + binaryToHex(binary));
    }
}
