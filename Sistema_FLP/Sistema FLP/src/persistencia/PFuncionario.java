package persistencia;

import entidade.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PFuncionario {
    
        public void incluir(Funcionario parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO"
                + " funcionario (cpf, tipo_funcionario) "
                + " VALUES (?,?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getPessoa().getCPF());;
        prd.setString(2, parametro.getTipo_func());
        prd.execute();
        cnn.close();
    }

    public void alterar(Funcionario parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "UPDATE cliente SET"
                + " cpf = ?, "
                + " tipo_func = ? "
                + " WHERE identificador = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getPessoa().getCPF());
        prd.setString(2, parametro.getTipo_func());
        prd.setInt(3, parametro.getIdentificador());
        
        prd.execute();
        cnn.close();
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM funcionario "
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

    public Funcionario consultar(int parametro) throws SQLException {
        
        String sql = "SELECT identificador, cpf, tipo_funcionario"
                + " FROM funcionario WHERE identificador = ?";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);
        
        ResultSet rs = prd.executeQuery();
        
        Funcionario retorno = new Funcionario();
        
        if(rs.next()){
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.getPessoa().setCPF(rs.getString("cpf"));
            retorno.setTipo_func(rs.getString("tipo_funcionario"));
        }
        
        return retorno;
    }
    public List<Funcionario> listar() throws SQLException {

        String sql = "SELECT * FROM funcionario";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        List<Funcionario> retorno = new ArrayList<Funcionario>();

        while(rs.next()) {
            
                Funcionario tipo = new Funcionario();
            
                
                tipo.setIdentificador(rs.getInt("identificador"));
                tipo.getPessoa().setCPF(rs.getString("cpf"));
                tipo.setTipo_func(rs.getString("tipo_funcionario"));
                retorno.add(tipo);
    }
        return retorno;

    }
}