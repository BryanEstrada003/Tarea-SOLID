/**
 * classe que reponsavel pela apresentação
 */

import java.util.List;

public class AOutros  extends Apresentacao implements IApresentacaoOutros {
   
    
    /**
     * Apresenta mensagem e arr
     * @param message mensagem
     * @param arr     List de string
     */
    public void printArray(String message, List<String> arr) {
        out.printArray(message, arr);
    }

    /**
     * Apresenta tabela com a mensagem e o arr
     * @param message mensagem
     * @param arr     list de string
     */
    public void printTable(String message, List<String> arr) {
        out.printTable(message, arr);
    }

    /**
     * Apresenta mensagem
     * @param message mensagem
     */
    public void printMessage(String message) {
        out.printMessage(message);
    }

    public String pedirPrimeiraData() {
        return "Introduza a 1º data de tipo(02-12-2018)";
    }

    public String pedirSegundaData() {
        return "Introduza a 2º data de tipo(02-12-2018)";
    }
}
