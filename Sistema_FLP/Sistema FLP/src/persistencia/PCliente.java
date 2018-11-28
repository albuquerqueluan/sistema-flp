package persistencia;

import entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PCliente {
    
        public void incluir(Cliente parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "INSERT INTO"
                + " cliente (cpf, num_conta, tipo_conta, saldo) "
                + " VALUES (?,?,?,?)";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getPessoa().getCPF());
        prd.setString(2, parametro.getNum_conta());
        prd.setString(3, parametro.getTipo_conta());
        prd.setDouble(4, parametro.getSaldo());
        prd.execute();
        cnn.close();
    }

    public void alterar(Cliente parametro) throws SQLException {

        //Cria a instrução sql para a inserção de registros
        String sql = "UPDATE cliente SET"
                + " cpf = ?, "
                + " num_conta = ?, "
                + " tipo_conta = ?, "
                + " saldo = ? "
                + " WHERE identificador = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setString(1, parametro.getPessoa().getCPF());
        prd.setString(2, parametro.getNum_conta());
        prd.setString(3, parametro.getTipo_conta());
        prd.setDouble(4, parametro.getSaldo());
        prd.setInt(5, parametro.getIdentificador());
        
        prd.execute();
        cnn.close();
    }

    public void excluir(int parametro) throws SQLException {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM cliente "
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

    public Cliente consultar(int parametro) throws SQLException {
        
        String sql = "SELECT identificador, cpf, num_conta, tipo_conta, saldo"
                + " FROM pessoa WHERE identificador = ?";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);
        
        ResultSet rs = prd.executeQuery();
        
        Cliente retorno = new Cliente();
        
        if(rs.next()){
            retorno.setIdentificador(rs.getInt("identificador"));
            retorno.getPessoa().setCPF(rs.getString("cpf"));
            retorno.setNum_conta(rs.getString("num_conta"));
            retorno.setTipo_conta(rs.getString("tipo_conta"));
            retorno.setSaldo((int) rs.getDouble("saldo"));
        }
        
        return retorno;
    }
    public List<Cliente> listar() throws SQLException {

        String sql = "SELECT * FROM cliente";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        List<Cliente> retorno = new ArrayList<Cliente>();

        while(rs.next()) {
            
                Cliente tipo = new Cliente();
            
                
                tipo.setIdentificador(rs.getInt("identificador"));
                tipo.getPessoa().setCPF(rs.getString("cpf"));
                tipo.setNum_conta(rs.getString("num_conta"));
                tipo.setTipo_conta(rs.getString("tipo_conta"));
                tipo.setSaldo((int) rs.getDouble("saldo"));
                retorno.add(tipo);
    }
        return retorno;

    }
}