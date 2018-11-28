package persistencia;

import entidade.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PPessoa {
    
        public void incluir(Pessoa parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO"
                + " pessoa (cpf, nome) "
                + " VALUES (?,?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getCPF());
        prd.setString(2, parametro.getNome());
        prd.execute();
        cnn.close();
    }

    public void alterar(Pessoa parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "UPDATE pessoa SET"
                + " cpf = ?, "
                + " nome = ? "
                + " WHERE identificador = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getCPF());
        prd.setString(2, parametro.getNome());
        prd.setInt(3, parametro.getIdentificador());
        
        prd.execute();
        cnn.close();
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM pessoa "
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

    public Pessoa consultar(int parametro) throws SQLException {
        
        String sql = "SELECT identificador, cpf, nome"
                + " FROM pessoa WHERE identificador = ?";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);
        
        ResultSet rs = prd.executeQuery();
        
        Pessoa retorno = new Pessoa();
        
        if(rs.next()){
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.setCPF(rs.getString("cpf"));
            retorno.setNome(rs.getString("nome"));
        }
        
        return retorno;
    }
    public List<Pessoa> listar() throws SQLException {

        String sql = "SELECT * FROM pessoa";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        List<Pessoa> retorno = new ArrayList<Pessoa>();

        while(rs.next()) {
            
                Pessoa tipo = new Pessoa();
            
                
                tipo.setIdentificador(rs.getInt("identificador"));
                tipo.setCPF(rs.getString("cpf"));
                tipo.setNome(rs.getString("nome"));
                retorno.add(tipo);
    }
        return retorno;

    }
}
