package business;

/**
 *
 * @author efapro01.23
 */
public class Carteira {

    private Moeda bitcoin;
    private Moeda ethereum;
    private Tether tether;

    public Carteira(Moeda bitcoin, Moeda ethereum, Tether tether) {
        this.bitcoin = bitcoin;
        this.ethereum = ethereum;
        this.tether = tether;
    }

    public Carteira(Moeda moeda) {

    }

}
