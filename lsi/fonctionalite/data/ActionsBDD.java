package lsi.fonctionalite.data;

import lsi.fonctionalite.utils.Programmeur;

public interface ActionsBDD {

    public abstract void dataBaseConnection();

    public abstract void dataBaseConnectionEnd();

    public abstract void deleteProgrammeur(int id);

    public abstract void addProgrammeur(Programmeur p);

    public abstract void modifySalaire(int id, float newSalaire);

    public abstract String printAllProgrammeur();

    public abstract String printProgrammeur(int id);

    public abstract String printBestSalaryProgrammeur();

    public abstract String printSameResponsableProgrammeur(String responsable);

    public abstract String printAllResponsable();

    public abstract String printPorgrammerWithSameHobby();

    public abstract void diagramAgeOfProgrammeur();

    public abstract int nombreTotalProgrammeur();

    public abstract float totalSalaire();

    public abstract int ageMoyenneProgrammeur();

    public abstract int[] diagramInterface();

}
