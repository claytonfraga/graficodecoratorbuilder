package grafico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public final class CarregaDados {

    private final String delimitador;
    private Map<String, Double> dadosSumarizados = new LinkedHashMap<>();

    public CarregaDados(String caminhoCSVDados, String delimitador, String campoGrupo) throws FileNotFoundException, IOException {
        this.delimitador = delimitador;

        if (!caminhoCSVDados.toLowerCase().endsWith(".csv")) {
            throw new IllegalArgumentException("Informe um arquivo .CSV");
        }

        FileInputStream inputStream = new FileInputStream(caminhoCSVDados);
        Scanner sc = new Scanner(inputStream, "UTF-8");

        String cabecalho = sc.nextLine();

        if (!existeCampo(campoGrupo, cabecalho)) {
            throw new IllegalArgumentException("Campo inexistente neste arquivo!");
        }

        dadosSumarizados.put("Masculino,Solteiro", 0.0);
        dadosSumarizados.put("Masculino,Casado", 0.0);
        dadosSumarizados.put("Feminino,Solteiro", 0.0);
        dadosSumarizados.put("Feminino,Casado", 0.0);
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();

            if (linha.toLowerCase().contains("masculino") && linha.toLowerCase().contains("solteir")) {
                dadosSumarizados.put("Masculino,Solteiro", dadosSumarizados.get("Masculino,Solteiro") + 1);
            } else if (linha.toLowerCase().contains("masculino") && linha.toLowerCase().contains("casad")) {
                dadosSumarizados.put("Masculino,Casado", dadosSumarizados.get("Masculino,Casado") + 1);
            } else if (linha.toLowerCase().contains("feminino") && linha.toLowerCase().contains("solteir")) {
                dadosSumarizados.put("Feminino,Solteiro", dadosSumarizados.get("Feminino,Solteiro") + 1);
            } else if (linha.toLowerCase().contains("feminino") && linha.toLowerCase().contains("casad")) {
                dadosSumarizados.put("Feminino,Casado", dadosSumarizados.get("Feminino,Casado") + 1);
            }
        }
    }

    private boolean existeCampo(String campo, String cabecalho) {
        String[] camposCabecalho = cabecalho.split(delimitador);
        for (String campoCabelhado : camposCabecalho) {
            if (campo.toLowerCase().equals(campoCabelhado)) {
                return true;
            }
        }
        return false;
    }

    public Map<String, Double> getDadosSumarizados() {
        return dadosSumarizados;
    }

}
