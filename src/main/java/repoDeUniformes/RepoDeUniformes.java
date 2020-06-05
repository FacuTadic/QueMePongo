package repoDeUniformes;

import uniforme.Uniforme;

import java.util.ArrayList;
import java.util.List;

public class RepoDeUniformes {

    private List<Uniforme> uniformes = new ArrayList<>();

    public static Uniforme

    public RepoDeUniformes(){
        agregarUniforme();
    }

    public void agregarUniforme(Uniforme uniformeAagregar) {
        uniformes.add(uniformeAagregar);
    }

    public void sacarUniforme(Uniforme uniformeAEliminar) {
        uniformes.remove(uniformeAEliminar);
    }


}
