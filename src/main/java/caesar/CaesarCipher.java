package caesar;

public class CaesarCipher {
    private static final String ALPHABET = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,«»\"':!? ");

    public String encrypt(String text, int key){
        StringBuilder encrypted = new StringBuilder();

        for(char chr : text.toCharArray()) {
            int index = ALPHABET.indexOf(chr);

            if (index != -1){
                int newIndx = (index + key) % ALPHABET.length();

                if (newIndx < 0){
                    newIndx += ALPHABET.length();
                }
                encrypted.append(ALPHABET.charAt(newIndx));
            }
            else {
                encrypted.append(chr);
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String text, int key){
        StringBuilder decrypted = new StringBuilder();

        for (char chr : text.toCharArray()) {
            int index = ALPHABET.indexOf(chr);

            if (index != -1) {
                int newIndx = (index - key) % ALPHABET.length();
                if (newIndx < 0) {
                    newIndx += ALPHABET.length();
                }
                decrypted.append(ALPHABET.charAt(newIndx));
            } else {
                decrypted.append(chr);
            }
        }

        return decrypted.toString();
    }

    public String bruteForce(String encrypted){
        StringBuilder probablyDecrypt = new StringBuilder();

        for (int key = 0; key < ALPHABET.length(); key++) {
            String decrypted = decrypt(encrypted, key);
            probablyDecrypt.append("Ключ: ").append(key).append(": ").append(decrypted).append("\n");
        }
        return probablyDecrypt.toString();
    }
}
