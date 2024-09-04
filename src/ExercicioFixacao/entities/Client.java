package ExercicioFixacao.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    private String name;
    private String email;
    LocalDate birthDate;

    public Client(){}

    public Client(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return name +
                " (" +
                birthDate.format(dtf) +
                ")" +
                " - " +
                email;
    }
}
