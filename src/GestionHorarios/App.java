package GestionHorarios;

import GestionHorarios.src.domain.Estudiante;
import GestionHorarios.src.domain.Horario;
import GestionHorarios.src.domain.Materia;
import GestionHorarios.src.services.GestionHorarios;

public class App {
    public static void main(String[] args) {

        GestionHorarios gestion = new GestionHorarios();

        // Crear horarios
        Horario h1 = new Horario("Lunes", "8-10");
        Horario h3 = new Horario("Lunes", "8-10");
        Horario h2 = new Horario("Miércoles", "10-12");
        Horario h4 = new Horario("Viernes", "10-12");

        // Crear Materias
        Materia MateriaMatematicas = new Materia("Matemáticas", "MAT101", 4);
        Materia MateriaProgramacion = new Materia("Programación", "PRO102", 3);

        // Agregar Horarios
        MateriaMatematicas.agregarHorario(h1);
        MateriaMatematicas.agregarHorario(h2);
        MateriaProgramacion.agregarHorario(h3);
        MateriaProgramacion.agregarHorario(h4);

        // Registrar Materia
        gestion.registrarMateria(MateriaMatematicas);
        gestion.registrarMateria(MateriaProgramacion);

        // Crear estudiante
        Estudiante estudiante1 = new Estudiante("Juan Pérez", "2025001");
        gestion.inscribirEstudiante(estudiante1);

        // Inscribir materias
        try {
            estudiante1.inscribirMateria(MateriaMatematicas, h1);
            estudiante1.inscribirMateria(MateriaProgramacion, h4);
            estudiante1.inscribirMateria(MateriaProgramacion, h3); // <-- Prueba de conflicto
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        estudiante1.mostrarHorarioCompleto();
    }
}