package negocio;

import entidade.Usuario;
import java.sql.SQLException;
import java.util.List;
import persistencia.PUsuario;

public class NUsuario {
    
        PUsuario persistencia;
    
    public NUsuario() {
        persistencia = new PUsuario();
    }
       
    public void salvar(Usuario parametro) throws SQLException, Exception {
        
        if(parametro.getLogin().isEmpty())
            throw new Exception("É necessário informar o login.");
        
        if(parametro.getSenha().isEmpty())
            throw new Exception("É necessário informar a senha.");
    
        if(parametro.getIdentificador() == 0){
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }
    }

    public void excluir(int parametro) throws SQLException {
        persistencia.excluir(parametro);
    }
    
    public Usuario consultar(int parametro) throws SQLException{
        return persistencia.consultar(parametro);
    }
    
    public List<Usuario> listar() throws SQLException {
        return persistencia.listar();
    }

}