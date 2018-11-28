package negocio;

import entidade.Funcionario;
import java.sql.SQLException;
import java.util.List;
import persistencia.PFuncionario;

public class NFuncionario {
    
        PFuncionario persistencia;
    
    public NFuncionario() {
        persistencia = new PFuncionario();
    }
       
    public void salvar(Funcionario parametro) throws SQLException, Exception {
        
        if(parametro.getTipo_func().isEmpty())
            throw new Exception("É necessário informar o Cargo.");

        if(parametro.getIdentificador() == 0){
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }
    }

    public void excluir(int parametro) throws SQLException {
        persistencia.excluir(parametro);
    }
    
    public Funcionario consultar(int parametro) throws SQLException{
        return persistencia.consultar(parametro);
    }
    
    public List<Funcionario> listar() throws SQLException {
        return persistencia.listar();
    }

}