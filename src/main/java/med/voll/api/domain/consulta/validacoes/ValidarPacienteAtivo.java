package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());

        if(!pacienteEstaAtivo){
            throw new ValidacaoException("Consulta nao pode ser agendada com paciente excluido");
        }

    }
}
