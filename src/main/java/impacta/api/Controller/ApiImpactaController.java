package impacta.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import impacta.api.Service.EquipamentoService;
import impacta.api.Service.OrdemServicoService;
import impacta.api.Model.Equipamento;
import impacta.api.Model.OrdemServico;


@RequestMapping("/api/v1")

@RestController
public class ApiImpactaController 
{    
    @Autowired
    private EquipamentoService EquipamentoService;

    @Autowired
    private OrdemServicoService OrdemServicoService;

    @GetMapping("/os/equipamento")
    public List<Equipamento> Pesquisa(@RequestParam("descricao") String descricao) {
        return EquipamentoService.encontrarEquipamentoComDescricao(descricao);
    }

    @GetMapping("/os")
    public List<OrdemServico> Pesquisa() {
        return OrdemServicoService.encontrarOrdensServicos();
    }

    @GetMapping("/os/{numero}")
    public List<OrdemServico> Pesquisa(@PathVariable Integer numero) {
        return OrdemServicoService.encontrarOrdemServico(numero);
    }

    @GetMapping("/os/{numero}/equipamento")
    public List<Equipamento> Pesquisa2(@PathVariable Integer numero) {
        return EquipamentoService.encontrarEquipamentoComOrdemServico(numero);
    }

    @GetMapping("/os/{numero}/equipamento/{indice}")
    public List<Equipamento> Pesquisa2(@PathVariable Integer numero,@PathVariable Integer indice) {
        return EquipamentoService.encontrarEquipamento(numero,indice);
    }

    @PostMapping("/os")
    public String Inserir(@RequestBody OrdemServico OrdemServico) {
       return OrdemServicoService.InserirOrdemServico(OrdemServico);
    }

    @PostMapping("/os/{numero}/equipamento")
    public String Inserir(@PathVariable Integer numero,@RequestBody Equipamento Equipamento) {
       return EquipamentoService.InserirEquipamento(Equipamento);
    }
}