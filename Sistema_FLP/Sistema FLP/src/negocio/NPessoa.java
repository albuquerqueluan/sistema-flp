package negocio;

import entidade.Pessoa;
import java.sql.SQLException;
import java.util.List;
import persistencia.PPessoa;
import util.ValidaCPF;

public class NPessoa extends ValidaCPF {
    
        PPessoa persistencia;
    
    public NPessoa() {
        persistencia = new PPessoa();
    }
       
    public void salvar(Pessoa parametro) throws SQLException, Exception {
        
        if(parametro.getCPF().isEmpty())
            throw new Exception("É necessário informar o CPF.");
        
        if(ValidaCPF.isCPF(parametro.getCPF()) == true)
        {}else{ throw new Exception ("CPF inválido.");}
                
        if(parametro.getNome().isEmpty())
            throw new Exception("É necessário informar o Nome.");
                       
        if(parametro.getTelefone().isEmpty() )
            throw new Exception("É necessário informar o Telefone.");
         
        if(parametro.getEndereco().isEmpty() )
            throw new Exception("É necessário informar o Endereço.");

        if(parametro.getEmail().isEmpty() )
            throw new Exception("É necessário informar o E-mail.");



        if(parametro.getIdentificador() == 0){
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }
    }

    public void excluir(int parametro) throws SQLException {
        persistencia.excluir(parametro);
    }
    
    public Pessoa consultar(int parametro) throws SQLException{
        return persistencia.consultar(parametro);
    }
    
    public List<Pessoa> listar() throws SQLException {
        return persistencia.listar();
    }

}
