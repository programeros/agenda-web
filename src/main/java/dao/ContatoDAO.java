
package dao;

import java.util.List;
import model.Contato;

public interface ContatoDAO {
    public void inserir(Contato contato);
    public List<Contato> listarContatos();
    public void alterar(Contato contato);
   public Contato selecionar(Long id);
    public Contato Remove(Long id);
}
