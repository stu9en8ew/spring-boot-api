package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        if(dados.idMedico() == null) {
            return;
        }

        var medicoEstadoAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoEstadoAtivo){
            throw new ValidacaoException("Consulta nao pode ser agendada com o medico");
        }
    }
}
