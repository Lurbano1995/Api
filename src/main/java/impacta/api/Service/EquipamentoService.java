package impacta.api.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import impacta.api.Model.Equipamento;

import java.util.Map;


@Service
public class EquipamentoService {
   private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EquipamentoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Equipamento> encontrarEquipamentoComDescricao(String descricao) {
        String sql = "SELECT * FROM Equipamento WHERE lower(equipamento) = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, descricao);

        return rows.stream().map(row -> {
            Equipamento Equipamento = new Equipamento();
            Equipamento.setId((Integer) row.get("id"));
            Equipamento.setNumero((Integer) row.get("numero"));
            Equipamento.setIndice((Integer) row.get("indice"));
            Equipamento.setEquipamento((String) row.get("equipamento"));
            Equipamento.setProblema((String) row.get("problema"));
            return Equipamento;
        }).collect(Collectors.toList());
    }

    public List<Equipamento> encontrarEquipamentoComOrdemServico(Integer numero) {
        String sql = "SELECT e.* FROM equipamento e INNER JOIN OrdemServico o on e.numero = o.numero WHERE o.numero = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, numero);

        return rows.stream().map(row -> {
            Equipamento Equipamento = new Equipamento();
            Equipamento.setId((Integer) row.get("id"));
            Equipamento.setNumero((Integer) row.get("numero"));
            Equipamento.setIndice((Integer) row.get("indice"));
            Equipamento.setEquipamento((String) row.get("equipamento"));
            Equipamento.setProblema((String) row.get("problema"));
            return Equipamento;
        }).collect(Collectors.toList());
    }

    public List<Equipamento> encontrarEquipamento(Integer numero, Integer indice) {
        String sql = "SELECT e.* FROM equipamento e INNER JOIN OrdemServico o on e.numero = o.numero WHERE o.numero = ? and e.indice = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, numero, indice);

        return rows.stream().map(row -> {
            Equipamento Equipamento = new Equipamento();
            Equipamento.setId((Integer) row.get("id"));
            Equipamento.setNumero((Integer) row.get("numero"));
            Equipamento.setIndice((Integer) row.get("indice"));
            Equipamento.setEquipamento((String) row.get("equipamento"));
            Equipamento.setProblema((String) row.get("problema"));
            return Equipamento;
        }).collect(Collectors.toList());
    }

    public String InserirEquipamento(Equipamento Equipamento) {
        String sql = "INSERT INTO Equipamento (Id, Numero, Indice, Equipamento, Problema) VALUES (?, ?, ?, ?, ?)";

        int linhasAfetadas = jdbcTemplate.update(sql, Equipamento.getId(), 
                                                      Equipamento.getNumero(), 
                                                      Equipamento.getIndice(),
                                                      Equipamento.getEquipamento(),
                                                      Equipamento.getProblema());

        if (linhasAfetadas == 1) {
            return "Equipamento Gravado com Sucesso!";
        } else {
            return "Erro ao Gravar Equipamento!";
        }
    }
}