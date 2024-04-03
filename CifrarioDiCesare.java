public class CifrarioDiCesare {

    // stabilisco l'alfabeto da usare
    private static final String alfabeto = "abcdefghijklmnopqrstuvwxyz123456789";

    // metodo per far funzionare il cifrario
    public static String logicaCifrario(String testo, int shift) {

        // Lo StringBuilter costruisce la stringa di output
        StringBuilder risultato = new StringBuilder();

        // ciclo su ogni carattere della stringa "testo" convertita in array di
        // caratteri
        for (char carattere : testo.toCharArray()) {

            // controllo che la posizione del carattere sia trovata
            if (alfabeto.indexOf(carattere) != -1) {
                int posizioneOriginale = alfabeto.indexOf(carattere);
                int nuovaPosizione = (alfabeto.length() + posizioneOriginale + shift) % alfabeto.length();

                // creo il risultato con il carattere corrispondente alla nuova posizione
                // dell'alfabeto
                risultato.append(alfabeto.charAt(nuovaPosizione));
            } else {
                risultato.append(carattere);
            }
        }
        return risultato.toString();

    }

    public static void main(String[] args) {

        // avvio
        if (args.length < 3) {
            System.out.println("Inserisci: <messaggio> <shift> <modalità(1/2)>");
        }

        /*
         * devo chiedere 3 argomenti in input:
         * 1) messaggio
         * 2) il numero di caratteri da spostare(shift)
         * 3) la modalità (1 per crittografare, 2 per decriptare)
         */

        // 1
        String messaggio = args[0].toLowerCase();

        // 2
        int shift = Integer.parseInt(args[1]);

        // 3
        int modalità = Integer.parseInt(args[2]);

        // risultato
        String risultato = "";

        if (modalità == 1) {
            risultato = cripta(messaggio, shift);
        } else if (modalità == 2) {
            risultato = decripta(messaggio, shift);
        } else {
            System.out.println("Modalità non valida. Usa 1 per Crittografia e 0 per decrittografia");
            return;
        }
        System.out.println("Risultato : " + risultato);
    }

    // metodi che criptano e decriptano
    private static String cripta(String testo, int shift) {
        return logicaCifrario(testo, shift);
    }

    private static String decripta(String testo, int shift) {
        return logicaCifrario(testo, -shift);
    }

}