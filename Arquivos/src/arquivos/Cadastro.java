/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquivos;

/**
 *
 * @author CG3040224
 */
public class Cadastro {
    String nome,idade,cpf,rg,data_nasc,sexo,signo,mae,pai,email,senha,cep,endereco,numero,bairro,cidade,estado,telefone_fixo,celular,altura,peso,tipo_sanguineo,cor;

public Cadastro(String linha) {

    String[] dados = linha.split(","); // separa o CSV

    nome = dados[0];
    idade = dados[1];
    cpf = dados[2];
    rg = dados[3];
    data_nasc = dados[4];
    sexo = dados[5];
    signo = dados[6];
    mae = dados[7];
    pai = dados[8];
    email = dados[9];
    senha = dados[10];
    cep = dados[11];
    endereco = dados[12];
    numero = dados[13];
    bairro = dados[14];
    cidade = dados[15];
    estado = dados[16];
    telefone_fixo = dados[17];
    celular = dados[18];
    altura = dados[19];
    peso = dados[20];
    tipo_sanguineo = dados[21];
    cor = dados[22];
}
    public String getNome() {
        return nome;
    }

    public String getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public String getSigno() {
        return signo;
    }

    public String getMae() {
        return mae;
    }

    public String getPai() {
        return pai;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefone_fixo() {
        return telefone_fixo;
    }

    public String getCelular() {
        return celular;
    }

    public String getAltura() {
        return altura;
    }

    public String getPeso() {
        return peso;
    }

    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", rg=" + rg + ", data_nasc=" + data_nasc + ", sexo=" + sexo + ", signo=" + signo + ", mae=" + mae + ", pai=" + pai + ", email=" + email + ", senha=" + senha + ", cep=" + cep + ", endereco=" + endereco + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", telefone_fixo=" + telefone_fixo + ", celular=" + celular + ", altura=" + altura + ", peso=" + peso + ", tipo_sanguineo=" + tipo_sanguineo + ", cor=" + cor;
    }
    
    
    
}
