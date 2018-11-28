package persistencia;

import entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PUsuario {
    
        public void incluir(Usuario parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO"
                + " usuario (login, senha) "
                + " VALUES (?,?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getCliente().getPessoa().getCPF());
        prd.setString(2, parametro.getSenha());
        prd.execute();
        cnn.close();
    }

    public void alterar(Usuario parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "UPDATE usuario SET"
                + " login = ?, "
                + " senha = ? "
                + " WHERE identificador = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getCliente().getPessoa().getCPF());
        prd.setString(2, parametro.getSenha());
        prd.setInt(2, parametro.getIdentificador());
        
        prd.execute();
        cnn.close();
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM usuario "
                + " WHERE identificador = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setInt(1, parametro);
        
        prd.execute();
        cnn.close();
    }

    public Usuario consultar(int parametro) throws SQLException {
        
        String sql = "SELECT identificador, login, senha"
                + " FROM usuario WHERE identificador = ?";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);
        
        ResultSet rs = prd.executeQuery();
        
        Usuario retorno = new Usuario();
        
        if(rs.next()){
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.getCliente().getPessoa().setCPF(rs.getString("login"));
            retorno.setSenha(rs.getString("senha"));
        }
        
        return retorno;
    }
    public List<Usuario> listar() throws SQLException {

        String sql = "SELECT * FROM usuario";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        List<Usuario> retorno = new ArrayList<Usuario>();

        while(rs.next()) {
            
                Usuario tipo = new Usuario();
            
                
                tipo.setIdentificador(rs.getInt("identificador"));
                tipo.getCliente().getPessoa().setCPF(rs.getString("login"));
                tipo.setSenha(rs.getString("senha"));
                retorno.add(tipo);
    }
        return retorno;

    }
}