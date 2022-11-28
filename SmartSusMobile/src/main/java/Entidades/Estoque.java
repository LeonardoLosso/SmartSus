package Entidades;

/**
 *
 * @author Leo
 */
public class Estoque {
    private Item item;
    private String Unidade;
    private int quantidade;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getUnidade() {
        return Unidade;
    }

    public void setUnidade(String Unidade) {
        this.Unidade = Unidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
/* SELECTS PARA ESTOQUE
SELECT * FROM vw_Estoque_item_Unidade --TODAS UNIDADES / TODOS ITENS
SELECT * FROM vw_Estoque_item_Unidade WHERE id_Unidade = ? --TODOS ITENS EM 1 UNIDADE
SELECT * FROM vw_Estoque_item_Unidade WHERE finalidade = ? --1 ITEM em TODAS UNIDADES
SELECT * FROM vw_Estoque_item_Unidade WHERE finalidade = ? AND id_Unidade = ? --1 ITEM 1 UNIDADE
*/
    
