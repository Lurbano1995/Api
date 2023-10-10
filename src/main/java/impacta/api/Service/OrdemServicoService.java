package impacta.api.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import impacta.api.Model.OrdemServico;
import java.util.Map;

@Service
public class OrdemServicoService {
   private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrdemServicoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OrdemServico> encontrarOrdensServicos() {
        String sql = "SELECT * FROM OrdemServico";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        return rows.stream().map(row -> {
            OrdemServico OrdemServico = new OrdemServico();
            OrdemServico.setId((Integer) row.get("id"));
            OrdemServico.setNumero((Integer) row.get("numero"));
            OrdemServico.setDescricao((String) row.get("descricao"));
            return OrdemServico;
        }).collect(Collectors.toList());
    }

    public List<OrdemServico> encontrarOrdemServico(int numero) {
        String sql = "SELECT * FROM OrdemServico WHERE numero = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, numero);

        return rows.stream().map(row -> {
            OrdemServico OrdemServico = new OrdemServico();
            OrdemServico.setId((Integer) row.get("id"));
            OrdemServico.setNumero((Integer) row.get("numero"));
            OrdemServico.setDescricao((String) row.get("descricao"));
            return OrdemServico;
        }).collect(Collectors.toList());
    }

    public String InserirOrdemServico(OrdemServico OrdemServico) {
        String sql = "INSERT INTO OrdemServico (Id, Numero, Descricao) VALUES (?, ?, ?)";

        int linhasAfetadas = jdbcTemplate.update(sql, OrdemServico.getId(), OrdemServico.getNumero(), OrdemServico.getDescricao());

        if (linhasAfetadas == 1) {
            return "Ordem de Servico Gravada com Sucesso!";
        } else {
            return "Erro ao Gravar Ordem de Servico!";
        }
    }
}