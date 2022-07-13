import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    /*
    Francesca va al supermercato e compra della frutta: 1 kg di mele rosse (costo 1 euro), 1,5 kg di mele bianche
(costo 2 euro), 1 kg di fragole (costo 2 euro), 2 kg di ciliege (costo 1 euro e 50 cent), 1.5 kg di ciliegino(costo 3
euro), 1.5 kg di kiwi (costo 1 euro), 1 kg di uva bianca (costo 1 euro).
I. Francesca ha problemi con i colori, e vorrebbe ordinare la frutta sul bancone in base al colore e poi in ordine
alfabetico. Come dovrebbe posizionare la frutta?
II. Quanto spende Francesca? Quanto spende solo per le mele?
III. Il fratello di Francesca vorrebbe ricomprare tutta la frutta di colore rosso. Francesca gli fa un rincaro di 50
centesimo per ogni tipo di frutta. Quanto viene a costare al fratello
     */
    public static void main(String[] args) {
        Colore rosso = new Colore("rosso");
        Colore giallo = new Colore("giallo");
        Frutta f1 = new Frutta("f1", 10, rosso, 5);
        Frutta f2 = new Frutta("f2", 10, rosso, 4);
        Frutta f3 = new Frutta("f3", 10, giallo, 3);
        Frutta f4 = new Frutta("f4", 10, rosso, 1.4);
        Frutta f5 = new Mela("mela", 20, rosso, 2);

        List<Frutta> list = Arrays.asList(f1, f2, f3, f5, f4);
        list
                .stream()
                .collect(Collectors.groupingBy(Frutta::getColor))
                .forEach(((colore, frutta) -> {
                    System.out.println(colore + " " + frutta
                            .stream()
                            .sorted((fr1, fr2) -> fr1.getName().compareTo(fr2.getName()))
                            .collect(Collectors.toList()));
                }));

        System.out.println("-------------------");
        //II. Quanto spende Francesca? Quanto spende solo per le mele?
        System.out.println("Francesca spende: " + list.stream()
                .mapToDouble(frutta -> frutta.getPrice())
                .sum());

        System.out.println("Francesca spende per le mele: " + list.stream()
                .filter(frutta -> frutta instanceof Mela)
                .mapToDouble(frutta -> frutta.getPrice())
                .sum());


        //Il fratello di Francesca vorrebbe ricomprare tutta la frutta di colore rosso. Francesca gli fa un rincaro di 50
        //centesimo per ogni tipo di frutta. Quanto viene a costare al fratello
        System.out.println("Costo toale: " + list
                .stream()
                .filter(frutta -> frutta.getColor().equals(rosso))
                //.map(frutta -> frutta.getPrice() + 0.5)
                .mapToDouble(frutta -> frutta.getPrice() + 0.5)
                .sum());
    }
}
