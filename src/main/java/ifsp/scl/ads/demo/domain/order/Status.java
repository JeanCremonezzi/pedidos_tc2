package ifsp.scl.ads.demo.domain.order;

import java.util.Arrays;

public enum Status {
    PENDING("Pending"), // PENDENTE
    PREPARING("Preparing"), // PREPARANDO
    FINISHED("Finished"), // FINALIZADO
    IN_ROUTE("In route"), // EM ROTA DE ENTREGA
    DELIVERED("Delivered"); // ENTREGUE

    public final String label;

    Status(String label) {
        this.label = label;
    }

    public static Status fromString(String label) {
        for (Status e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }

        return null;
    }
}