package negocio;

import entidade.Cliente;
import java.sql.SQLException;
import java.util.List;
import persistencia.PCliente;

public class NCliente {
    
        PCliente persistencia;
    
    public NCliente() {
        persistencia = new PCliente();
    }
       
    public void salvar(Cliente parametro) throws SQLException, Exception {
        
        if(parametro.getNum_conta().isEmpty())
            throw new Exception("É necessário informar o Número da Conta.");

        if(parametro.getTipo_conta().isEmpty())
            throw new Exception("É necessário informar Tipo da Conta.");
                       
//        if(parametro.getSaldo() == 0 )
//            throw new Exception("Uma conta não pode ser aberta com Saldo 0.");




        if(parametro.getIdentificador() == 0){
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }
    }

    public void excluir(int parametro) throws SQLException {
        persistencia.excluir(parametro);
    }
    
    public Cliente consultar(int parametro) throws SQLException{
        return persistencia.consultar(parametro);
    }
    
    public List<Cliente> listar() throws SQLException {
        return persistencia.listar();
    }

}