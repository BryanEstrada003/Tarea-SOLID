/**
 * classe que representa o modelo de projeto
 */
package Model;

public class GTAProductos extends GestTrazAqui {

    /**
     * adiciona produto
     * @param prod produto
     */
    public void addProduto(Produto prod) {
        produtos.put(prod.getProdCode(), prod);
    }

    /**
     * devolve nome do produto
     * @param prodCode  prodCode
     * @return          nome
     */
    public String getProdName(String prodCode) {
        return produtos.get(prodCode).getName();
    }

    /**
     * devolve peso do produto
     * @param prodCode  prodCode
     * @return          nome
     */
    public double getProdWeight(String prodCode) {
        return produtos.get(prodCode).getWeight();
    }

    /**
     * devolve preço do produto
     * @param prodCode  prodCode
     * @return          nome
     */
    public double getProdPrice(String prodCode) {
        return produtos.get(prodCode).getPrice();
    }

    /**
     * verifica se o produto é médico
     * @param prodCode  prodCode
     * @return          nome
     */
    public boolean getProdisMedic(String prodCode) {
        return produtos.get(prodCode).isMedic();
    }

    
}
