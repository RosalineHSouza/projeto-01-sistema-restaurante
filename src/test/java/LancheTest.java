import org.example.cardapio.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LancheTest {

    @Test
    public void deveAdicionarValorDoCheddar() {

        ItemCardapio lanche = LancheFactory.xBacon();

        lanche = new ComCheddar(lanche);

        assertEquals(26.0, lanche.getPreco(), 0.001);

        }

    @Test
    public void deveAdicionarCheddarEBaconExtra() {

        ItemCardapio lanche = LancheFactory.xBacon();

        lanche = new ComCheddar(lanche);
        lanche = new ComBaconExtra(lanche);

        assertEquals(32.0, lanche.getPreco(), 0.001);

    }

    @Test
    public void deveAtualizarDescricaoComAdicionais() {

        ItemCardapio lanche = LancheFactory.xBacon();

        lanche = new ComCheddar(lanche);
        lanche = new ComBaconExtra(lanche);

        assertEquals("X-Bacon + Cheddar + Bacon Extra", lanche.getDescricao());

    }

    @Test
    public void deveRetirarQueijoSemAlterarPreco() {

        Lanche lanche = LancheFactory.xBurger();

        lanche.setQueijo(false);

        assertEquals("X-Burger sem queijo", lanche.getDescricao());
        assertEquals(16.0, lanche.getPreco(), 0.001);
    }

}



