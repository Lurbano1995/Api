package impacta.api.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrdemServico {
    @Id
    private int Id;
    private int Numero;
    private String Descricao;

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

    public String getDescricao() {
        return this.Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
}
