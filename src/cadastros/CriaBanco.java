package cadastros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class CriaBanco {
    
    public static void main(String[] args) {
        
            String nome_base = "cadastros";
            String user = "postgres";
            String pass = "123456";
            String sql = "";

            try {
                
                if (nome_base.equals("") || user.equals("")) {
                    throw new Exception("É necessário informar o nome da base e o nome do usuário!!");
                }

                System.out.println("Conectando o banco... Aguarde");

                // Registrar o driver JDBC para PostgreSQL
                Class.forName("org.postgresql.Driver"); // ou DriverManager.registerDriver(new org.postgresql.Driver());
                // Conectar o banco
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", user, pass);
                // Statement para executar os comandos sql
                Statement statement = conn.createStatement();

                try {
                    System.out.println("Criando Base de dados... ");
                    sql = "CREATE DATABASE " + nome_base;
                    statement.executeUpdate(sql);

                    System.out.println("Base de dados criada com sucesso");

                } catch (Exception e) {
                    System.out.println("Erro ao criar a base" + e.getMessage());
                }

                System.out.println("Acessando a base... Aguarde");

                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nome_base, user, pass);
                statement = conn.createStatement();

                
                // Criação da tabela clientes
                try {
                    System.out.println("Criando tabela 'clientes'... ");
                    
                    sql = "CREATE TABLE clientes(";
                    sql += " id_cliente SERIAL PRIMARY KEY,";
                    sql += " nome VARCHAR(100) NOT NULL,";
                    sql += " sobrenome VARCHAR(100) NOT NULL,";
                    sql += " descricao VARCHAR(50),";
                    sql += " endereco VARCHAR(100) NOT NULL,";
                    sql += " complemento CHAR(10) NOT NULL,";
                    sql += " cidade VARCHAR(100) NOT NULL,";
                    sql += " DDD CHAR(5) NOT NULL,";
                    sql += " telefone CHAR(20) NOT NULL,";
                    sql += " cpf CHAR(20) NOT NULL";
                    sql += ")";

                    statement.executeUpdate(sql);

                    System.out.println("Tabela criada com sucesso");
                } catch (Exception e) {
                    System.out.println("Houve um erro " + e.getMessage());
                }
                
                // Criação da tabela produtos
                try {
                    System.out.println("Criando tabela 'produtos'... ");
                    
                    sql = "CREATE TABLE produtos(";
                    sql +=  " id_produtos SERIAL PRIMARY KEY,";
                    sql +=  " nome VARCHAR(100) NOT NULL,";
                    sql +=  " descricao VARCHAR(100) NOT NULL,";
                    sql +=  " disponibilidade VARCHAR(25) NOT NULL,";
                    sql +=  " valor DECIMAL(12,2) NOT NULL,";
                    sql +=  " fornecedor VARCHAR(100) NOT NULL";
                    sql += ")";

                    statement.executeUpdate(sql);

                    System.out.println("Tabela criada com sucesso");
                } catch (Exception e) {
                    System.out.println("Houve um erro " + e.getMessage());
                }

                // Criação da tabela estoque
                 try {
                    System.out.println("Criando tabela 'estoque'... ");

                    sql = "CREATE TABLE estoque(";
                    sql += "  id_estoque SERIAL PRIMARY KEY,";
                    sql += "  quantidade INT NOT NULL,";
                    sql += "  quantidade_minima INT NOT NULL,";
                    sql += "  data_entrada VARCHAR(25) NOT NULL,";
                    sql += "  data_saida VARCHAR(25) NOT NULL,";
                    sql += "  produto VARCHAR(100) NOT NULL";                    
                    sql += ")";

                    statement.executeUpdate(sql);

                    System.out.println("Tabela criada com sucesso");
                } catch (Exception e) {
                    System.out.println("Houve um erro " + e.getMessage());
                }
                 
                // Criação da tabela fornecedores
                try {
                    System.out.println("Criando tabela 'fornecedores'... ");

                    sql = "CREATE TABLE fornecedores(";
                    sql += "  id_fornecedores SERIAL PRIMARY KEY,";
                    sql += "  nome VARCHAR(100) NOT NULL,";
                    sql += "  sobrenome VARCHAR(100) NOT NULL,";
                    sql += "  endereco VARCHAR(50) NOT NULL,"; 
                    sql += "  complemento CHAR(10) NOT NULL,";
                    sql += "  cidade VARCHAR(100) NOT NULL,";
                    sql += "  DDD CHAR(5) NOT NULL,";
                    sql += "  telefone CHAR(20) NOT NULL,";
                    sql += "  cpf CHAR(20) NOT NULL";
                    sql += ")";

                    statement.executeUpdate(sql);

                    System.out.println("Tabela criada com sucesso");
                } catch (Exception e) {
                    System.out.println("Houve um erro " + e.getMessage());
                }

                // Criação da tabela vendedores
                try {
                    System.out.println("Criando tabela 'vendedores'... ");

                    sql = "CREATE TABLE vendedores(";
                    sql += "  id_vendedores SERIAL PRIMARY KEY,";
                    sql += "  nome VARCHAR(100) NOT NULL,";
                    sql += "  sobrenome VARCHAR(100) NOT NULL,";
                    sql += "  endereco VARCHAR(50) NOT NULL,"; 
                    sql += "  complemento CHAR(10) NOT NULL,";
                    sql += "  cidade VARCHAR(100) NOT NULL,";
                    sql += "  DDD CHAR(5) NOT NULL,";
                    sql += "  telefone CHAR(20) NOT NULL,";
                    sql += "  cpf CHAR(20) NOT NULL,";
                    sql += "  area_de_atuacao VARCHAR(100) NOT NULL";
                    sql += ")";

                    statement.executeUpdate(sql);
                    
                    System.out.println("Tabela criada com sucesso");
                } catch (Exception e) {
                    System.out.println("Houve um erro " + e.getMessage());
                }

            } catch (Exception e) {
                System.out.println("Ocorreu um erro no processo: " + e.getMessage());
            } finally {
                //statement.close();

                //conn.close();
                System.out.println("Processo concluído.");
        }
    }
}
