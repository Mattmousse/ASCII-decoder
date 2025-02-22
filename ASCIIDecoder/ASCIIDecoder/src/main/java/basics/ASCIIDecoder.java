package basics;
import java.util.ArrayList;
import java.util.Arrays;


public class ASCIIDecoder {

    /*
     * The 2D array "sentences" contain a set of decimal ASCII code we want you
     * to translate. Each sub-element of this array is a different sentence.
     * Ex : if we pass this array : [ ["72", "101", "108", "108", "111"], ["87", "111", "114", "108", "100"]]
     * to your decode method, you should return : [ "Hello", "World" ].
     * 
     * Forbidden characters are passed as an array of int.
     * Each element of this array correspond to the decimal ASCII code
     * of a forbidden character OR null if there's no forbidden character
     * If you encounter one of these forbidden character
     * you must ignore it when you translate your sentence.
     *
     * Use the StringBuilder class and its method appendCodePoint(int) to translate the ASCII code.
     *
     * You should NEVER return null or an array containing null.
     */
    public static String [] decode(int[] forbidden, String[][] sentences){
        String[] res = new String[sentences.length];
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < sentences[i].length; j++) {
                int asciiCode = Integer.parseInt(sentences[i][j]);
                // Check if the ASCII code is forbidden
                boolean isForbidden = false;
                if(forbidden != null){
                    for (int forbiddenCode : forbidden) {
                        if (asciiCode == forbiddenCode) {
                            isForbidden = true;
                            break;
                        }
                    }
                    // Append to the word if it's not forbidden
                    if (!isForbidden) {
                        word.appendCodePoint(asciiCode);
                    }
                }
                else {
                    word.appendCodePoint(asciiCode);
                }
            }
            System.out.println(word.toString());
            word.append(" ");
            res[i] = word.toString();
            word = new StringBuilder();
        }
        for (int i = 0 ; i< res.length ; i++){
            res[i] = res[i].substring(0,res[i].length()-1);
            System.out.println(res[i]);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

}