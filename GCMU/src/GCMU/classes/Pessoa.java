package GCMU.classes;

import java.sql.SQLException;
import java.util.Date;

import GCMU.DataBase.DocenteDAO;

/**
 * 
 * @author GCMU
 *	Essa eh uma classe mae que contem os atributos comuns entre discente e docente 
 */
public class Pessoa {
	private int matricula;
	private String name;
	private String email;
	private int telefone;
        private String permissao;
        
        
        public Pessoa(int matricula, String name, String email, int telefone,String permissao) {
		this.matricula = matricula;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
                this.permissao = permissao;
	}
        public String getPermissao() {
            return permissao;
        }

        public void setPermissao(String permissao) {
            this.permissao = permissao;
        }

	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public Pessoa(){}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}