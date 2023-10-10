package impacta.api.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Equipamento {
    @Id
    private int Id;
    private int Numero;
    private int Indice;
    private String Equipamento;
    private String Problema;
    
    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public int getNumero() {
        return this.Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getIndice() {
        return this.Indice;
    }

    public void setIndice(int Indice) {
        this.Indice = Indice;
    }

    public String getEquipamento() {
        return this.Equipamento;
    }

    public void setEquipamento(String Descricao) {
        this.Equipamento = Descricao;
    }

    public String getProblema() {
        return this.Problema;
    }

    public void setProblema(String Problema) {
        this.Problema = Problema;
    }
}